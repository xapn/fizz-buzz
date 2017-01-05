package software.works.fizzbuzz.rule;

import static java.math.BigInteger.ZERO;

import java.math.BigInteger;

import org.junit.Test;

public class WordTest {

    @Test(expected = IllegalStateException.class)
    public void should_invalid_word_given_null_word() {
        new Word(null, ZERO);
    }

    @Test(expected = IllegalStateException.class)
    public void should_invalid_word_given_empty_word() {
        new Word("", ZERO);
    }

    @Test(expected = IllegalStateException.class)
    public void should_invalid_word_given_negative_number() {
        new Word(null, new BigInteger("-1"));
    }
}