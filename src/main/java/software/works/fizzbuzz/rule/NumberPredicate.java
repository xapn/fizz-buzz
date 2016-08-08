package software.works.fizzbuzz.rule;

import java.util.function.BiPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import software.works.fizzbuzz.rule.FunctionTypes.PropertyPredicate;
import software.works.fizzbuzz.rule.FunctionTypes.ValuePredicate;
import software.works.fizzbuzz.rule.FunctionTypes.WordOccurrencesFunction;

public class NumberPredicate {

    static final NumberPredicate IS_MULTIPLE_OF = new NumberPredicate( //
            (value, factor) -> value % factor == 0,

            (value, pair) -> {
                StringBuilder words = new StringBuilder();
                int remaining = value;
                while (remaining % pair.getProperty() == 0) {
                    words.append(pair.getWord());
                    remaining /= pair.getProperty();
                }
                return words.toString();
            });

    static final NumberPredicate CONTAINS_DIGIT = new NumberPredicate( //
            (value, digit) -> String.valueOf(value).contains(String.valueOf(digit)),

            (value, pair) -> {
                StringBuilder words = new StringBuilder();
                Matcher digitMatcher = Pattern //
                        .compile(String.valueOf(pair.getProperty())) //
                        .matcher(String.valueOf(value));
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

    ValuePredicate appliedTo(int property) {
        return value -> propertyPredicate.test(value, property);
    }

    BiPredicate<Integer, Integer> getPropertyPredicate() {
        return propertyPredicate;
    }

    WordOccurrencesFunction toWordOccurrences() {
        return wordOccurrencesFunction;
    }
}