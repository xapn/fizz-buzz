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
}
