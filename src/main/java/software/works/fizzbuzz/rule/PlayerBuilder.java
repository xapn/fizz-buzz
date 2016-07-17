package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.DictionaryWord.BUZZ;
import static software.works.fizzbuzz.rule.DictionaryWord.FIZZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import software.works.fizzbuzz.Player;

public class PlayerBuilder {

    private List<Word> words;
    private List<Player> players;

    public PlayerBuilder() {
        words = new ArrayList<>();
        players = new ArrayList<>();
    }

    public PlayerBuilder append(Word word) {
        words.add(word);
        return this;
    }

    public PlayerBuilder append(DictionaryWord dictionaryWord) {
        return append(dictionaryWord.getWord());
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
    }

    private List<FizzBuzzPredicate> buildPredicates(NumberPredicate numberPredicate) {
        List<FizzBuzzPredicate> predicates = new ArrayList<>();
        words.stream().forEachOrdered(word -> {
            predicates.add(wordIf(word.getWord(), numberPredicate.appliedTo(word.getProperty())));
        });
        return predicates;
    }

    private FizzBuzzPredicate wordIf(String word, Predicate<Integer> predicate) {
        return value -> predicate.test(value) ? word : "";
    }

    private Player combineVariations(List<Player> players) {
        Player player = null;

        if (!players.isEmpty()) {
            if (players.size() == 1) {
                player = players.get(0);
            } else {
                player = new VariationsCombiningPlayer(players);
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
}