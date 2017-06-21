package software.works.fizzbuzz.engine.lexicon;

import org.junit.Test;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

public class SingleWordTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_word_given_a_null_word() {
        new SingleWord(null, ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_word_given_an_empty_word() {
        new SingleWord("", ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_property_given_a_null_property() {
        new SingleWord("Fizz", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_invalidate_the_property_given_a_negative_property() {
        new SingleWord("Fizz", new BigInteger("-1"));
    }
}