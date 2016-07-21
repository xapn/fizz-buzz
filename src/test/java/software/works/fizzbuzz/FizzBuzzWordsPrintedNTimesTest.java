package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzWordsPrintedNTimesTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz().wordsNTimes();
    }

    @Test
    public void should_get_fizzfizz_given_9_as_number() {
        assertThat(fizzBuzz.of(9)).isEqualTo("FizzFizz");
    }
}