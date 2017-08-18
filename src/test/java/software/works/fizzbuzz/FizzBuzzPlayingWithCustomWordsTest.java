package software.works.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import testasyouthink.GivenWhenThenDsl.PreparationStage.Given;

import static testasyouthink.TestAsYouThink.givenSutClass;

public class FizzBuzzPlayingWithCustomWordsTest {

    private Given<FizzBuzz> givenFizzBuzzAsSut;

    @Before
    public void prepareFixtures() {
        givenFizzBuzzAsSut = givenSutClass(FizzBuzz.class);
    }

    @Test
    public void should_get_foo_given_3_as_number() {
        givenFizzBuzzAsSut
                .given(sut -> sut.word("Foo", 3))
                .whenSutReturns(sut -> sut.of(3))
                .then("Foo"::equals);
    }

    @Test
    public void should_get_foo_or_bar_or_baz_qux_given_some_arbitrary_numbers() {
        givenFizzBuzzAsSut
                .given(sut -> sut
                        .word("Foo", 3)
                        .word("Bar", 5)
                        .word("Baz", 7)
                        .word("Qux", 11))
                .whenSutReturns(sut -> sut.of(3, 5, 7, 11))
                .then("Foo Bar Baz Qux"::equals);
    }

    @Test
    public void should_get_foobaz_given_21_as_number() {
        givenFizzBuzzAsSut
                .given(sut -> sut
                        .word("Foo", 3)
                        .word("Bar", 5)
                        .word("Baz", 7))
                .whenSutReturns(sut -> sut.of(21))
                .then("FooBaz"::equals);
    }

    @Test
    public void should_get_foo_or_bar_or_baz_given_a_range_of_numbers() {
        givenFizzBuzzAsSut
                .given(sut -> sut
                        .word("Foo", 3)
                        .word("Bar", 5)
                        .word("Baz", 7)
                        .whenNumberHasFactors()
                        .whenNumberContainsDigits())
                .whenSutReturns(sut -> sut
                        .from(1)
                        .to(15))
                .then("1 2 FooFoo 4 BarBar Foo BazBaz 8 Foo Bar 11 Foo Foo Baz FooBarBar"::equals);
    }
}