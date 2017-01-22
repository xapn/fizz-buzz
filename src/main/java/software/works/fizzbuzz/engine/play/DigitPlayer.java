package software.works.fizzbuzz.engine.play;

import static software.works.fizzbuzz.engine.NumberPredicate.CONTAINS_DIGIT;

public class DigitPlayer extends NumberPredicatePlayer {

    public DigitPlayer() {
        setNumberPredicate(CONTAINS_DIGIT);
    }
}