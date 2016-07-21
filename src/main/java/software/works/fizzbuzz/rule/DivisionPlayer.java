package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicate.IS_MULTIPLE_OF;

import java.util.List;

public class DivisionPlayer extends AbstractPlayer {

    public DivisionPlayer() {
        setNumberPredicate(IS_MULTIPLE_OF);
    }

    DivisionPlayer(List<FizzBuzzPredicate> predicates, PlayerConfiguration configuration) {
        super(predicates, configuration);
        setNumberPredicate(IS_MULTIPLE_OF);
    }
}