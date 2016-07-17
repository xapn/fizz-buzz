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
        buildPlayers(players);
        Player player = combineVariations(players);
        player = chooseClassicPlayerByDefaultIfUnknown(player);

        words = chooseDefaultWordsIfNotDefined(words);
        buildPlayer(player);

        return player;
    }

    private void buildPlayers(List<Player> players) {
        players.stream().forEach(this::buildPlayer);
    }

    private void buildPlayer(Player player) {
        player.adoptWords(chooseDefaultWordsIfNotDefined(words));
        ((AbstractPlayer) player).managePredicates();
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

    private Player chooseClassicPlayerByDefaultIfUnknown(Player player) {
        if (player == null) {
            player = new DivisionPlayer();
        }
        return player;
    }

    private List<Word> chooseDefaultWordsIfNotDefined(List<Word> words) {
        if (words == null || words.isEmpty()) {
            words.addAll(Arrays.asList(FIZZ.getWord(), BUZZ.getWord()));
        }
        return words;
    }
}