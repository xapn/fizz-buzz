package software.works.fizzbuzz;

import software.works.fizzbuzz.FizzBuzzRange.RangeHandler;
import software.works.fizzbuzz.engine.FunctionTypes.PropertyPredicate;
import software.works.fizzbuzz.engine.build.PlayerBuilder;
import software.works.fizzbuzz.engine.lexicon.AlternateWords;
import software.works.fizzbuzz.engine.lexicon.SingleWord;
import software.works.fizzbuzz.engine.play.DigitPlayer;
import software.works.fizzbuzz.engine.play.DivisionPlayer;
import software.works.fizzbuzz.engine.play.NumberCustomPredicatePlayer;

import java.util.List;

import static software.works.fizzbuzz.Values.toBigInteger;
import static software.works.fizzbuzz.Values.toBigIntegers;
import static software.works.fizzbuzz.engine.lexicon.DictionaryWord.BOOM;
import static software.works.fizzbuzz.engine.lexicon.DictionaryWord.BUZZ;
import static software.works.fizzbuzz.engine.lexicon.DictionaryWord.CHOP;
import static software.works.fizzbuzz.engine.lexicon.DictionaryWord.FIZZ;
import static software.works.fizzbuzz.engine.lexicon.DictionaryWord.POP;
import static software.works.fizzbuzz.engine.lexicon.DictionaryWord.WHACK;
import static software.works.fizzbuzz.engine.lexicon.DictionaryWord.WOOF;
import static software.works.fizzbuzz.engine.lexicon.DictionaryWord.ZING;

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

    public <T> String of(T value) {
        return playerBuilder
                .chosenPlayer()
                .playAtFizzBuzz(toBigInteger(value));
    }

    @SafeVarargs
    public final <T> String of(T... values) {
        return playerBuilder
                .chosenPlayer()
                .playAtFizzBuzz(toBigIntegers(values));
    }

    public <T> FizzBuzzRange<T, String> from(T start) {
        RangeHandler<String> rangeHandler = (values) -> playerBuilder
                .chosenPlayer()
                .playAtFizzBuzz(values);
        return new FizzBuzzRange<T, String>(rangeHandler).from(start);
    }

    public FizzBuzz whenNumberHasFactors() {
        playerBuilder.append(new DivisionPlayer());
        return this;
    }

    public FizzBuzz whenNumberContainsDigits() {
        playerBuilder.append(new DigitPlayer());
        return this;
    }

    public FizzBuzz whenNumberSatisfies(PropertyPredicate propertyPredicate) {
        playerBuilder.append(new NumberCustomPredicatePlayer(propertyPredicate));
        return this;
    }

    public FizzBuzz boom() {
        playerBuilder
                .append(FIZZ)
                .append(BUZZ)
                .append(BOOM)
                .append(new DivisionPlayer())
                .append(new DigitPlayer())
                .printWordsOnlyOnce();
        return this;
    }

    public FizzBuzz woof() {
        playerBuilder
                .append(FIZZ)
                .append(BUZZ)
                .append(WOOF)
                .append(new DivisionPlayer())
                .append(new DigitPlayer())
                .printWordsNTimes();
        return this;
    }

    public FizzBuzz popWhack() {
        playerBuilder
                .append(FIZZ)
                .append(BUZZ)
                .append(POP)
                .append(WHACK)
                .append(new DivisionPlayer());
        return this;
    }

    public FizzBuzz popWhackZingChop() {
        playerBuilder
                .append(FIZZ)
                .append(BUZZ)
                .append(POP)
                .append(WHACK)
                .append(ZING)
                .append(CHOP)
                .append(new DivisionPlayer());
        return this;
    }

    public FizzBuzz word(String word, long property) {
        playerBuilder.append(new SingleWord(word, toBigInteger(property)));
        return this;
    }

    public FizzBuzz alternateWords(List<String> words, long property) {
        playerBuilder.append(new AlternateWords(words, toBigInteger(property)));
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
        playerBuilder
                .separateWordsBy(punctuation + " ")
                .completeSentenceWith(punctuation);
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

    public FizzBuzzWordsAsList asList() {
        playerBuilder.collectWordsToList();
        return new FizzBuzzWordsAsList(playerBuilder);
    }

    public TheMostFizzyBuzzy findTheMostFizzyBuzzy() {
        return new TheMostFizzyBuzzy(playerBuilder);
    }
}