package software.works.fizzbuzz.rule;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum NumberPredicate {

    IS_MULTIPLE_OF( //
        (value, factor) -> value % factor == 0, //

        (value, pair) -> {
            StringBuilder words = new StringBuilder();
            int remaining = value;
            while (remaining % pair.getProperty() == 0) {
                words.append(pair.getWord());
                remaining /= pair.getProperty();
            }
            return words.toString();
        }), //
    
    CONTAINS_DIGIT( //
        (value, digit) -> String.valueOf(value).contains(String.valueOf(digit)), //

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

    private BiPredicate<Integer, Integer> predicate;
    private BiFunction<Integer, WordPropertyPair, String> words;

    NumberPredicate(BiPredicate<Integer, Integer> predicate, BiFunction<Integer, WordPropertyPair, String> words) {
        this.predicate = predicate;
        this.words = words;
    }

    Predicate<Integer> appliedTo(int property) {
        return value -> predicate.test(value, property);
    }

    BiPredicate<Integer, Integer> getPredicate() {
        return predicate;
    }

    BiFunction<Integer, WordPropertyPair, String> toWords() {
        return words;
    }
}