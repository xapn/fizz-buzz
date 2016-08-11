package software.works.fizzbuzz;

import static java.lang.Math.max;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import software.works.fizzbuzz.rule.FunctionTypes.PropertyPredicate;;

public class FizzBuzzUsingCustomPredicatesTest {

    private FizzBuzz fizzBuzz;

    private PropertyPredicate itContainsDigitSequence = (value, property) -> {
        List<String> digits = Arrays.asList(String.valueOf(value).split(""));
        int sequenceLength = 0, maxSequenceLength = 0;

        for (int index = 1; index < digits.size(); index++) {
            if (Integer.parseInt(digits.get(index)) == 1 + Integer.parseInt(digits.get(index - 1))) {
                sequenceLength = sequenceLength == 0 ? 2 : sequenceLength + 1;
            } else {
                sequenceLength = 0;
                maxSequenceLength = maxSequenceLength == property ? maxSequenceLength : 0;
            }
            maxSequenceLength = max(sequenceLength, maxSequenceLength);
        }

        return maxSequenceLength == property;
    };

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_get_fizz_given_123_as_a_number_being_a_digit_sequence() {
        assertThat(fizzBuzz.word("Fizz", 3).whenNumberSatisfies(itContainsDigitSequence).of(123)).isEqualTo("Fizz");
    }

    @Test
    public void should_get_buzz_given_12345_as_a_number_being_a_digit_sequence() {
        assertThat(fizzBuzz.word("Fizz", 3).word("Buzz", 5).whenNumberSatisfies(itContainsDigitSequence).of(12345))
                .isEqualTo("Buzz");
    }

    @Test
    public void should_get_buzz_given_691123457_as_a_number_containing_a_digit_sequence() {
        assertThat(fizzBuzz.word("Fizz", 3).word("Buzz", 5).whenNumberSatisfies(itContainsDigitSequence).of(691123457))
                .isEqualTo("Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_12345789_as_a_number_containing_2_digit_sequences() {
        assertThat(fizzBuzz.word("Fizz", 3).word("Buzz", 5).whenNumberSatisfies(itContainsDigitSequence).of(12345789))
                .isEqualTo("FizzBuzz");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_fail_given_fizzbuzz_having_to_print_words_n_times() {
        fizzBuzz.wordsNTimes().whenNumberSatisfies(itContainsDigitSequence).of(123123);
    }
}