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
    public void should_get_boom_given_7_as_number() {
        assertThat(fizzBuzzBoom.of(7)).isEqualTo("Boom");
    }
}
