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

    @Test
    public void should_get_fizz_or_buzz_or_woof_and_foo_or_bar_given_2_sets_of_alternate_words() {
        assertThat(fizzBuzz.alternateWords(Arrays.asList("Fizz", "Buzz", "Woof"), 3)
                .alternateWords(Arrays.asList("Foo", "Bar"), 5).from(1).to(15))
                        .isEqualTo("1 2 Fizz 4 Foo Buzz 7 8 Woof Bar 11 Fizz 13 14 BuzzFoo");
    }

    @Test
    public void should_get_foo_or_bar_and_buzz_given_a_set_of_alternate_words_and_a_single_word() {
        assertThat(fizzBuzz.alternateWords(Arrays.asList("Foo", "Bar"), 3).word("Buzz", 5).from(1).to(15))
                .isEqualTo("1 2 Foo 4 Buzz Bar 7 8 Foo Buzz 11 Bar 13 14 FooBuzz");
    }
}