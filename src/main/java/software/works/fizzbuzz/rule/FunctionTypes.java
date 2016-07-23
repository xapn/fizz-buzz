package software.works.fizzbuzz.rule;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

interface FunctionTypes {

    static interface PropertyPredicate extends BiPredicate<Integer, Integer> {}

    static interface WordOccurrencesFunction extends BiFunction<Integer, WordPropertyPair, String> {}

    static interface ValuePredicate extends Predicate<Integer> {}
}