package software.works.fizzbuzz.rule;

public class Word {

    private String word;
    private int number;

    public Word(String word, int number) {
        this.word = word;
        this.number = number;
        validate();
    }

    private void validate() {
        if (word == null || word.isEmpty() || number < 0) {
            throw new IllegalStateException(
                    "Invalid word: " + word + " must be a word associated to a positive integer as property!");
        }
    }

    public String getWord() {
        return word;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("{word: %s, number: %d}", word, number);
    }
}