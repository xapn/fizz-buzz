package software.works.fizzbuzz;

import static java.util.stream.Collectors.joining;
import static software.works.fizzbuzz.rule.DictionaryWord.BOOM;
import static software.works.fizzbuzz.rule.DictionaryWord.BUZZ;
import static software.works.fizzbuzz.rule.DictionaryWord.CHOP;
import static software.works.fizzbuzz.rule.DictionaryWord.FIZZ;
import static software.works.fizzbuzz.rule.DictionaryWord.POP;
import static software.works.fizzbuzz.rule.DictionaryWord.WHACK;
import static software.works.fizzbuzz.rule.DictionaryWord.WOOF;
import static software.works.fizzbuzz.rule.DictionaryWord.ZING;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import software.works.fizzbuzz.rule.DigitPlayer;
import software.works.fizzbuzz.rule.DivisionPlayer;
import software.works.fizzbuzz.rule.PlayerBuilder;
import software.works.fizzbuzz.rule.Word;

public class FizzBuzz {

    private static final String COMMA_SEPARATOR = ", ";
    private static final String SEMI_COLON_SEPARATOR = "; ";
    private static final String LINE_FEED_SEPARATOR = "\n";
    private static final String SLASH_SEPARATOR = " / ";
    private static final String BACKSLASH_SEPARATOR = " \\ ";
    private static final String DASH_SEPARATOR = " - ";
    private static final String FRENCH_SEMI_COLON_SEPARATOR = " ; ";
    private static final String EXCLAMATION_MARK = "!";
    private static final String FRENCH_EXCLAMATION_MARK = " !";
    private static final String FULL_STOP = ".";

    private PlayerBuilder playerBuilder;

    public FizzBuzz() {
        playerBuilder = new PlayerBuilder();
    }

    public String of(int value) {
        return playerBuilder.chosenPlayer().playAtFizzBuzz(value);
    }

    public String of(int... values) {
        return playerBuilder.chosenPlayer().playAtFizzBuzz(values);
    }

    public FizzBuzzRange from(int start) {
        return new FizzBuzzRange(playerBuilder.chosenPlayer()).from(start);
    }

    public FizzBuzz whenNumberHasFactors() {
        playerBuilder.append(new DivisionPlayer());
        return this;
    }

    public FizzBuzz whenNumberContainsDigits() {
        playerBuilder.append(new DigitPlayer());
        return this;
    }

    public FizzBuzz boom() {
        playerBuilder //
                .append(FIZZ).append(BUZZ).append(BOOM) //
                .append(new DivisionPlayer()) //
                .append(new DigitPlayer()) //
                .printWordsOnlyOnce();
        return this;
    }

    public FizzBuzz woof() {
        playerBuilder //
                .append(FIZZ).append(BUZZ).append(WOOF) //
                .append(new DivisionPlayer()) //
                .append(new DigitPlayer()) //
                .printWordsNTimes();
        return this;
    }

    public FizzBuzz popWhack() {
        playerBuilder //
                .append(FIZZ).append(BUZZ).append(POP).append(WHACK) //
                .append(new DivisionPlayer());
        return this;
    }

    public FizzBuzz popWhackZingChop() {
        playerBuilder //
                .append(FIZZ).append(BUZZ).append(POP).append(WHACK).append(ZING).append(CHOP) //
                .append(new DivisionPlayer());
        return this;
    }

    public FizzBuzz word(String word, int associatedNumber) {
        playerBuilder.append(new Word(word, associatedNumber));
        return this;
    }

    public FizzBuzz separatedBy(String wordSeparator) {
        playerBuilder.separateWordsBy(wordSeparator);
        return this;
    }

    public FizzBuzz separatedByComma() {
        return separatedBy(COMMA_SEPARATOR);
    }

    public FizzBuzz separatedBySemiColon() {
        return separatedBy(SEMI_COLON_SEPARATOR);
    }

    public FizzBuzz separatedByFrenchSemiColon() {
        return separatedBy(FRENCH_SEMI_COLON_SEPARATOR);
    }

    public FizzBuzz separatedByLineFeed() {
        return separatedBy(LINE_FEED_SEPARATOR);
    }

    public FizzBuzz separatedBySlash() {
        return separatedBy(SLASH_SEPARATOR);
    }

    public FizzBuzz separatedByBackslash() {
        return separatedBy(BACKSLASH_SEPARATOR);
    }

    public FizzBuzz separatedByDash() {
        return separatedBy(DASH_SEPARATOR);
    }

    public FizzBuzz punctuatedBy(String punctuation) {
        playerBuilder.separateWordsBy(punctuation + " ").completeSentenceWith(punctuation);
        return this;
    }

    public FizzBuzz punctuatedByExclamationMark() {
        return punctuatedBy(EXCLAMATION_MARK);
    }

    public FizzBuzz punctuatedByFrenchExclamationMark() {
        return punctuatedBy(FRENCH_EXCLAMATION_MARK);
    }

    public FizzBuzz punctuatedByFullStop() {
        return punctuatedBy(FULL_STOP);
    }

    public FizzBuzz punctuatedByPeriod() {
        return punctuatedByFullStop();
    }

    public FizzBuzz withNumbers() {
        playerBuilder.printNumbersBetweenBrackets();
        return this;
    }

    public FizzBuzz wordsOnlyOnce() {
        playerBuilder.printWordsOnlyOnce();
        return this;
    }

    public FizzBuzz wordsNTimes() {
        playerBuilder.printWordsNTimes();
        return this;
    }

    public FizzBuzzWordsToList asList() {
        playerBuilder.collectWordsToList();
        return new FizzBuzzWordsToList(playerBuilder);
    }

    public Integer findTheMostFizzbuzzifiedNumberIn(int... values) {
        List<String> madeWords = playerBuilder.chosenPlayer().playAtFizzBuzzToList(values);

        List<String> knownWords = playerBuilder.getKnownWords();
        String knownWordsRegex = knownWords.stream().collect(joining("|", "(", ")"));
        Pattern pattern = Pattern.compile(knownWordsRegex);

        int maximalOccurrenceNumber = -1, resultIndex = 0, index = 0;

        for (String madeWord : madeWords) {
            Matcher matcher = pattern.matcher(madeWord);
            int occurrenceNumber = 0;

            while (matcher.find()) {
                occurrenceNumber++;
            }

            if (occurrenceNumber > maximalOccurrenceNumber) {
                maximalOccurrenceNumber = occurrenceNumber;
                resultIndex = index;
            }

            index++;
        }

        return values[resultIndex];
    }
}