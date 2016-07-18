package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.DictionaryWord.BUZZ;
import static software.works.fizzbuzz.rule.DictionaryWord.FIZZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import software.works.fizzbuzz.Player;

public class PlayerBuilder {

    private static final String DEFAULT_WORD_SEPARATOR = " ";
    private static final String DEFAULT_FINAL_PUNCTUATION = "";

    private List<Word> words;
    private List<Player> players;
    private String wordSeparator;
    private String finalPunctuation;

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

    public PlayerBuilder separateWordsBy(String wordSeparator) {
        this.wordSeparator = wordSeparator;
        return this;
    }

    public void completeSentenceWith(String finalPunctuation) {
        this.finalPunctuation = finalPunctuation;
    }

    public PlayerBuilder append(Player player) {
        players.add(player);
        return this;
    }

    public Player chosenPlayer() {
        words = chooseDefaultWordsIfNotDefined(words);
        chooseClassicPlayerByDefaultIfUnknown(players);
        chooseDefaultWordSeparatorIfNotDefined();
        chooseDefaultFinalPunctuationIfNotDefined();

        buildPlayers(players);
        Player player = combineVariations(players);

        return player;
    }

    private void chooseDefaultWordSeparatorIfNotDefined() {
        if (wordSeparator == null) {
            wordSeparator = DEFAULT_WORD_SEPARATOR;
        }
    }

    private void chooseDefaultFinalPunctuationIfNotDefined() {
        if (finalPunctuation == null) {
            finalPunctuation = DEFAULT_FINAL_PUNCTUATION;
        }
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
        abstractPlayer.setWordSeparator(wordSeparator);
        abstractPlayer.setFinalPunctuation(finalPunctuation);
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