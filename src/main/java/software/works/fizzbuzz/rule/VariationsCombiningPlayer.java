package software.works.fizzbuzz.rule;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import software.works.fizzbuzz.Player;

public class VariationsCombiningPlayer implements Player {

    private List<FizzBuzzPredicate> predicates;

    public VariationsCombiningPlayer(List<Player> players) {
        predicates = new ArrayList<>();
        int numberOfPredicatesByPlayer = ((AbstractPlayer) players.get(0)).getPredicates().size();

        for (int index = 0; index < numberOfPredicatesByPlayer; index++) {
            for (Player player : players) {
                predicates.add(((AbstractPlayer) player).getPredicates().get(index));
            }
        }
    }

    FizzBuzzPredicate wordIf(String word, Predicate<Integer> predicate) {
        return (value) -> predicate.test(value) ? word : "";
    }

    @Override
    public String playAtFizzBuzz(int value) {
        return predicates.stream() //
                .map(predicate -> predicate.fizzBuzzOf(value)) //
                .collect(joining());
    }
}