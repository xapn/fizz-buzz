package software.works.fizzbuzz.rule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import software.works.fizzbuzz.Player;

public class VariationsCombiningPlayer extends AbstractPlayer {

    private List<Player> players;

    public VariationsCombiningPlayer(List<Player> players) {
        this.players = players;
        managePredicates();
    }

    @Override
    protected void recordPredicates(List<FizzBuzzPredicate> predicates) {
        List<FizzBuzzPredicate> combinedPredicates = combinePredicatesFromPlayers(players);
        predicates.addAll(combinedPredicates);
    }

    private List<FizzBuzzPredicate> combinePredicatesFromPlayers(List<Player> players) {
        List<FizzBuzzPredicate> combined = new ArrayList<>();

        for (int index = 0; index < maximalNumberOfPredicatesByPlayer(players).get(); index++) {
            combined.addAll(onePredicateByPlayer(index, players));
        }

        return combined;
    }

    private Optional<Integer> maximalNumberOfPredicatesByPlayer(List<Player> players) {
        return players.stream() //
                .map(player -> ((AbstractPlayer) player).getPredicates().size()) //
                .max(Comparator.naturalOrder());
    }

    private List<FizzBuzzPredicate> onePredicateByPlayer(int index, List<Player> players) {
        List<FizzBuzzPredicate> predicatesOneByPlayer = new ArrayList<>(players.size());

        for (Player player : players) {
            List<FizzBuzzPredicate> playerPredicates = ((AbstractPlayer) player).getPredicates();
            if (index < playerPredicates.size()) {
                predicatesOneByPlayer.add(playerPredicates.get(index));
            }
        }

        return predicatesOneByPlayer;
    }
}