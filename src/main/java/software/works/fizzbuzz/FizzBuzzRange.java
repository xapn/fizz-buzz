package software.works.fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzzRange {

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
        return player.playAtFizzBuzz(IntStream.rangeClosed(start, end).toArray());
    }
}