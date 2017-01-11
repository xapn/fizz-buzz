package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzFindingTheMostFizzyBuzzyTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_find_the_alone_fizzbuzzified_number_given_some_arbitrary_numbers() {
        // WHEN
        TheMostFizzyBuzzy result = fizzBuzz.findTheMostFizzyBuzzy().in(1, 3, 4);

        // THEN
        assertThat(result.asNumber()).hasValue("3");
        assertThat(result.asWord()).hasValue("Fizz");
    }

    @Test
    public void should_find_no_fizzbuzzifiable_number_given_some_arbitrary_numbers() {
        // WHEN
        TheMostFizzyBuzzy result = fizzBuzz.findTheMostFizzyBuzzy().in(1, 2, 4);

        // THEN
        assertThat(result.get()).isEmpty();
        assertThat(result.asNumber()).isEmpty();
        assertThat(result.asWord()).isEmpty();
    }

    @Test
    public void should_find_the_most_fizzybuzzy_given_at_least_some_fizzbuzzifiable_numbers() {
        // WHEN
        TheMostFizzyBuzzy result = fizzBuzz.findTheMostFizzyBuzzy().in(1, 3, 4, 5, 15, 20, 22);

        // THEN
        assertThat(result.asNumber()).hasValue("15");
        assertThat(result.asWord()).hasValue("FizzBuzz");
    }

    @Test
    public void should_find_the_most_fizzybuzzy_given_a_range_of_numbers() {
        // WHEN
        TheMostFizzyBuzzy result = fizzBuzz.whenNumberHasFactors().whenNumberContainsDigits().findTheMostFizzyBuzzy()
                .from(1).to(15);

        // THEN
        assertThat(result.asNumber()).hasValue("15");
        assertThat(result.asWord()).hasValue("FizzBuzzBuzz");
    }
}