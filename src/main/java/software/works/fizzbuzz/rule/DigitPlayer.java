package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicates.CONTAINS_DIGIT;

import java.util.Arrays;

public class DigitPlayer extends AbstractPlayer {

    public DigitPlayer() {
        predicates = Arrays.asList( //
                wordIf(FIZZ, CONTAINS_DIGIT.appliedTo(3)), //
                wordIf(BUZZ, CONTAINS_DIGIT.appliedTo(5)) //
        );
    }
}