package software.works.fizzbuzz.rule;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import software.works.fizzbuzz.Player;

public class VariationsCombiningPlayer implements Player {

    private List<FizzBuzzPredicate> allPredicates;

    public VariationsCombiningPlayer(List<Player> players) {
        allPredicates = recordPredicates(players);
    }

    private List<FizzBuzzPredicate> recordPredicates(List<Player> players) {
        List<FizzBuzzPredicate> allPredicates = new ArrayList<>();

        for (int index = 0; index < maximalNumberOfPredicatesByPlayer(players).get(); index++) {
            allPredicates.addAll(onePredicateByPlayer(index, players));
        }

        return allPredicates;
    }

    private Optional<Integer> maximalNumberOfPredicatesByPlayer(List<Player> players) {
        return players.stream() //
                .map(player -> ((AbstractPlayer) player).getPredicates().size()) //
                .max(Comparator.naturalOrder());
    }

    private List<FizzBuzzPredicate> onePredicateByPlayer(int index, List<Player> players) {
        List<FizzBuzzPredicate> predicatesOneByPlayer = new ArrayList<>(players.size());

        for (Player player : players) {
            List<FizzBuzzPredicate> playerPredicates = ((AbstractPlayer) player).getPredicates();
            if (index < playerPredicates.size()) {
                predicatesOneByPlayer.add(playerPredicates.get(index));
            }
        }

        return predicatesOneByPlayer;
    }

    FizzBuzzPredicate wordIf(String word, Predicate<Integer> predicate) {
        return (value) -> predicate.test(value) ? word : "";
    }

    @Override
    public String playAtFizzBuzz(int value) {
        return allPredicates.stream() //
                .map(predicate -> predicate.fizzBuzzOf(value)) //
                .collect(joining());
    }
}