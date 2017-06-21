package software.works.fizzbuzz.engine.lexicon;

import java.math.BigInteger;
import java.util.List;

public class AlternateWords implements WordPropertyPair {

    private List<String> words;
    private int index;
    private BigInteger property;

    public AlternateWords(List<String> words, BigInteger property) {
        this.words = words;
        this.property = property;
        index = 0;
        validate();
    }

    private void validate() {
        if (words == null || words.isEmpty() || words
                .stream()
                .anyMatch(word -> word == null || word.isEmpty()) || property == null || property.signum() == -1) {
            throw new IllegalArgumentException("Invalid alternate words: '" + words //
                    + "' must be a full list of words associated to a positive integer '" + property //
                    + "' as property!");
        }
    }

    @Override
    public String getWord() {
        return words.get(turningIndex());
    }

    private int turningIndex() {
        return index++ % words.size();
    }

    @Override
    public BigInteger getProperty() {
        return property;
    }

    @Override
    public String toString() {
        return String.format("{word: %s, property: %d}", words, property);
    }
}
