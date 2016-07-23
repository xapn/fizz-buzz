package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicate.IS_MULTIPLE_OF;

public class DivisionPlayer extends NumberPredicatePlayer {

    public DivisionPlayer() {
        setNumberPredicate(IS_MULTIPLE_OF);
    }
}