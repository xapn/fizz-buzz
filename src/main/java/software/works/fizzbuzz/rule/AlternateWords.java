package software.works.fizzbuzz.rule;

import java.math.BigInteger;
import java.util.List;

public class AlternateWords implements WordPropertyPair {

    private List<String> words;
    private BigInteger property;

    public AlternateWords(List<String> words, BigInteger property) {
        this.words = words;
        this.property = property;
        validate();
    }

    private void validate() {
        if (words == null || words.isEmpty() || words.stream().anyMatch(word -> word == null || word.isEmpty())
                || property == null || property.signum() == -1) {
            throw new IllegalArgumentException("Invalid alternate words: '" //
                    + words + "' must be a full list of words associated to a positive integer '" + property
                    + "' as property!");
        }
    }

    @Override
    public String getWord() {
        throw new RuntimeException("Not yet implemented!");
    }

    @Override
    public BigInteger getProperty() {
        throw new RuntimeException("Not yet implemented!");
    }
}
