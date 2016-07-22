package software.works.fizzbuzz.rule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import software.works.fizzbuzz.Player;

class VariationsCombiningPlayer extends OrdinaryPlayer {

    private List<Player> players;

    VariationsCombiningPlayer(List<Player> players, PlayerConfiguration configuration) {
        if (players == null || players.isEmpty()) {
            throw new IllegalStateException("No player found!");
        } else {
            this.players = players;
            setConfiguration(configuration);
            manageFizzBuzzFunctions();
        }
    }

    void manageFizzBuzzFunctions() {
        fizzBuzzFunctions = new ArrayList<>();
        record(fizzBuzzFunctions);
        validate(fizzBuzzFunctions);
    }

    private void record(List<FizzBuzzFunction> fizzBuzzFunctions) {
        List<FizzBuzzFunction> combinedFunctions = combineFunctionsFromPlayers(players);
        fizzBuzzFunctions.addAll(combinedFunctions);
    }

    private List<FizzBuzzFunction> combineFunctionsFromPlayers(List<Player> players) {
        List<FizzBuzzFunction> combined = new ArrayList<>();

        for (int index = 0; index < maximalNumberOfFunctionsByPlayer(players).get(); index++) {
            combined.addAll(oneFizzBuzzFunctionByPlayer(index, players));
        }

        return combined;
    }

    private Optional<Integer> maximalNumberOfFunctionsByPlayer(List<Player> players) {
        return players.stream() //
                .map(player -> ((OrdinaryPlayer) player).getFizzBuzzFunctions().size()) //
                .max(Comparator.naturalOrder());
    }

    private List<FizzBuzzFunction> oneFizzBuzzFunctionByPlayer(int index, List<Player> players) {
        List<FizzBuzzFunction> functionsOneByPlayer = new ArrayList<>(players.size());

        for (Player player : players) {
            List<FizzBuzzFunction> playerFunctions = ((OrdinaryPlayer) player).getFizzBuzzFunctions();
            if (index < playerFunctions.size()) {
                functionsOneByPlayer.add(playerFunctions.get(index));
            }
        }

        return functionsOneByPlayer;
    }

    private void validate(List<FizzBuzzFunction> fizzBuzzFunctions) {
        if (fizzBuzzFunctions == null || fizzBuzzFunctions.isEmpty()) {
            throw new IllegalStateException("No FizzBuzz function found!");
        }
    }
}