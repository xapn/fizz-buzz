package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicate.CONTAINS_DIGIT;

public class DigitPlayer extends NumberPredicatePlayer {

    public DigitPlayer() {
        setNumberPredicate(CONTAINS_DIGIT);
    }
}