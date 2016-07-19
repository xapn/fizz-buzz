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
}