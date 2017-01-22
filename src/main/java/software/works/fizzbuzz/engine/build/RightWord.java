package software.works.fizzbuzz.engine.build;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

import software.works.fizzbuzz.engine.FizzBuzzFunction;
import software.works.fizzbuzz.engine.NumberPredicate;
import software.works.fizzbuzz.engine.lexicon.WordPropertyPair;

class RightWord {

    private static final String NO_WORD = "";

    private WordPropertyPair pair;

    RightWord(WordPropertyPair pair) {
        this.pair = pair;
    }

    FizzBuzzFunction ifNumberSatisfies(NumberPredicate predicate) {
        return value -> predicate.appliedTo(pair.getProperty()).test(value) ? pair.getWord() : NO_WORD;
    }

    FizzBuzzFunction ifNumberSatisfies(List<NumberPredicate> numberPredicates) {
        Optional<BiPredicate<BigInteger, BigInteger>> merged = numberPredicates.stream() //
                .map(predicate -> predicate.getPropertyPredicate()) //
                .reduce((result, current) -> result.or(current));
        return this.ifNumberSatisfies(merged.get());
    }

    private FizzBuzzFunction ifNumberSatisfies(BiPredicate<BigInteger, BigInteger> predicate) {
        return value -> predicate.test(value, pair.getProperty()) ? pair.getWord() : NO_WORD;
    }

    FizzBuzzFunction nTimesIfNumberSatisfies(NumberPredicate numberPredicate) {
        return value -> numberPredicate.toWordOccurrences().apply(value, pair);
    }
}