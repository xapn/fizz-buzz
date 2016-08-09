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

    private PropertyPredicate containsDigitSequence = (value, property) -> {
        List<String> digits = Arrays.asList(String.valueOf(value).split(""));
        int sequenceLength = 0, maxSequenceLength = 0;

        for (int index = 1; index < digits.size(); index++) {
            if (Integer.parseInt(digits.get(index)) == 1 + Integer.parseInt(digits.get(index - 1))) {
                sequenceLength = sequenceLength == 0 ? 2 : sequenceLength + 1;
            } else {
                sequenceLength = 0;
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
        assertThat(fizzBuzz.word("Fizz", 3).whenNumberSatisfies(containsDigitSequence).of(123)).isEqualTo("Fizz");
    }

    @Test
    public void should_get_buzz_given_12345_as_a_number_being_a_digit_sequence() {
        assertThat(fizzBuzz.word("Fizz", 3).word("Buzz", 5).whenNumberSatisfies(containsDigitSequence).of(12345))
                .isEqualTo("Buzz");
    }

    @Test
    public void should_get_buzz_given_691123457_as_a_number_containing_a_digit_sequence() {
        assertThat(fizzBuzz.word("Fizz", 3).word("Buzz", 5).whenNumberSatisfies(containsDigitSequence).of(691123457))
                .isEqualTo("Buzz");
    }
}