package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicates.CONTAINS_DIGIT;

import java.util.Arrays;

public class DigitPlayer extends AbstractPlayer {

    private FizzBuzzPredicate fizzIfContains3;
    private FizzBuzzPredicate buzzIfContains5;

    public DigitPlayer() {
        fizzIfContains3 = wordIf(FIZZ, CONTAINS_DIGIT.appliedTo(3));
        buzzIfContains5 = wordIf(BUZZ, CONTAINS_DIGIT.appliedTo(5));
        predicates = Arrays.asList( //
                fizzIfContains3, //
                buzzIfContains5 //
        );
    }

    @Override
    public String playAtFizzBuzz(int value) {
        Digits digits = new Digits(value);

        String fizzBuzz = digits.toFizzBuzzIfItSatisfies(fizzIfContains3)
                + digits.toFizzBuzzIfItSatisfies(buzzIfContains5);
        return fizzBuzz.isEmpty() ? digits.toString() : fizzBuzz;
    }
}