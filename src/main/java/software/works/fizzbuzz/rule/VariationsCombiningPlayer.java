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

        Optional<Integer> numberOfPredicatesByPlayer = players.stream() //
                .map(player -> ((AbstractPlayer) player).getPredicates().size()) //
                .max(Comparator.naturalOrder());

        for (int index = 0; index < numberOfPredicatesByPlayer.get(); index++) {
            for (Player player : players) {
                List<FizzBuzzPredicate> playerPredicates = ((AbstractPlayer) player).getPredicates();
                if (index < playerPredicates.size()) {
                    allPredicates.add(playerPredicates.get(index));
                }
            }
        }

        return allPredicates;
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