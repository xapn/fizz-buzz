package software.works.fizzbuzz.rule;

import static java.util.stream.Collectors.toList;
import static software.works.fizzbuzz.rule.DictionaryWord.BUZZ;
import static software.works.fizzbuzz.rule.DictionaryWord.FIZZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import software.works.fizzbuzz.Player;

public class PlayerBuilder {

    private static final List<Word> DEFAULT_WORDS = Arrays.asList(FIZZ.getWord(), BUZZ.getWord());

    private final List<Word> words;
    private final List<NumberPredicatePlayer> players;
    private final PlayerConfiguration configuration;

    public PlayerBuilder() {
        words = new ArrayList<>();
        players = new ArrayList<>();
        configuration = new PlayerConfiguration();
    }

    public PlayerBuilder append(Word word) {
        words.add(word);
        return this;
    }

    public PlayerBuilder append(DictionaryWord dictionaryWord) {
        return append(dictionaryWord.getWord());
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

    public Player chosenPlayer() {
        chooseDefaultWordsIfNotSpecified(words);
        chooseClassicPlayerByDefaultIfUnknown(players);
        Player definitivePlayer = null;

        if (configuration.wordsMustBePrintedOnlyOnce()) {
            definitivePlayer = buildWordCentricPlayer(players);
        } else {
            definitivePlayer = buildPredicateCentricPlayer(players);
        }

        return definitivePlayer;
    }

    private void chooseDefaultWordsIfNotSpecified(List<Word> words) {
        if (words.isEmpty()) {
            words.addAll(DEFAULT_WORDS);
        }
    }

    private List<NumberPredicatePlayer> chooseClassicPlayerByDefaultIfUnknown(List<NumberPredicatePlayer> players) {
        if (players.isEmpty()) {
            players.add(new DivisionPlayer());
        }
        return players;
    }

    private Player buildWordCentricPlayer(List<NumberPredicatePlayer> players) {
        List<NumberPredicate> allNumberPredicates = players.stream() //
                .map(player -> player.getNumberPredicate()) //
                .collect(toList());
        List<FizzBuzzFunction> wordOrientedFunctions = buildWordCentricFunctions(allNumberPredicates);
        Player wordOrientedPlayer = new OrdinaryPlayer(wordOrientedFunctions, configuration) {};

        return wordOrientedPlayer;
    }

    private Player buildPredicateCentricPlayer(List<NumberPredicatePlayer> players) {
        players.stream().forEach(player -> {
            player.setFizzBuzzFunctions(buildPredicateCentricFunctions(player.getNumberPredicate()));
            player.setConfiguration(configuration);
        });
        return combineVariations(players);
    }

    private List<FizzBuzzFunction> buildWordCentricFunctions(List<NumberPredicate> numberPredicates) {
        return words.stream() //
                .map(word -> word.ifNumberSatisfies(numberPredicates)) //
                .collect(toList());
    }

    private List<FizzBuzzFunction> buildPredicateCentricFunctions(NumberPredicate numberPredicate) {
        return words.stream() //
                .map(word -> configuration.wordsMustBePrintedNTimes() ? word.nTimesIfNumberSatisfies(numberPredicate)
                        : word.ifNumberSatisfies(numberPredicate)) //
                .collect(toList());
    }

    private Player combineVariations(List<NumberPredicatePlayer> players) {
        Player player = null;

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
}