package software.works.fizzbuzz.engine;

import static software.works.fizzbuzz.engine.NumberPredicate.CONTAINS_DIGIT;

public class DigitPlayer extends NumberPredicatePlayer {

    public DigitPlayer() {
        setNumberPredicate(CONTAINS_DIGIT);
    }
}