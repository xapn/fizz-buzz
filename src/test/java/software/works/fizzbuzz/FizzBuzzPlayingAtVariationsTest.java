package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;
import static software.works.fizzbuzz.PlayAt.fizzBuzz;
import static software.works.fizzbuzz.PlayAt.sevenBoom;
import static software.works.fizzbuzz.PlayAt.fizzBuzzPopWhack;
import static software.works.fizzbuzz.PlayAt.fizzBuzzPopWhackZingChop;
import static software.works.fizzbuzz.PlayAt.fizzBuzzWoof;

import org.junit.Test;

public class FizzBuzzPlayingAtVariationsTest {

    @Test
    public void should_play_at_fizz_buzz() {
        assertThat(fizzBuzz().of(3)).isEqualTo(new FizzBuzz().of(3));
    }

    @Test
    public void should_play_at_7_boom() {
        assertThat(sevenBoom().of(3)).isEqualTo(new FizzBuzz().boom().of(3));
    }

    @Test
    public void should_play_at_fizz_buzz_woof() {
        assertThat(fizzBuzzWoof().of(3)).isEqualTo(new FizzBuzz().woof().of(3));
    }

    @Test
    public void should_play_at_fizz_buzz_pop_whack() {
        assertThat(fizzBuzzPopWhack().of(3)).isEqualTo(new FizzBuzz().popWhack().of(3));
    }

    @Test
    public void should_play_at_fizz_buzz_pop_whack_zing_chop() {
        assertThat(fizzBuzzPopWhackZingChop().of(3)).isEqualTo(new FizzBuzz().popWhackZingChop().of(3));
    }
}
