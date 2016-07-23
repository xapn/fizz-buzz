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

    @Test
    public void should_get_zing_given_8_as_number() {
        assertThat(fizzBuzzPopWhackZingChop.of(8)).isEqualTo("Zing");
    }

    @Test
    public void should_get_whack_given_11_as_number() {
        assertThat(fizzBuzzPopWhackZingChop.of(11)).isEqualTo("Whack");
    }

    @Test
    public void should_get_chop_given_13_as_number() {
        assertThat(fizzBuzzPopWhackZingChop.of(13)).isEqualTo("Chop");
    }

    @Test
    public void should_get_fizzbuzzpopwhackzingchop_given_120120_as_number() {
        assertThat(fizzBuzzPopWhackZingChop.of(120120)).isEqualTo("FizzBuzzPopWhackZingChop");
    }

    @Test
    public void should_get_words_given_a_range_of_numbers() {
        assertThat(fizzBuzzPopWhackZingChop.from(1).to(15))
                .isEqualTo("1 2 Fizz 4 Buzz Fizz Pop Zing Fizz Buzz Whack Fizz Chop Pop FizzBuzz");
    }
}