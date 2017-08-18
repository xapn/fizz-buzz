package software.works.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import software.works.fizzbuzz.engine.FunctionTypes.PropertyPredicate;
import testasyouthink.GivenWhenThenDsl.PreparationStage.Given;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;
import static testasyouthink.TestAsYouThink.givenSutClass;

;

public class FizzBuzzPlayingWithCustomPredicatesTest {

    private Given<FizzBuzz> givenFizzBuzzAsSut;

    private PropertyPredicate itContainsDigitSequence = (value, property) -> {
        List<String> digits = Arrays.asList(String
                .valueOf(value)
                .split(""));
        int sequenceLength = 0, maxSequenceLength = 0;

        for (int index = 1; index < digits.size(); index++) {
            if (Integer.parseInt(digits.get(index)) == 1 + Integer.parseInt(digits.get(index - 1))) {
                sequenceLength = sequenceLength == 0 ? 2 : sequenceLength + 1;
            } else {
                sequenceLength = 0;
                maxSequenceLength = property.equals(BigInteger.valueOf(maxSequenceLength)) ? maxSequenceLength : 0;
            }
            maxSequenceLength = max(sequenceLength, maxSequenceLength);
        }

        return property.equals(BigInteger.valueOf(maxSequenceLength));
    };

    @Before
    public void prepareFixtures() {
        givenFizzBuzzAsSut = givenSutClass(FizzBuzz.class);
    }

    @Test
    public void should_get_fizz_given_123_as_a_number_being_a_digit_sequence() {
        givenFizzBuzzAsSut
                .given(sut -> sut
                        .word("Fizz", 3)
                        .whenNumberSatisfies(itContainsDigitSequence))
                .whenSutReturns(sut -> sut.of(123))
                .then("Fizz"::equals);
    }

    @Test
    public void should_get_buzz_given_12345_as_a_number_being_a_digit_sequence() {
        givenFizzBuzzAsSut
                .given(sut -> sut
                        .word("Fizz", 3)
                        .word("Buzz", 5)
                        .whenNumberSatisfies(itContainsDigitSequence))
                .whenSutReturns(sut -> sut.of(12345))
                .then("Buzz"::equals);
    }

    @Test
    public void should_get_buzz_given_691123457_as_a_number_containing_a_digit_sequence() {
        givenFizzBuzzAsSut
                .given(sut -> sut
                        .word("Fizz", 3)
                        .word("Buzz", 5)
                        .whenNumberSatisfies(itContainsDigitSequence))
                .whenSutReturns(sut -> sut.of(691123457))
                .then("Buzz"::equals);
    }

    @Test
    public void should_get_fizzbuzz_given_12345789_as_a_number_containing_2_digit_sequences() {
        givenFizzBuzzAsSut
                .given(sut -> sut
                        .word("Fizz", 3)
                        .word("Buzz", 5)
                        .whenNumberSatisfies(itContainsDigitSequence))
                .whenSutReturns(sut -> sut.of(12345789))
                .then("FizzBuzz"::equals);
    }

    @Test
    public void should_fail_given_fizzbuzz_having_to_print_words_n_times() {
        givenFizzBuzzAsSut
                .whenSutRunsOutsideOperatingConditions(sut -> sut
                        .wordsNTimes()
                        .whenNumberSatisfies(itContainsDigitSequence)
                        .of(123123))
                .thenItFails()
                .becauseOf(UnsupportedOperationException.class);
    }
}