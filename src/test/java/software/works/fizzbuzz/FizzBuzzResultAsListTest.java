package software.works.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static testasyouthink.TestAsYouThink.resultOf;

public class FizzBuzzResultAsListTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_collect_words_to_list_given_some_arbitrary_numbers() {
        resultOf(() -> fizzBuzz
                .asList()
                .of(1, 2, 3, 5, 8)).isEqualTo(asList("1", "2", "Fizz", "Buzz", "8"));
    }

    @Test
    public void should_collect_words_to_list_given_a_range_of_numbers() {
        resultOf(() -> fizzBuzz
                .asList()
                .from(1)
                .to(5)).isEqualTo(asList("1", "2", "Fizz", "4", "Buzz"));
    }

    @Test
    public void should_collect_punctuated_words_as_list_given_a_range_of_numbers() {
        resultOf(() -> fizzBuzz
                .punctuatedByExclamationMark()
                .asList()
                .from(1)
                .to(5)).isEqualTo(asList("1!", "2!", "Fizz!", "4!", "Buzz!"));
    }
}