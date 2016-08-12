package software.works.fizzbuzz.rule;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public class Word implements WordPropertyPair {

    private static final String NO_WORD = "";

    private String word;
    private int property;

    public Word(String word, int property) {
        this.word = word;
        this.property = property;
        validate();
    }

    private void validate() {
        if (word == null || word.isEmpty() || property < 0) {
            throw new IllegalStateException("Invalid word: '" + word
                    + "' must be a word associated to a positive integer '" + property + "' as property!");
        }
    }

    FizzBuzzFunction ifNumberSatisfies(NumberPredicate predicate) {
        return value -> predicate.appliedTo(property).test(value) ? word : NO_WORD;
    }

    FizzBuzzFunction ifNumberSatisfies(List<NumberPredicate> numberPredicates) {
        Optional<BiPredicate<Long, Integer>> merged = numberPredicates.stream() //
                .map(p -> p.getPropertyPredicate()) //
                .reduce((result, current) -> result.or(current));
        return this.ifNumberSatisfies(merged.get());
    }

    private FizzBuzzFunction ifNumberSatisfies(BiPredicate<Long, Integer> predicate) {
        return value -> predicate.test(value, property) ? word : NO_WORD;
    }

    FizzBuzzFunction nTimesIfNumberSatisfies(NumberPredicate numberPredicate) {
        return value -> numberPredicate.toWordOccurrences().apply(value, this);
    }

    @Override
    public String toString() {
        return String.format("{word: %s, property: %d}", word, property);
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getProperty() {
        return property;
    }
}