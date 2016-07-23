package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzPopWhackVariationTest {
    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_get_fizz_given_3_as_number() {
        assertThat(fizzBuzz.popWhack().of(3)).isEqualTo("Fizz");
    }

    @Test
    public void should_get_number_given_31_as_number() {
        assertThat(fizzBuzz.popWhack().of(31)).isEqualTo("31");
    }

    @Test
    public void should_get_buzz_given_5_as_number() {
        assertThat(fizzBuzz.popWhack().of(5)).isEqualTo("Buzz");
    }
}