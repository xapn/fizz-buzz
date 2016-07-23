package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzPopWhackZingChopVariationTest {

    private FizzBuzz fizzBuzzPopWhackZingChop;

    @Before
    public void prepareFixtures() {
        fizzBuzzPopWhackZingChop = new FizzBuzz().popWhackZingChop();
    }

    @Test
    public void should_get_fizz_given_3_as_number() {
        assertThat(fizzBuzzPopWhackZingChop.of(3)).isEqualTo("Fizz");
    }

    @Test
    public void should_get_number_given_31_as_number() {
        assertThat(fizzBuzzPopWhackZingChop.of(31)).isEqualTo("31");
    }

    @Test
    public void should_get_buzz_given_5_as_number() {
        assertThat(fizzBuzzPopWhackZingChop.of(5)).isEqualTo("Buzz");
    }

    @Test
    public void should_get_pop_given_7_as_number() {
        assertThat(fizzBuzzPopWhackZingChop.of(7)).isEqualTo("Pop");
    }
}