package software.works.fizzbuzz.engine.lexicon;

import java.math.BigInteger;

public class SingleWord implements WordPropertyPair {

    private String word;
    private BigInteger property;

    public SingleWord(String word, BigInteger property) {
        this.word = word;
        this.property = property;
        validate();
    }

    private void validate() {
        if (word == null || word.isEmpty() || property == null || property.signum() == -1) {
            throw new IllegalArgumentException("Invalid word: '" + word //
                    + "' must be a word associated to a positive integer '" + property + "' as property!");
        }
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public BigInteger getProperty() {
        return property;
    }

    @Override
    public String toString() {
        return String.format("{word: %s, property: %d}", word, property);
    }
}