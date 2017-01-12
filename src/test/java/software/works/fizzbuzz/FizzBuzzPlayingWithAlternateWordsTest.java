package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzPlayingWithAlternateWordsTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_get_foo_or_bar_given_2_alternate_words() {
        assertThat(fizzBuzz.alternateWords(Arrays.asList("Foo", "Bar"), 2).from(1).to(6))
                .isEqualTo("1 Foo 3 Bar 5 Foo");
    }
}