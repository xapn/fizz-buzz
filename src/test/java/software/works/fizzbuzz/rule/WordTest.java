package software.works.fizzbuzz.rule;

import org.junit.Test;

import software.works.fizzbuzz.rule.Word;

public class WordTest {

    @Test(expected = IllegalStateException.class)
    public void should_invalid_word_given_null_word() {
        new Word(null, 0);
    }

    @Test(expected = IllegalStateException.class)
    public void should_invalid_word_given_empty_word() {
        new Word("", 0);
    }

    @Test(expected = IllegalStateException.class)
    public void should_invalid_word_given_negative_number() {
        new Word(null, -1);
    }
}