package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicate.CONTAINS_DIGIT;

import java.util.List;

public class DigitPlayer extends AbstractPlayer {

    public DigitPlayer() {
        setNumberPredicate(CONTAINS_DIGIT);
    }

    DigitPlayer(List<FizzBuzzPredicate> predicates, PlayerConfiguration configuration) {
        super(predicates, configuration);
        setNumberPredicate(CONTAINS_DIGIT);
    }
}