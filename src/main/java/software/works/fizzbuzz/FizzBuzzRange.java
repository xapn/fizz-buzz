package software.works.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzRange {

    private static final String DELIMITER = " ";

    private Player player;
    private int start;

    FizzBuzzRange(Player player) {
        this.player = player;
    }

    FizzBuzzRange from(int start) {
        this.start = start;
        return this;
    }

    public String to(int end) {
        return IntStream.rangeClosed(start, end) //
                .mapToObj(player::playAtFizzBuzz) //
                .collect(Collectors.joining(DELIMITER));
    }
}