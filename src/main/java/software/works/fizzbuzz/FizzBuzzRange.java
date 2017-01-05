package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;

public class FizzBuzzRange {

    private Player player;
    private long start;

    FizzBuzzRange(Player player) {
        this.player = player;
    }

    FizzBuzzRange from(long start) {
        this.start = start;
        return this;
    }

    public String to(long end) {
        return player.playAtFizzBuzz(toBigIntegerRangeClosed(start, end));
    }
}