package software.works.fizzbuzz.rule;

import static java.math.BigInteger.ZERO;

import java.math.BigInteger;

import org.junit.Test;

public class WordTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_word_given_a_null_word() {
        new Word(null, ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_word_given_an_empty_word() {
        new Word("", ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_property_given_a_null_property() {
        new Word("Fizz", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_property_given_a_negative_property() {
        new Word("Fizz", new BigInteger("-1"));
    }
}