package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicate.IS_MULTIPLE_OF;

public class DivisionPlayer extends AbstractPlayer {

    public DivisionPlayer() {
        setNumberPredicate(IS_MULTIPLE_OF);
    }
}