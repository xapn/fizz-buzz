package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.DictionaryWord.BUZZ;
import static software.works.fizzbuzz.rule.DictionaryWord.FIZZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import software.works.fizzbuzz.Player;

public class PlayerBuilder {

    private List<Word> words;
    private List<Player> players;
    private PlayerConfiguration configuration;

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
        words = chooseDefaultWordsIfNotDefined(words);
        chooseClassicPlayerByDefaultIfUnknown(players);

        buildPlayers(players);
        Player player = combineVariations(players);

        return player;
    }

    private List<Word> chooseDefaultWordsIfNotDefined(List<Word> words) {
        if (words == null || words.isEmpty()) {
            words.addAll(Arrays.asList(FIZZ.getWord(), BUZZ.getWord()));
        }
        return words;
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
            predicates.add(word.ifNumberSatisfies(numberPredicate));
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
}