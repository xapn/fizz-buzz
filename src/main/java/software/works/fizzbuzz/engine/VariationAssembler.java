package software.works.fizzbuzz.engine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class VariationAssembler {

    private List<OrdinaryPlayer> players;

    VariationAssembler(List<OrdinaryPlayer> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalStateException("No player found!");
        } else {
            this.players = players;
        }
    }

    List<FizzBuzzFunction> assembleFizzBuzzFunctions() {
        List<FizzBuzzFunction> fizzBuzzFunctions = new ArrayList<>();
        record(fizzBuzzFunctions);
        validate(fizzBuzzFunctions);
        return fizzBuzzFunctions;
    }

    private void record(List<FizzBuzzFunction> fizzBuzzFunctions) {
        List<FizzBuzzFunction> combinedFunctions = combineFunctionsFromPlayers(players);
        fizzBuzzFunctions.addAll(combinedFunctions);
    }

    private List<FizzBuzzFunction> combineFunctionsFromPlayers(List<OrdinaryPlayer> players) {
        List<FizzBuzzFunction> combined = new ArrayList<>();

        for (int index = 0; index < maximalNumberOfFunctionsByPlayer(players).get(); index++) {
            combined.addAll(oneFizzBuzzFunctionByPlayer(index, players));
        }

        return combined;
    }

    private Optional<Integer> maximalNumberOfFunctionsByPlayer(List<OrdinaryPlayer> players) {
        return players.stream() //
                .map(player -> player.getFizzBuzzFunctions().size()) //
                .max(Comparator.naturalOrder());
    }

    private List<FizzBuzzFunction> oneFizzBuzzFunctionByPlayer(int index, List<OrdinaryPlayer> players) {
        List<FizzBuzzFunction> functionsOneByPlayer = new ArrayList<>(players.size());

        players.stream().map(player -> player.getFizzBuzzFunctions()).forEachOrdered(playerFunctions -> {
            if (index < playerFunctions.size()) {
                functionsOneByPlayer.add(playerFunctions.get(index));
            }
        });

        return functionsOneByPlayer;
    }

    private void validate(List<FizzBuzzFunction> fizzBuzzFunctions) {
        if (fizzBuzzFunctions == null || fizzBuzzFunctions.isEmpty()) {
            throw new IllegalStateException("No FizzBuzz function found!");
        }
    }
}