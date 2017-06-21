package software.works.fizzbuzz.engine.build;

import java.util.List;

import software.works.fizzbuzz.FizzBuzzPlayer;
import software.works.fizzbuzz.engine.PlayConfiguration;
import software.works.fizzbuzz.engine.lexicon.WordPropertyPair;
import software.works.fizzbuzz.engine.play.NumberPredicatePlayer;

abstract class AbstractCentricPlayerBuilder {

    protected List<WordPropertyPair> wordPropertyPairs;
    protected PlayConfiguration configuration;
    protected List<NumberPredicatePlayer> players;
    private FizzBuzzPlayer player;

    AbstractCentricPlayerBuilder coupleWordsAndProperties(List<WordPropertyPair> wordPropertyPairs) {
        this.wordPropertyPairs = wordPropertyPairs;
        return this;
    }

    AbstractCentricPlayerBuilder playThisWay(PlayConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }

    AbstractCentricPlayerBuilder assemblyPlayers(List<NumberPredicatePlayer> players) {
        this.players = players;
        validate();
        player = buildPlayer(players);
        return this;
    }

    private void validate() {
        if (wordPropertyPairs == null || wordPropertyPairs.isEmpty() || configuration == null || players == null
                || players.isEmpty()) {
            throw new IllegalStateException("The builder is not ready to build a player!");
        }
    }

    abstract protected FizzBuzzPlayer buildPlayer(List<NumberPredicatePlayer> players);

    FizzBuzzPlayer getPlayer() {
        return player;
    }
}