package software.works.fizzbuzz.rule;

public enum DictionaryWord {

    FIZZ("Fizz", 3), //
    BUZZ("Buzz", 5), //
    BOOM("Boom", 7);

    private Word word;

    private DictionaryWord(String word, int number) {
        this.word = new Word(word, number);
    }

    public Word getWord() {
        return word;
    }
}