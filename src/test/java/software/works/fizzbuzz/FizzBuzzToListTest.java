package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzToListTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_collect_words_to_list_given_some_arbitrary_numbers() {
        assertThat(fizzBuzz.toList().of(1, 2, 3, 5, 8)).isEqualTo(Arrays.asList("1", "2", "Fizz", "Buzz", "8"));
    }
}