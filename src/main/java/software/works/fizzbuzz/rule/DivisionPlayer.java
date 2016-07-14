package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicates.IS_MULTIPLE_OF;

import java.util.Arrays;

public class DivisionPlayer extends AbstractPlayer {

    public DivisionPlayer() {
        predicates = Arrays.asList( //
                wordIf(FIZZ, IS_MULTIPLE_OF.appliedTo(3)), //
                wordIf(BUZZ, IS_MULTIPLE_OF.appliedTo(5)) //
        );
    }
}