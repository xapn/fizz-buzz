package software.works.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import software.works.fizzbuzz.rule.DigitPlayer;
import software.works.fizzbuzz.rule.DivisionPlayer;
import software.works.fizzbuzz.rule.VariationsCombiningPlayer;

public class FizzBuzz {

    private List<Player> players;

    public FizzBuzz() {
        players = new ArrayList<>();
    }

    public String of(int value) {
        return chosenPlayer().playAtFizzBuzz(value);
    }

    public FizzBuzzRange from(int start) {
        return new FizzBuzzRange(chosenPlayer()).from(start);
    }

    public FizzBuzz whenNumberHasFactors() {
        players.add(new DivisionPlayer());
        return this;
    }

    public FizzBuzz whenNumberContainsDigits() {
        players.add(new DigitPlayer());
        return this;
    }

    private Player chosenPlayer() {
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