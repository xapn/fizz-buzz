package software.works.fizzbuzz;

import static java.util.stream.Collectors.toList;

import java.math.BigInteger;
import java.util.stream.LongStream;

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
        return player
                .playAtFizzBuzz(LongStream.rangeClosed(start, end).mapToObj(BigInteger::valueOf).collect(toList()));
    }
}