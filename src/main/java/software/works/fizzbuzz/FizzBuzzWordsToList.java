package software.works.fizzbuzz;

import static java.util.stream.Collectors.toList;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.LongStream;

import software.works.fizzbuzz.rule.PlayerBuilder;

class FizzBuzzWordsToList {

    private PlayerBuilder playerBuilder;
    private long start;

    FizzBuzzWordsToList(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    public List<String> of(long... values) {
        return playerBuilder.chosenPlayer()
                .playAtFizzBuzzToList(LongStream.of(values).mapToObj(BigInteger::valueOf).collect(toList()));
    }

    public FizzBuzzWordsToList from(long start) {
        this.start = start;
        return this;
    }

    public List<String> to(long end) {
        return playerBuilder.chosenPlayer().playAtFizzBuzzToList(
                LongStream.rangeClosed(start, end).mapToObj(BigInteger::valueOf).collect(toList()));
    }
}