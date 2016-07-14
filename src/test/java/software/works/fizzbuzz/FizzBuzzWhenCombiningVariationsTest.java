package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzWhenCombiningVariationsTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz().whenNumberHasFactors().whenNumberContainsDigits();
    }

    @Test
    public void should_get_fizzfizz_given_3_as_number() {
        assertThat(fizzBuzz.of(3)).isEqualTo("FizzFizz");
    }

    @Test
    public void should_get_fizzbuzzbuzz_given_15_as_number() {
        assertThat(fizzBuzz.of(15)).isEqualTo("FizzBuzzBuzz");
    }

    @Test
    public void should_get_fizzfizzbuzz_given_30_as_number() {
        assertThat(fizzBuzz.of(30)).isEqualTo("FizzFizzBuzz");
    }

    @Test
    public void should_get_fizzfizzbuzzbuzz_given_315_as_number() {
        assertThat(fizzBuzz.of(315)).isEqualTo("FizzFizzBuzzBuzz");
    }
}