package software.works.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import testasyouthink.GivenWhenThenDsl.PreparationStage.Given;

import static org.assertj.core.api.Assertions.assertThat;
import static testasyouthink.TestAsYouThink.givenSutClass;

public class FizzBuzzFindingTheMostFizzyBuzzyTest {

    private Given<FizzBuzz> givenFizzBuzzAsSut;

    @Before
    public void prepareFixtures() {
        givenFizzBuzzAsSut = givenSutClass(FizzBuzz.class);
    }

    @Test
    public void should_find_the_alone_fizzbuzzified_number_given_some_arbitrary_numbers() {
        givenFizzBuzzAsSut
                .whenSutReturns(sut -> sut
                        .findTheMostFizzyBuzzy()
                        .in(1, 3, 4))
                .then(result -> {
                    assertThat(result.asNumber()).hasValue("3");
                    assertThat(result.asWord()).hasValue("Fizz");
                });
    }

    @Test
    public void should_find_no_fizzbuzzifiable_number_given_some_arbitrary_numbers() {
        givenFizzBuzzAsSut
                .whenSutReturns(sut -> sut
                        .findTheMostFizzyBuzzy()
                        .in(1, 2, 4))
                .then(result -> {
                    assertThat(result.get()).isEmpty();
                    assertThat(result.asNumber()).isEmpty();
                    assertThat(result.asWord()).isEmpty();
                });
    }

    @Test
    public void should_find_the_most_fizzybuzzy_given_at_least_some_fizzbuzzifiable_numbers() {
        givenFizzBuzzAsSut
                .whenSutReturns(sut -> sut
                        .findTheMostFizzyBuzzy()
                        .in(1, 3, 4, 5, 15, 20, 22))
                .then(result -> {
                    assertThat(result.asNumber()).hasValue("15");
                    assertThat(result.asWord()).hasValue("FizzBuzz");
                });
    }

    @Test
    public void should_find_the_most_fizzybuzzy_given_a_range_of_numbers() {
        givenFizzBuzzAsSut
                .whenSutReturns(sut -> sut
                        .whenNumberHasFactors()
                        .whenNumberContainsDigits()
                        .findTheMostFizzyBuzzy()
                        .from(1)
                        .to(15))
                .then(result -> {
                    assertThat(result.asNumber()).hasValue("15");
                    assertThat(result.asWord()).hasValue("FizzBuzzBuzz");
                });
    }
}