package software.works.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import software.works.fizzbuzz.rule.DigitPlayer;
import software.works.fizzbuzz.rule.DivisionPlayer;
import software.works.fizzbuzz.rule.VariationsCombiningPlayer;

public class FizzBuzz {

    private Player player;
    private List<Player> players;

    public FizzBuzz() {
        players = new ArrayList<>();
    }

    public String of(int value) {
        combineVariations();
        chooseClassicPlayerByDefault();
        return player.playAtFizzBuzz(value);
    }

    public FizzBuzzRange from(int start) {
        combineVariations();
        chooseClassicPlayerByDefault();
        return new FizzBuzzRange(player).from(start);
    }

    public FizzBuzz whenNumberHasFactors() {
        players.add(new DivisionPlayer());
        return this;
    }

    public FizzBuzz whenNumberContainsDigits() {
        players.add(new DigitPlayer());
        return this;
    }

    private void chooseClassicPlayerByDefault() {
        if (player == null) {
            player = new DivisionPlayer();
        }
    }

    private void combineVariations() {
        if (!players.isEmpty()) {
            if (players.size() == 1) {
                player = players.get(0);
            } else {
                player = new VariationsCombiningPlayer(players);
            }
        }
    }
}