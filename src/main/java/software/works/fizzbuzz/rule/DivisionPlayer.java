package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicates.IS_MULTIPLE_OF;

import java.util.List;

public class DivisionPlayer extends AbstractPlayer {

    public DivisionPlayer() {
        managePredicates();
    }

    @Override
    protected void recordPredicates(List<FizzBuzzPredicate> predicates) {
        predicates.add(wordIf(FIZZ, IS_MULTIPLE_OF.appliedTo(3)));
        predicates.add(wordIf(BUZZ, IS_MULTIPLE_OF.appliedTo(5)));
    }
}