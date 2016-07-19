package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzWordsPrintedOnlyOnceTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz() //
                .wordsOnlyOnce() //
                .whenNumberHasFactors() //
                .whenNumberContainsDigits();
    }

    @Test
    public void should_get_fizz_given_3_as_number_containing_and_divisible_by_3() {
        assertThat(fizzBuzz.of(3)).isEqualTo("Fizz");
    }

    @Test
    public void should_get_fizzbuzz_given_some_arbitrary_numbers() {
        assertThat(fizzBuzz.of(45, 315)).isEqualTo("FizzBuzz FizzBuzz");
    }

    @Test
    public void should_get_fizz_or_buzz_given_a_range_of_numbers() {
        assertThat(fizzBuzz.from(1).to(15)).isEqualTo("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz Fizz 14 FizzBuzz");
    }
}