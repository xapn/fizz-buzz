package software.works.fizzbuzz;

import static java.math.BigInteger.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzUsingVariousInputsTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_get_fizz_given_3_as_a_long_integer() {
        assertThat(fizzBuzz.of(3L)).isEqualTo(fizzBuzz.of(3));
    }

    @Test
    public void should_get_fizz_or_buzz_given_several_long_integers() {
        assertThat(fizzBuzz.of(3L, 5L, 15L)).isEqualTo(fizzBuzz.of(3, 5, 15));
    }

    @Test
    public void should_get_fizz_and_buzz_and_fizzbuzz_and_numbers_given_a_range_of_long_integers() {
        assertThat(fizzBuzz.from(3L).to(5L)).isEqualTo(fizzBuzz.from(3).to(5));
    }

    @Test
    public void should_get_fizz_given_3_as_a_numeric_string() {
        assertThat(fizzBuzz.of("3")).isEqualTo(fizzBuzz.of(3));
    }

    @Test
    public void should_get_fizz_or_buzz_given_several_numeric_strings() {
        assertThat(fizzBuzz.of("3", "5", "15")).isEqualTo(fizzBuzz.of(3, 5, 15));
    }

    @Test
    public void should_get_fizz_and_buzz_and_fizzbuzz_and_numbers_given_a_range_of_numeric_strings() {
        assertThat(fizzBuzz.from("3").to("5")).isEqualTo(fizzBuzz.from(3).to(5));
    }

    @Test
    public void should_get_buzz_given_a_numeric_string_greater_than_long_max_value() {
        // GIVEN
        BigInteger greaterThanIntegerMaxValue = valueOf(10).pow(100);
        assertThat(greaterThanIntegerMaxValue).isGreaterThan(valueOf(Long.MAX_VALUE));

        // WHEN
        String result = fizzBuzz.of(greaterThanIntegerMaxValue.toString());

        // THEN
        assertThat(result).isEqualTo("Buzz");
    }

    @Test
    public void should_get_fizz_given_3_as_big_integer() {
        assertThat(fizzBuzz.of(valueOf(3))).isEqualTo(fizzBuzz.of(3));
    }

    @Test
    public void should_get_fizz_or_buzz_given_several_big_integers() {
        assertThat(fizzBuzz.of(valueOf(3), valueOf(5), valueOf(15))).isEqualTo(fizzBuzz.of(3, 5, 15));
    }

    @Test
    public void should_get_fizz_and_buzz_and_fizzbuzz_and_numbers_given_a_range_of_big_integers() {
        assertThat(fizzBuzz.from(new BigInteger("3")).to(new BigInteger("5"))).isEqualTo(fizzBuzz.from(3).to(5));
    }

    @Test
    public void should_get_buzz_given_a_big_integer_greater_than_long_max_value() {
        // GIVEN
        BigInteger greaterThanIntegerMaxValue = valueOf(10).pow(100);
        assertThat(greaterThanIntegerMaxValue).isGreaterThan(BigInteger.valueOf(Long.MAX_VALUE));

        // WHEN
        String result = fizzBuzz.of(greaterThanIntegerMaxValue);

        // THEN
        assertThat(result).isEqualTo("Buzz");
    }

    @Test
    public void should_find_the_most_fizzybuzzy_given_some_arbitrary_numeric_strings() {
        // WHEN
        TheMostFizzyBuzzy result = fizzBuzz.findTheMostFizzyBuzzy().in("1", "3", "4", "5", "15", "20", "22");

        // THEN
        TheMostFizzyBuzzy expected = fizzBuzz.findTheMostFizzyBuzzy().in(1, 3, 4, 5, 15, 20, 22);
        assertThat(result.asNumber()).isEqualTo(expected.asNumber());
        assertThat(result.asWord()).isEqualTo(expected.asWord());
    }

    @Test
    public void should_find_the_most_fizzybuzzy_given_a_range_of_numeric_strings() {
        // WHEN
        TheMostFizzyBuzzy result = fizzBuzz.findTheMostFizzyBuzzy().from("1").to("15");

        // THEN
        TheMostFizzyBuzzy expected = fizzBuzz.findTheMostFizzyBuzzy().from(1).to(15);
        assertThat(result.asNumber()).isEqualTo(expected.asNumber());
        assertThat(result.asWord()).isEqualTo(expected.asWord());
    }

    @Test
    public void should_find_the_most_fizzybuzzy_given_some_arbitrary_big_integers() {
        // WHEN
        TheMostFizzyBuzzy result = fizzBuzz.findTheMostFizzyBuzzy().in(valueOf(1), valueOf(3), valueOf(4), valueOf(5),
                valueOf(15), valueOf(20), valueOf(22));

        // THEN
        TheMostFizzyBuzzy expected = fizzBuzz.findTheMostFizzyBuzzy().in(1, 3, 4, 5, 15, 20, 22);
        assertThat(result.asNumber()).isEqualTo(expected.asNumber());
        assertThat(result.asWord()).isEqualTo(expected.asWord());
    }

    @Test
    public void should_find_the_most_fizzybuzzy_given_a_range_of_big_integers() {
        // WHEN
        TheMostFizzyBuzzy result = fizzBuzz.findTheMostFizzyBuzzy().from(valueOf(1)).to(valueOf(15));

        // THEN
        TheMostFizzyBuzzy expected = fizzBuzz.findTheMostFizzyBuzzy().from(1).to(15);
        assertThat(result.asNumber()).isEqualTo(expected.asNumber());
        assertThat(result.asWord()).isEqualTo(expected.asWord());
    }
}