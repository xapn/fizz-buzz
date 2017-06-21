package software.works.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzPopWhackVariationTest {

    private FizzBuzz fizzBuzzPopWhack;

    @Before
    public void prepareFixtures() {
        fizzBuzzPopWhack = new FizzBuzz().popWhack();
    }

    @Test
    public void should_get_fizz_given_3_as_number() {
        assertThat(fizzBuzzPopWhack.of(3)).isEqualTo("Fizz");
    }

    @Test
    public void should_get_number_given_31_as_number() {
        assertThat(fizzBuzzPopWhack.of(31)).isEqualTo("31");
    }

    @Test
    public void should_get_buzz_given_5_as_number() {
        assertThat(fizzBuzzPopWhack.of(5)).isEqualTo("Buzz");
    }

    @Test
    public void should_get_pop_given_7_as_number() {
        assertThat(fizzBuzzPopWhack.of(7)).isEqualTo("Pop");
    }

    @Test
    public void should_get_whack_given_11_as_number() {
        assertThat(fizzBuzzPopWhack.of(11)).isEqualTo("Whack");
    }

    @Test
    public void should_get_fizzbuzzpopwhack_given_1155() {
        assertThat(fizzBuzzPopWhack.of(1155)).isEqualTo("FizzBuzzPopWhack");
    }

    @Test
    public void should_get_fizz_or_buzz_or_pop_or_whack_given_a_range_of_numbers() {
        assertThat(fizzBuzzPopWhack
                .from(1)
                .to(15)).isEqualTo("1 2 Fizz 4 Buzz Fizz Pop 8 Fizz Buzz Whack Fizz 13 Pop FizzBuzz");
    }
}