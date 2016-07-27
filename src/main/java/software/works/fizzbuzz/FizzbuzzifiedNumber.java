package software.works.fizzbuzz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FizzbuzzifiedNumber implements Comparable<FizzbuzzifiedNumber> {

    private static final String LETTERS_REGEX = "^[a-zA-Z]+$";

    private int number;
    private String fizzbuzzified;
    private Pattern knownWordsPattern;

    public FizzbuzzifiedNumber(int number, String fizzbuzzified, Pattern knownWordsPattern) {
        this.number = number;
        this.fizzbuzzified = fizzbuzzified;
        this.knownWordsPattern = knownWordsPattern;
    }

    public FizzbuzzifiedNumber(int number, String fizzbuzzified) {
        this.number = number;
        this.fizzbuzzified = fizzbuzzified;
    }

    private int countKnownWords() {
        Matcher matcher = knownWordsPattern.matcher(fizzbuzzified);

        int knownWordsNumber = 0;
        while (matcher.find()) {
            knownWordsNumber++;
        }

        return knownWordsNumber;
    }

    @Override
    public int compareTo(FizzbuzzifiedNumber other) {
        return this.countKnownWords() - other.countKnownWords();
    }

    boolean isFizzbuzzified() {
        return fizzbuzzified.matches(LETTERS_REGEX);
    }

    int getNumber() {
        return number;
    }

    String getFizzbuzzified() {
        return fizzbuzzified;
    }

    void setKnownWords(Pattern knownWordsPattern) {
        this.knownWordsPattern = knownWordsPattern;
    }
}