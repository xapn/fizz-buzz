package software.works.fizzbuzz.rule;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public class Word implements WordPropertyPair {

    private static final String NO_WORD = "";

    private String word;
    private BigInteger property;

    public Word(String word, BigInteger property) {
        this.word = word;
        this.property = property;
        validate();
    }

    private void validate() {
        if (word == null || word.isEmpty() || property.signum() == -1) {
            throw new IllegalStateException("Invalid word: '" + word
                    + "' must be a word associated to a positive integer '" + property + "' as property!");
        }
    }

    FizzBuzzFunction ifNumberSatisfies(NumberPredicate predicate) {
        return value -> predicate.appliedTo(property).test(value) ? word : NO_WORD;
    }

    FizzBuzzFunction ifNumberSatisfies(List<NumberPredicate> numberPredicates) {
        Optional<BiPredicate<BigInteger, BigInteger>> merged = numberPredicates.stream() //
                .map(p -> p.getPropertyPredicate()) //
                .reduce((result, current) -> result.or(current));
        return this.ifNumberSatisfies(merged.get());
    }

    private FizzBuzzFunction ifNumberSatisfies(BiPredicate<BigInteger, BigInteger> predicate) {
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
    public BigInteger getProperty() {
        return property;
    }
}