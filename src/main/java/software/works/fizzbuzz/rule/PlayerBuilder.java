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
    private final List<Player> players;
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

    public PlayerBuilder append(Player player) {
        players.add(player);
        return this;
    }

    public Player chosenPlayer() {
        chooseDefaultWordsIfNotSpecified(words);
        chooseClassicPlayerByDefaultIfUnknown(players);
        Player definitivePlayer = null;

        if (configuration.wordsMustBePrintedOnlyOnce()) {
            definitivePlayer = buildWordOrientedPlayer(players);
        } else {
            buildPlayers(players);
            definitivePlayer = combineVariations(players);
        }

        return definitivePlayer;
    }

    private void chooseDefaultWordsIfNotSpecified(List<Word> words) {
        if (words.isEmpty()) {
            words.addAll(DEFAULT_WORDS);
        }
    }

    private Player buildWordOrientedPlayer(List<Player> players) {
        List<NumberPredicate> allNumberPredicates = players.stream() //
                .map(player -> ((AbstractPlayer) player).getNumberPredicate()) //
                .collect(toList());
        List<FizzBuzzPredicate> wordOrientedPredicates = words.stream() //
                .map(word -> word.ifNumberSatisfies(allNumberPredicates)) //
                .collect(toList());
        Player wordOrientedPlayer = new AbstractPlayer(wordOrientedPredicates, configuration) {};

        return wordOrientedPlayer;
    }

    private void buildPlayers(List<Player> players) {
        players.stream().forEach(this::buildPlayer);
    }

    private void buildPlayer(Player player) {
        AbstractPlayer abstractPlayer = (AbstractPlayer) player;
        abstractPlayer.setPredicates(buildPredicates(abstractPlayer.getNumberPredicate()));
        abstractPlayer.setConfiguration(configuration);
    }

    private List<FizzBuzzPredicate> buildPredicates(NumberPredicate numberPredicate) {
        List<FizzBuzzPredicate> predicates = new ArrayList<>();
        words.stream().forEachOrdered(word -> {
            predicates.add(configuration.wordsMustBePrintedNTimes() ? word.nTimesIfNumberSatisfies(numberPredicate)
                    : word.ifNumberSatisfies(numberPredicate));
        });
        return predicates;
    }

    private Player combineVariations(List<Player> players) {
        Player player = null;

        if (!players.isEmpty()) {
            if (players.size() == 1) {
                player = players.get(0);
            } else {
                player = new VariationsCombiningPlayer(players, configuration);
            }
        }

        return player;
    }

    private List<Player> chooseClassicPlayerByDefaultIfUnknown(List<Player> players) {
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
}