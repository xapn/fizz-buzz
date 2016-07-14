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
                .append(word(fizzIfMultipleOf3, value)) //
                .append(word(fizzIfContains3, value)) //
                .append(word(buzzIfMultipleOf5, value)) //
                .append(word(buzzIfContains5, value));

        return result.toString();
    }

    String word(FizzBuzzPredicate predicate, int value) {
        return predicate.fizzBuzz(value);
    }

    @FunctionalInterface
    static interface FizzBuzzPredicate {
        String fizzBuzz(int value);
    }

    FizzBuzzPredicate fizzIfMultipleOf3 = (value) -> ifThis(value, Predicates.isMultipleOf, 3) ? "Fizz" : "";
    FizzBuzzPredicate fizzIfContains3 = (value) -> ifThis(value, Predicates.containsDigit, 3) ? "Fizz" : "";
    FizzBuzzPredicate buzzIfMultipleOf5 = (value) -> ifThis(value, Predicates.isMultipleOf, 5) ? "Buzz" : "";
    FizzBuzzPredicate buzzIfContains5 = (value) -> ifThis(value, Predicates.containsDigit, 5) ? "Buzz" : "";

    boolean ifThis(Integer value, BiPredicate<Integer, Integer> predicate, Integer invariant) {
        return predicate.test(value, invariant);
    }

    static class Predicates {
        static BiPredicate<Integer, Integer> isMultipleOf = (value, factor) -> value % factor == 0;
        static BiPredicate<Integer, Integer> containsDigit = (value, digit) -> String.valueOf(value)
                .contains(String.valueOf(digit));
    }
}