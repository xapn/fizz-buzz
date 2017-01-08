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
}