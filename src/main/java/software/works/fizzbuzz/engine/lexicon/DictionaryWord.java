package software.works.fizzbuzz.engine.lexicon;

import static software.works.fizzbuzz.Values.toBigInteger;

public enum DictionaryWord {

    FIZZ("Fizz", 3), //
    BUZZ("Buzz", 5), //
    BOOM("Boom", 7), //
    WOOF("Woof", 7), //
    POP("Pop", 7), //
    WHACK("Whack", 11), //
    ZING("Zing", 8), //
    CHOP("Chop", 13);

    private WordPropertyPair wordPropertyPair;

    private DictionaryWord(String word, long number) {
        this.wordPropertyPair = new SingleWord(word, toBigInteger(number));
    }

    public WordPropertyPair getWordPropertyPair() {
        return wordPropertyPair;
    }
}