package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzWoofVariationTest {
    private FizzBuzz fizzBuzzWoof;

    @Before
    public void prepareFixtures() {
        fizzBuzzWoof = new FizzBuzz().woof();
    }

    @Test
    public void should_get_fizzfizz_given_3_as_number() {
        assertThat(fizzBuzzWoof.of(3)).isEqualTo("FizzFizz");
    }

    @Test
    public void should_get_buzzbuzz_given_5_as_number() {
        assertThat(fizzBuzzWoof.of(5)).isEqualTo("BuzzBuzz");
    }

    @Test
    public void should_get_woofwoof_given_7_as_number() {
        assertThat(fizzBuzzWoof.of(7)).isEqualTo("WoofWoof");
    }

    @Test
    public void should_get_fizzfizz_given_18_as_number() {
        assertThat(fizzBuzzWoof.of(18)).isEqualTo("FizzFizz");
    }

    @Test
    public void should_get_fizzfizzfizz_given_303_as_number() {
        assertThat(fizzBuzzWoof.of(303)).isEqualTo("FizzFizzFizz");
    }

    @Test
    public void should_get_fizz_or_buzz_or_woof_given_some_arbitrary_numbers() {
        assertThat(fizzBuzzWoof.of(2, 21, 35)).isEqualTo("2 FizzWoof FizzBuzzBuzzWoof");
    }

    @Test
    public void should_get_fizz_or_buzz_or_woof_given_a_range_of_numbers() {
        assertThat(fizzBuzzWoof.from(1).to(15))
                .isEqualTo("1 2 FizzFizz 4 BuzzBuzz Fizz WoofWoof 8 FizzFizz Buzz 11 Fizz Fizz Woof FizzBuzzBuzz");
    }
}