package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicates.CONTAINS_DIGIT;

import java.util.List;

import software.works.fizzbuzz.Word;

public class DigitPlayer extends AbstractPlayer {

    @Override
    protected void recordPredicates(List<FizzBuzzPredicate> predicates) {
        words.stream().forEachOrdered(word -> {
            predicates.add(wordIf(word.getWord(), CONTAINS_DIGIT.appliedTo(word.getNumber())));
        });
    }
}