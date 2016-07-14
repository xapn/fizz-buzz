package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.BiPredicate;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzWhenCombiningVariationsTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz().whenNumberHasFactors().whenNumberContainsDigits();
    }

    @Test
    public void should_get_fizzfizz_given_3_as_number() {
        assertThat(fizzBuzz.of(3)).isEqualTo("FizzFizz");
    }

    @Test
    public void should_get_fizzbuzzbuzz_given_15_as_number() {
        assertThat(fizzBuzz.of(15)).isEqualTo("FizzBuzzBuzz");
    }

    @Test
    public void should_get_fizzfizzbuzz_given_30_as_number() {
        // assertThat(fizzBuzz.of(30)).isEqualTo("FizzFizzBuzz");
        assertThat(fizzBuzzOf(30)).isEqualTo("FizzFizzBuzz");
    }

    @Test
    public void should_get_fizzfizzbuzzbuzz_given_315_as_number() {
        // assertThat(fizzBuzz.of(315)).isEqualTo("FizzFizzBuzzBuzz");
        assertThat(fizzBuzzOf(315)).isEqualTo("FizzFizzBuzzBuzz");
    }

    String fizzBuzzOf(int value) {
        StringBuilder result = new StringBuilder();

        result //
                .append(word("Fizz", value, isMultipleOf, 3)) //
                .append(word("Fizz", value, containsDigit, 3)) //
                .append(word("Buzz", value, isMultipleOf, 5)) //
                .append(word("Buzz", value, containsDigit, 5));

        return result.toString();
    }

    String word(String word, int value, BiPredicate<Integer, Integer> predicate, int invariant) {
        return predicate.test(value, invariant) ? word : "";
    }

    boolean multipleOf5(int value) {
        return value % 5 == 0;
    }

    boolean contains5(int value) {
        return String.valueOf(value).contains("5");
    }

    BiPredicate<Integer, Integer> isMultipleOf = (value, factor) -> value % factor == 0;
    BiPredicate<Integer, Integer> containsDigit = (value, digit) -> String.valueOf(value)
            .contains(String.valueOf(digit));
}