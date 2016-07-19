package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzByDefaultTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_get_the_same_result() {
        int start = 1, end = 100;
        assertThat(fizzBuzz.from(start).to(end)).isEqualTo(new FizzBuzz().whenNumberHasFactors().from(start).to(end));
    }
}
