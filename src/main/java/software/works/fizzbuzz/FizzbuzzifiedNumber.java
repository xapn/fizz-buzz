package software.works.fizzbuzz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FizzbuzzifiedNumber implements Comparable<FizzbuzzifiedNumber> {

    private int number;
    private String fizzbuzzified;
    private Pattern knownWordsPattern;

    public FizzbuzzifiedNumber(int number, String fizzbuzzified, Pattern knownWordsPattern) {
        this.number = number;
        this.fizzbuzzified = fizzbuzzified;
        this.knownWordsPattern = knownWordsPattern;
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

    int getNumber() {
        return number;
    }

    String getFizzbuzzified() {
        return fizzbuzzified;
    }
}