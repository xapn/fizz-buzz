package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigInteger;
import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;

import java.math.BigInteger;

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

    static class BigIntegerRange {

        private Player player;
        private BigInteger start;

        BigIntegerRange(Player player) {
            this.player = player;
        }

        BigIntegerRange from(String start) {
            this.start = toBigInteger(start);
            return this;
        }

        public String to(String end) {
            return player.playAtFizzBuzz(toBigIntegerRangeClosed(start, toBigInteger(end)));
        }
    }
}