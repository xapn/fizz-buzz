package software.works.fizzbuzz.rule;

abstract class NumberPredicatePlayer extends OrdinaryPlayer {

    private NumberPredicate numberPredicate;

    NumberPredicate getNumberPredicate() {
        return numberPredicate;
    }

    protected void setNumberPredicate(NumberPredicate numberPredicate) {
        this.numberPredicate = numberPredicate;
    }
}