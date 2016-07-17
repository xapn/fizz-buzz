package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicates.IS_MULTIPLE_OF;

import java.util.List;

public class DivisionPlayer extends AbstractPlayer {

    @Override
    protected void recordPredicates(List<FizzBuzzPredicate> predicates) {
        words.stream().forEachOrdered(word -> {
            predicates.add(wordIf(word.getWord(), IS_MULTIPLE_OF.appliedTo(word.getNumber())));
        });
    }
}