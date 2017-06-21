package software.works.fizzbuzz.engine;

import software.works.fizzbuzz.engine.FunctionTypes.PropertyPredicate;
import software.works.fizzbuzz.engine.FunctionTypes.ValuePredicate;
import software.works.fizzbuzz.engine.FunctionTypes.WordOccurrencesFunction;

import java.math.BigInteger;
import java.util.function.BiPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.math.BigInteger.ZERO;

public class NumberPredicate {

    public static final NumberPredicate IS_MULTIPLE_OF = new NumberPredicate((value, factor) -> value
            .mod(factor)
            .equals(ZERO),

            (value, pair) -> {
                StringBuilder words = new StringBuilder();
                BigInteger remaining = value;
                while (remaining
                        .mod(pair.getProperty())
                        .equals(ZERO)) {
                    words.append(pair.getWord());
                    remaining = remaining.divide(pair.getProperty());
                }
                return words.toString();
            });

    public static final NumberPredicate CONTAINS_DIGIT = new NumberPredicate((value, digit) -> String
            .valueOf(value)
            .contains(String.valueOf(digit)),

            (value, pair) -> {
                StringBuilder words = new StringBuilder();
                Matcher digitMatcher = Pattern
                        .compile(pair
                                .getProperty()
                                .toString())
                        .matcher(value.toString());
                while (digitMatcher.find()) {
                    words.append(pair.getWord());
                }
                return words.toString();
            });

    private PropertyPredicate propertyPredicate;
    private WordOccurrencesFunction wordOccurrencesFunction;

    public NumberPredicate(PropertyPredicate propertyPredicate, WordOccurrencesFunction wordOccurrencesFunction) {
        this.propertyPredicate = propertyPredicate;
        this.wordOccurrencesFunction = wordOccurrencesFunction;
    }

    public ValuePredicate appliedTo(BigInteger property) {
        return value -> propertyPredicate.test(value, property);
    }

    public BiPredicate<BigInteger, BigInteger> getPropertyPredicate() {
        return propertyPredicate;
    }

    public WordOccurrencesFunction toWordOccurrences() {
        return wordOccurrencesFunction;
    }
}