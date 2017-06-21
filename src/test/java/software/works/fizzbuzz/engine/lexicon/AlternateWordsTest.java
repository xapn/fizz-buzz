package software.works.fizzbuzz.engine.lexicon;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import static java.math.BigInteger.ZERO;

public class AlternateWordsTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_words_given_a_null_word_list() {
        new AlternateWords(null, ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_words_given_an_empty_word_list() {
        new AlternateWords(new ArrayList<>(), ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_words_given_at_least_a_null_word() {
        new AlternateWords(Arrays.asList("Fizz", null, "Buzz"), ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_words_given_at_least_an_empty_word() {
        new AlternateWords(Arrays.asList("Fizz", "Buzz", ""), ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_property_given_a_null_property() {
        new AlternateWords(Arrays.asList("Fizz", "Buzz"), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_property_given_a_negative_property() {
        new AlternateWords(Arrays.asList("Fizz", "Buzz"), new BigInteger("-1"));
    }
}
