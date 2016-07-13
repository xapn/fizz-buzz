package software.works.fizzbuzz.rule;

import static java.util.stream.Collectors.joining;

import java.util.Collection;

import software.works.fizzbuzz.Player;

public class VariationsCombiningPlayer implements Player {

    private Collection<Player> players;

    public VariationsCombiningPlayer(Collection<Player> players) {
        this.players = players;
    }

    @Override
    public String playAtFizzBuzz(int value) {
        return players.stream() //
                .map(player -> player.playAtFizzBuzz(value)) //
                .collect(joining());
    }
}