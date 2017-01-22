package software.works.fizzbuzz.engine;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static software.works.fizzbuzz.engine.lexicon.DictionaryWord.BUZZ;
import static software.works.fizzbuzz.engine.lexicon.DictionaryWord.FIZZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import software.works.fizzbuzz.FizzBuzzPlayer;
import software.works.fizzbuzz.engine.lexicon.DictionaryWord;
import software.works.fizzbuzz.engine.lexicon.WordPropertyPair;
import software.works.fizzbuzz.engine.play.DivisionPlayer;
import software.works.fizzbuzz.engine.play.NumberPredicatePlayer;

public class PlayerBuilder {

    private static final List<WordPropertyPair> DEFAULT_WORD_PROPERTY_PAIRS = unmodifiableList(
            Arrays.asList(FIZZ.getWordPropertyPair(), BUZZ.getWordPropertyPair()));

    private final List<WordPropertyPair> wordPropertyPairs;
    private final List<NumberPredicatePlayer> players;
    private final PlayerConfiguration configuration;

    public PlayerBuilder() {
        wordPropertyPairs = new ArrayList<>();
        players = new ArrayList<>();
        configuration = new PlayerConfiguration();
    }

    public PlayerBuilder append(WordPropertyPair wordPropertyPair) {
        wordPropertyPairs.add(wordPropertyPair);
        return this;
    }

    public PlayerBuilder append(DictionaryWord dictionaryWord) {
        return append(dictionaryWord.getWordPropertyPair());
    }

    public PlayerBuilder separateWordsBy(String wordSeparator) {
        configuration.setWordSeparator(wordSeparator);
        return this;
    }

    public PlayerBuilder completeSentenceWith(String finalPunctuation) {
        configuration.setFinalPunctuation(finalPunctuation);
        return this;
    }

    public PlayerBuilder append(NumberPredicatePlayer player) {
        players.add(player);
        return this;
    }

    public FizzBuzzPlayer chosenPlayer() {
        chooseDefaultWordsIfNotSpecified(wordPropertyPairs);
        chooseClassicPlayerByDefaultIfUnknown(players);
        FizzBuzzPlayer definitivePlayer = null;

        if (configuration.wordsMustBePrintedOnlyOnce()) {
            definitivePlayer = new WordCentricPlayerBuilder().coupleWordsAndProperties(wordPropertyPairs)
                    .playThisWay(configuration).assemblyPlayers(players).getPlayer();
        } else {
            definitivePlayer = new PredicateCentricPlayerBuilder().coupleWordsAndProperties(wordPropertyPairs)
                    .playThisWay(configuration).assemblyPlayers(players).getPlayer();
        }

        return definitivePlayer;
    }

    private void chooseDefaultWordsIfNotSpecified(List<WordPropertyPair> wordPropertyPairs) {
        if (wordPropertyPairs.isEmpty()) {
            wordPropertyPairs.addAll(DEFAULT_WORD_PROPERTY_PAIRS);
        }
    }

    private List<NumberPredicatePlayer> chooseClassicPlayerByDefaultIfUnknown(List<NumberPredicatePlayer> players) {
        if (players.isEmpty()) {
            players.add(new DivisionPlayer());
        }
        return players;
    }

    public void printNumbersBetweenBrackets() {
        configuration.setNumbersMustBePrinted(true);
    }

    public PlayerBuilder printWordsOnlyOnce() {
        configuration.setWordsMustBePrintedOnlyOnce(true);
        return this;
    }

    public PlayerBuilder printWordsNTimes() {
        configuration.setWordsMustBePrintedNTimes(true);
        return this;
    }

    public PlayerBuilder collectWordsToList() {
        configuration.setWordsMustBeCollectedToList(true);
        return this;
    }

    public List<String> getKnownWords() {
        return wordPropertyPairs.stream().map(word -> word.getWord()).collect(toList());
    }
}