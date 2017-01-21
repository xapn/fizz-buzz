package software.works.fizzbuzz.engine;

import static java.util.stream.Collectors.toList;

import java.util.List;

import software.works.fizzbuzz.FizzBuzzPlayer;

class PredicateCentricPlayerBuilder extends AbstractCentricPlayerBuilder {

    @Override
    protected FizzBuzzPlayer buildPlayer(List<NumberPredicatePlayer> players) {
        players.stream().forEach(player -> {
            player.setFizzBuzzFunctions(buildPredicateCentricFunctions(player.getNumberPredicate()));
            player.setConfiguration(configuration);
        });
        return combineVariations(players);
    }

    private List<FizzBuzzFunction> buildPredicateCentricFunctions(NumberPredicate numberPredicate) {
        return wordPropertyPairs.stream() //
                .map(pair -> configuration.wordsMustBePrintedNTimes()
                        ? new RightWord(pair).nTimesIfNumberSatisfies(numberPredicate)
                        : new RightWord(pair).ifNumberSatisfies(numberPredicate)) //
                .collect(toList());
    }

    private FizzBuzzPlayer combineVariations(List<NumberPredicatePlayer> players) {
        FizzBuzzPlayer player = null;

        if (!players.isEmpty()) {
            if (players.size() == 1) {
                player = players.get(0);
            } else {
                VariationAssembler variationAssembler = new VariationAssembler(ordinaryPlayers(players));
                List<FizzBuzzFunction> assembledFizzBuzzFunctions = variationAssembler.assembleFizzBuzzFunctions();
                player = new OrdinaryPlayer(assembledFizzBuzzFunctions, configuration);
            }
        }

        return player;
    }

    private List<OrdinaryPlayer> ordinaryPlayers(List<NumberPredicatePlayer> players) {
        return players.stream().map(p -> (OrdinaryPlayer) p).collect(toList());
    }
}
