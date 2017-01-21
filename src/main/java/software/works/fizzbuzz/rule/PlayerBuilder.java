package software.works.fizzbuzz.rule;

import static java.util.stream.Collectors.toList;
import static software.works.fizzbuzz.rule.DictionaryWord.BUZZ;
import static software.works.fizzbuzz.rule.DictionaryWord.FIZZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import software.works.fizzbuzz.FizzBuzzPlayer;

public class PlayerBuilder {

    private static final List<WordPropertyPair> DEFAULT_WORD_PROPERTY_PAIRS = Arrays.asList(FIZZ.getWordPropertyPair(),
            BUZZ.getWordPropertyPair());

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
            definitivePlayer = buildWordCentricPlayer(players);
        } else {
            definitivePlayer = buildPredicateCentricPlayer(players);
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

    private FizzBuzzPlayer buildWordCentricPlayer(List<NumberPredicatePlayer> players) {
        List<NumberPredicate> allNumberPredicates = players.stream() //
                .map(player -> player.getNumberPredicate()) //
                .collect(toList());
        List<FizzBuzzFunction> wordCentricFunctions = buildWordCentricFunctions(allNumberPredicates);
        FizzBuzzPlayer wordCentricPlayer = new OrdinaryPlayer(wordCentricFunctions, configuration) {};

        return wordCentricPlayer;
    }

    private FizzBuzzPlayer buildPredicateCentricPlayer(List<NumberPredicatePlayer> players) {
        players.stream().forEach(player -> {
            player.setFizzBuzzFunctions(buildPredicateCentricFunctions(player.getNumberPredicate()));
            player.setConfiguration(configuration);
        });
        return combineVariations(players);
    }

    private List<FizzBuzzFunction> buildWordCentricFunctions(List<NumberPredicate> numberPredicates) {
        return wordPropertyPairs.stream() //
                .map(word -> word.ifNumberSatisfies(numberPredicates)) //
                .collect(toList());
    }

    private List<FizzBuzzFunction> buildPredicateCentricFunctions(NumberPredicate numberPredicate) {
        return wordPropertyPairs.stream() //
                .map(word -> configuration.wordsMustBePrintedNTimes() ? word.nTimesIfNumberSatisfies(numberPredicate)
                        : word.ifNumberSatisfies(numberPredicate)) //
                .collect(toList());
    }

    private FizzBuzzPlayer combineVariations(List<NumberPredicatePlayer> players) {
        FizzBuzzPlayer player = null;

        if (!players.isEmpty()) {
            if (players.size() == 1) {
                player = players.get(0);
            } else {
                VariationAssembler variationAssembler = new VariationAssembler(ordinaryPlayers());
                List<FizzBuzzFunction> assembledFizzBuzzFunctions = variationAssembler.assembleFizzBuzzFunctions();
                player = new OrdinaryPlayer(assembledFizzBuzzFunctions, configuration);
            }
        }

        return player;
    }

    private List<OrdinaryPlayer> ordinaryPlayers() {
        return players.stream().map(p -> (OrdinaryPlayer) p).collect(toList());
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