package software.works.fizzbuzz.engine;

import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public interface FunctionTypes {

    static interface PropertyPredicate extends BiPredicate<BigInteger, BigInteger> {}

    static interface WordOccurrencesFunction extends BiFunction<BigInteger, WordPropertyPair, String> {}

    static interface ValuePredicate extends Predicate<BigInteger> {}
}