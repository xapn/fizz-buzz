package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;

public class FizzBuzzRange<T> {

    private Player player;
    private T start;

    FizzBuzzRange(Player player) {
        this.player = player;
    }

    FizzBuzzRange<T> from(T start) {
        this.start = start;
        return this;
    }

    public String to(T end) {
        return player.playAtFizzBuzz(toBigIntegerRangeClosed(start, end));
    }
}