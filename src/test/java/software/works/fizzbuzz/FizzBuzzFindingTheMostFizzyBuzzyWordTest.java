package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzFindingTheMostFizzyBuzzyWordTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_find_the_alone_fizzy_buzzy_word_given_some_arbritrary_numbers() {
        assertThat(fizzBuzz.findTheMostFizzyBuzzyWord().in(1, 3, 4)).hasValue("Fizz");
    }

    @Test
    public void should_find_no_fizzy_buzzy_word_given_some_arbitrary_numbers() {
        assertThat(fizzBuzz.findTheMostFizzyBuzzyWord().in(1, 2, 4)).isEmpty();
    }

    @Test
    public void should_find_a_fizzy_buzzy_word_given_at_least_some_fizzbuzzified_numbers() {
        assertThat(fizzBuzz.findTheMostFizzyBuzzyWord().in(1, 3, 4, 5, 15, 20, 22)).hasValue("FizzBuzz");
    }

    @Test
    public void should_find_a_fizzy_buzzy_word_given_a_range_of_numbers() {
        assertThat(
                fizzBuzz.whenNumberHasFactors().whenNumberContainsDigits().findTheMostFizzyBuzzyWord().from(1).to(15))
                        .hasValue("FizzBuzzBuzz");
    }
}