package software.works.fizzbuzz.rule;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

interface WordPropertyPair {

    // Later refactoring: was private.
    static final String NO_WORD = "";

    String getWord();

    BigInteger getProperty();

    // TODO: All following default methods will be moved after a later
    // refactoring.

    // Later refactoring: was package-friendly.
    default FizzBuzzFunction ifNumberSatisfies(NumberPredicate predicate) {
        return value -> predicate.appliedTo(getProperty()).test(value) ? getWord() : NO_WORD;
    }

    // Later refactoring: was package-friendly.
    default FizzBuzzFunction ifNumberSatisfies(List<NumberPredicate> numberPredicates) {
        Optional<BiPredicate<BigInteger, BigInteger>> merged = numberPredicates.stream() //
                .map(p -> p.getPropertyPredicate()) //
                .reduce((result, current) -> result.or(current));
        return this.ifNumberSatisfies(merged.get());
    }

    // Later refactoring: was private.
    default FizzBuzzFunction ifNumberSatisfies(BiPredicate<BigInteger, BigInteger> predicate) {
        return value -> predicate.test(value, getProperty()) ? getWord() : NO_WORD;
    }

    // Later refactoring: was package-friendly.
    default FizzBuzzFunction nTimesIfNumberSatisfies(NumberPredicate numberPredicate) {
        return value -> numberPredicate.toWordOccurrences().apply(value, this);
    }
}