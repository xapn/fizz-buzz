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

    @Test
    public void should_get_foo_or_bar_or_baz_qux_given_some_arbitrary_numbers() {
        assertThat(fizzBuzz.word("Foo", 3).word("Bar", 5).word("Baz", 7).word("Qux", 11).of(3, 5, 7, 11))
                .isEqualTo("Foo Bar Baz Qux");
    }

    @Test
    public void should_get_foobaz_given_21_as_number() {
        assertThat(fizzBuzz.word("Foo", 3).word("Bar", 5).word("Baz", 7).of(21)).isEqualTo("FooBaz");
    }

    @Test
    public void should_get_foo_or_bar_or_baz_given_a_range_of_numbers() {
        assertThat(fizzBuzz.word("Foo", 3).word("Bar", 5).word("Baz", 7).whenNumberHasFactors()
                .whenNumberContainsDigits().from(1).to(15))
                        .isEqualTo("1 2 FooFoo 4 BarBar Foo BazBaz 8 Foo Bar 11 Foo Foo Baz FooBarBar");
    }
}