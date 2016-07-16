package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzWhenNumberContainsDigitsTest {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = "FizzBuzz";

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz().whenNumberContainsDigits();
    }

    @Test
    public void should_get_number_given_it_contains_no_3_neither_5() {
        assertThat(fizzBuzz.of(1)).isEqualTo(String.valueOf(1));
    }

    @Test
    public void should_get_fizz_given_3_as_number() {
        assertThat(fizzBuzz.of(3)).isEqualTo(FIZZ);
    }

    @Test
    public void should_get_fizz_given_number_containing_3() {
        assertThat(fizzBuzz.of(13)).isEqualTo(FIZZ);
    }

    @Test
    public void should_get_buzz_given_5_as_number() {
        assertThat(fizzBuzz.of(5)).isEqualTo(BUZZ);
    }

    @Test
    public void should_get_buzz_given_number_containing_5() {
        assertThat(fizzBuzz.of(15)).isEqualTo(BUZZ);
    }

    @Test
    public void should_get_fizzbuzz_given_35_as_number() {
        assertThat(fizzBuzz.of(35)).isEqualTo(FIZZ_BUZZ);
    }

    @Test
    public void should_get_fizzbuzz_given_number_contains_both_3_and_5() {
        assertThat(fizzBuzz.of(1345)).isEqualTo(FIZZ_BUZZ);
    }

    @Test
    public void should_get_fizzbuzz_given_number_contains_both_3_and_5_in_any_order() {
        assertThat(fizzBuzz.of(4513)).isEqualTo(FIZZ_BUZZ);
    }

    @Test
    public void should_get_fizz_and_buzz_and_fizzbuzz_and_numbers_given_a_range_of_numbers() {
        assertThat(fizzBuzz.from(1).to(45)).isEqualTo(
                "1 2 Fizz 4 Buzz 6 7 8 9 10 11 12 Fizz 14 Buzz 16 17 18 19 20 21 22 Fizz 24 Buzz 26 27 28 29 Fizz Fizz Fizz Fizz Fizz FizzBuzz Fizz Fizz Fizz Fizz 40 41 42 Fizz 44 Buzz");
    }
}