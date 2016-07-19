package software.works.fizzbuzz.rule;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

class Word {

    private String word;
    private int property;

    Word(String word, int property) {
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

    FizzBuzzPredicate ifNumberSatisfies(NumberPredicate predicate) {
        return value -> predicate.appliedTo(property).test(value) ? word : "";
    }

    FizzBuzzPredicate ifNumberSatisfies(List<NumberPredicate> numberPredicates) {
        Optional<BiPredicate<Integer, Integer>> merged = numberPredicates.stream() //
                .map(p -> p.getPredicate()) //
                .reduce((result, current) -> result.or(current));
        return this.ifNumberSatisfies(merged.get());
    }

    private FizzBuzzPredicate ifNumberSatisfies(BiPredicate<Integer, Integer> predicate) {
        return value -> predicate.test(value, property) ? word : "";
    }

    @Override
    public String toString() {
        return String.format("{word: %s, property: %d}", word, property);
    }
}