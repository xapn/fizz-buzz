package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_get_number_given_not_multiple_of_3_or_5() {
        assertThat(fizzBuzz.of(1)).isEqualTo(String.valueOf(1));
    }

    @Test
    public void should_get_fizz_given_3_as_number() {
        assertThat(fizzBuzz.of(3)).isEqualTo(FIZZ);
    }

    @Test
    public void should_get_fizz_given_number_multiple_of_3() {
        assertThat(fizzBuzz.of(6)).isEqualTo(FIZZ);
    }

    @Test
    public void should_get_buzz_given_5_as_number() {
        assertThat(fizzBuzz.of(5)).isEqualTo(BUZZ);
    }

    @Test
    public void should_get_buzz_given_number_multiple_of_5() {
        assertThat(fizzBuzz.of(10)).isEqualTo(BUZZ);
    }
}