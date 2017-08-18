package software.works.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import testasyouthink.GivenWhenThenDsl.PreparationStage.Given;

import java.util.Arrays;

import static testasyouthink.TestAsYouThink.givenSutClass;

public class FizzBuzzPlayingWithAlternateWordsTest {

    private Given<FizzBuzz> givenFizzBuzzAsSut;

    @Before
    public void prepareFixtures() {
        givenFizzBuzzAsSut = givenSutClass(FizzBuzz.class);
    }

    @Test
    public void should_get_foo_or_bar_given_2_alternate_words() {
        givenFizzBuzzAsSut
                .given(sut -> sut.alternateWords(Arrays.asList("Foo", "Bar"), 2))
                .whenSutReturns(sut -> sut
                        .from(1)
                        .to(6))
                .then("1 Foo 3 Bar 5 Foo"::equals);
    }

    @Test
    public void should_get_fizz_or_buzz_or_woof_and_foo_or_bar_given_2_sets_of_alternate_words() {
        givenFizzBuzzAsSut
                .given(sut -> sut
                        .alternateWords(Arrays.asList("Fizz", "Buzz", "Woof"), 3)
                        .alternateWords(Arrays.asList("Foo", "Bar"), 5))
                .whenSutReturns(sut -> sut
                        .from(1)
                        .to(15))
                .then("1 2 Fizz 4 Foo Buzz 7 8 Woof Bar 11 Fizz 13 14 BuzzFoo"::equals);
    }

    @Test
    public void should_get_foo_or_bar_and_buzz_given_a_set_of_alternate_words_and_a_single_word() {
        givenFizzBuzzAsSut
                .given(fizzBuzz -> fizzBuzz
                        .alternateWords(Arrays.asList("Foo", "Bar"), 3)
                        .word("Buzz", 5))
                .whenSutReturns(fizzBuzz -> fizzBuzz
                        .from(1)
                        .to(15))
                .then("1 2 Foo 4 Buzz Bar 7 8 Foo Buzz 11 Bar 13 14 FooBuzz"::equals);
    }
}