package software.works.fizzbuzz;

import java.util.LinkedList;

import software.works.fizzbuzz.rule.VariationsCombiningPlayer;
import software.works.fizzbuzz.rule.DigitPlayer;
import software.works.fizzbuzz.rule.DivisionPlayer;

public class FizzBuzz {

    private Player player;
    private LinkedList<Player> players;

    public FizzBuzz() {
        players = new LinkedList<>();
    }

    public String of(int value) {
        if (!players.isEmpty()) {
            player = new VariationsCombiningPlayer(players);
        }
        chooseClassicPlayerByDefault();

        return player.playAtFizzBuzz(value);
    }

    public FizzBuzzRange from(int start) {
        chooseClassicPlayerByDefault();
        return new FizzBuzzRange(player).from(start);
    }

    public FizzBuzz whenNumberHasFactors() {
        players.addLast(new DivisionPlayer());
        return this;
    }

    public FizzBuzz whenNumberContainsDigits() {
        players.addLast(new DigitPlayer());
        return this;
    }

    private void chooseClassicPlayerByDefault() {
        if (player == null) {
            player = new DivisionPlayer();
        }
    }
}