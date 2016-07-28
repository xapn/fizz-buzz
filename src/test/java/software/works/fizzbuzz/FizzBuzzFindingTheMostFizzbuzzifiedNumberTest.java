package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzFindingTheMostFizzbuzzifiedNumberTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_find_the_alone_fizzbuzzified_number_given_some_arbitrary_numbers() {
        assertThat(fizzBuzz.findTheMostFizzbuzzifiedNumber().in(1, 3, 4)).hasValue(3);
    }

    @Test
    public void should_find_no_fizzbuzzified_number_given_some_arbitrary_numbers() {
        assertThat(fizzBuzz.findTheMostFizzbuzzifiedNumber().in(1, 2, 4)).isEmpty();
    }

    @Test
    public void should_find_a_fizzbuzzified_number_given_at_least_some_fizzbuzzified_numbers() {
        assertThat(fizzBuzz.findTheMostFizzbuzzifiedNumber().in(1, 3, 4, 5, 15, 20, 22)).hasValue(15);
    }

    @Test
    public void should_find_a_fizzbuzzified_number_given_a_range_of_numbers() {
        assertThat(fizzBuzz.whenNumberHasFactors().whenNumberContainsDigits().findTheMostFizzbuzzifiedNumber().from(1)
                .to(15)).hasValue(15);
    }
}