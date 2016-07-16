package software.works.fizzbuzz.rule;

import java.util.ArrayList;
import java.util.List;

import software.works.fizzbuzz.Player;

public class PlayerBuilder {

    private List<Player> players;

    public PlayerBuilder() {
        players = new ArrayList<>();
    }

    public PlayerBuilder append(Player player) {
        players.add(player);
        return this;
    }

    public Player chosenPlayer() {
        Player player = combineVariations(players);
        return chooseClassicPlayerByDefaultIfUnknown(player);
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
}