package software.works.fizzbuzz.rule;

import java.math.BigInteger;

public enum DictionaryWord {

    FIZZ("Fizz", 3), //
    BUZZ("Buzz", 5), //
    BOOM("Boom", 7), //
    WOOF("Woof", 7), //
    POP("Pop", 7), //
    WHACK("Whack", 11), //
    ZING("Zing", 8), //
    CHOP("Chop", 13);

    private Word word;

    private DictionaryWord(String word, long number) {
        this.word = new Word(word, BigInteger.valueOf(number));
    }

    public Word getWord() {
        return word;
    }
}