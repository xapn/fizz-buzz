package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzSeparatorsTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_get_fizzbuzz_given_comma_as_separator() {
        assertThat(fizzBuzz.separatedBy(", ").of(3, 5)).isEqualTo("Fizz, Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_comma_as_predefined_separator() {
        assertThat(fizzBuzz.separatedByComma().of(3, 5)).isEqualTo("Fizz, Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_semicolon_as_predefined_separator() {
        assertThat(fizzBuzz.separatedBySemiColon().of(3, 5)).isEqualTo("Fizz; Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_french_semicolon_as_predefined_separator() {
        assertThat(fizzBuzz.separatedByFrenchSemiColon().of(3, 5)).isEqualTo("Fizz ; Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_line_feed_as_predefined_separator() {
        assertThat(fizzBuzz.separatedByLineFeed().of(3, 5)).isEqualTo("Fizz\nBuzz");
    }

    @Test
    public void should_get_fizzbuzz_given_slash_as_predefined_separator() {
        assertThat(fizzBuzz.separatedBySlash().of(3, 5)).isEqualTo("Fizz / Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_backslash_as_predefined_separator() {
        assertThat(fizzBuzz.separatedByBackslash().of(3, 5)).isEqualTo("Fizz \\ Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_dash_as_predefined_separator() {
        assertThat(fizzBuzz.separatedByDash().of(3, 5)).isEqualTo("Fizz - Buzz");
    }
}