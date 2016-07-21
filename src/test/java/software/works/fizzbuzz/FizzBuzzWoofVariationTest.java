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
}