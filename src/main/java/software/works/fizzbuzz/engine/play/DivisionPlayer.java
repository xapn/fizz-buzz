package software.works.fizzbuzz.engine.play;

import static software.works.fizzbuzz.engine.NumberPredicate.IS_MULTIPLE_OF;

public class DivisionPlayer extends NumberPredicatePlayer {

    public DivisionPlayer() {
        setNumberPredicate(IS_MULTIPLE_OF);
    }
}