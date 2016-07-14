package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicates.IS_MULTIPLE_OF;

import java.util.Arrays;

public class DivisionPlayer extends AbstractPlayer {

    private FizzBuzzPredicate fizzIfMultipleOf3;
    private FizzBuzzPredicate buzzIfMultipleOf5;

    public DivisionPlayer() {
        fizzIfMultipleOf3 = wordIf(FIZZ, IS_MULTIPLE_OF.appliedTo(3));
        buzzIfMultipleOf5 = wordIf(BUZZ, IS_MULTIPLE_OF.appliedTo(5));
        predicates = Arrays.asList( //
                fizzIfMultipleOf3, //
                buzzIfMultipleOf5 //
        );
    }

    @Override
    public String playAtFizzBuzz(int value) {
        Multiple multiple = new Multiple(value);

        String fizzBuzz = multiple.toFizzBuzzIfItSatisfies(fizzIfMultipleOf3)
                + multiple.toFizzBuzzIfItSatisfies(buzzIfMultipleOf5);
        return fizzBuzz.isEmpty() ? multiple.toString() : fizzBuzz;
    }
}