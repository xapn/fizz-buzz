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
}
