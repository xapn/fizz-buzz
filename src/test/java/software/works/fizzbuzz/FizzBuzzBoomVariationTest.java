package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzBoomVariationTest {

    private FizzBuzz fizzBuzzBoom;

    @Before
    public void prepareFixtures() {
        fizzBuzzBoom = new FizzBuzz().boom();
    }

    @Test
    public void should_get_fizzfizz_given_3_as_number() {
        assertThat(fizzBuzzBoom.of(3)).isEqualTo("FizzFizz");
    }

    @Test
    public void should_get_buzzbuzz_given_5_as_number() {
        assertThat(fizzBuzzBoom.of(5)).isEqualTo("BuzzBuzz");
    }

    @Test
    public void should_get_boomboom_given_7_as_number() {
        assertThat(fizzBuzzBoom.of(7)).isEqualTo("BoomBoom");
    }

    @Test
    public void should_get_fizzfizzbuzzboomboom_given_7539() {
        assertThat(fizzBuzzBoom.of(7539)).isEqualTo("FizzFizzBuzzBoomBoom");
    }

    @Test
    public void should_get_fizz_buzz_or_boom_given_a_range_of_numbers() {
        assertThat(fizzBuzzBoom.from(1).to(15))
                .isEqualTo("1 2 FizzFizz 4 BuzzBuzz Fizz BoomBoom 8 Fizz Buzz 11 Fizz Fizz Boom FizzBuzzBuzz");
    }
}