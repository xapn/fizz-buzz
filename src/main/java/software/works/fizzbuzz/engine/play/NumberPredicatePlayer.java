package software.works.fizzbuzz.engine.play;

import software.works.fizzbuzz.engine.NumberPredicate;

public abstract class NumberPredicatePlayer extends OrdinaryPlayer {

    private NumberPredicate numberPredicate;

    public NumberPredicate getNumberPredicate() {
        return numberPredicate;
    }

    protected void setNumberPredicate(NumberPredicate numberPredicate) {
        this.numberPredicate = numberPredicate;
    }
}