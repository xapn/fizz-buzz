package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzWithCustomWordsTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_get_foo_given_3_as_number() {
        assertThat(fizzBuzz.word("Foo", 3).of(3)).isEqualTo("Foo");
    }
}