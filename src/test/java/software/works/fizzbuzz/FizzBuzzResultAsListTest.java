package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzResultAsListTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_collect_words_to_list_given_some_arbitrary_numbers() {
        assertThat(fizzBuzz.asList().of(1, 2, 3, 5, 8)).isEqualTo(Arrays.asList("1", "2", "Fizz", "Buzz", "8"));
    }

    @Test
    public void should_collect_words_to_list_given_a_range_of_numbers() {
        assertThat(fizzBuzz.asList().from(1).to(5)).isEqualTo(Arrays.asList("1", "2", "Fizz", "4", "Buzz"));
    }

    @Test
    public void should_collect_punctuated_words_as_list_given_a_range_of_numbers() {
        assertThat(fizzBuzz.punctuatedByExclamationMark().asList().from(1).to(5))
                .isEqualTo(Arrays.asList("1!", "2!", "Fizz!", "4!", "Buzz!"));
    }
}