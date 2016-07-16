package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicates.CONTAINS_DIGIT;

import java.util.List;

public class DigitPlayer extends AbstractPlayer {

    static final String FIZZ = "Fizz";
    static final String BUZZ = "Buzz";

    public DigitPlayer() {
        managePredicates();
    }

    @Override
    protected void recordPredicates(List<FizzBuzzPredicate> predicates) {
        predicates.add(wordIf(FIZZ, CONTAINS_DIGIT.appliedTo(3)));
        predicates.add(wordIf(BUZZ, CONTAINS_DIGIT.appliedTo(5)));
    }
}