package software.works.fizzbuzz.rule;

import static java.util.stream.Collectors.joining;
import static software.works.fizzbuzz.rule.NumberPredicates.CONTAINS_DIGIT;
import static software.works.fizzbuzz.rule.NumberPredicates.IS_MULTIPLE_OF;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import software.works.fizzbuzz.Player;

public class VariationsCombiningPlayer implements Player {

    private FizzBuzzPredicate fizzIfMultipleOf3 = wordIf(FIZZ, IS_MULTIPLE_OF.appliedTo(3));
    private FizzBuzzPredicate buzzIfMultipleOf5 = wordIf(BUZZ, IS_MULTIPLE_OF.appliedTo(5));
    private FizzBuzzPredicate fizzIfContains3 = wordIf(FIZZ, CONTAINS_DIGIT.appliedTo(3));
    private FizzBuzzPredicate buzzIfContains5 = wordIf(BUZZ, CONTAINS_DIGIT.appliedTo(5));
    private List<FizzBuzzPredicate> predicates = Arrays.asList( //
            fizzIfMultipleOf3, fizzIfContains3, //
            buzzIfMultipleOf5, buzzIfContains5);

    private Collection<Player> players;

    @Deprecated
    public VariationsCombiningPlayer(Collection<Player> players) {
        this.players = players;
    }

    FizzBuzzPredicate wordIf(String word, Predicate<Integer> predicate) {
        return (value) -> predicate.test(value) ? word : "";
    }

    @Override
    public String playAtFizzBuzz(int value) {
        return predicates.stream() //
                .map(predicate -> predicate.fizzBuzz(value)) //
                .collect(joining());
    }
}