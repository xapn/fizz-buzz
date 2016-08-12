package software.works.fizzbuzz;

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
        return playerBuilder.chosenPlayer().playAtFizzBuzzToList(values);
    }

    public FizzBuzzWordsToList from(long start) {
        this.start = start;
        return this;
    }

    public List<String> to(int end) {
        return playerBuilder.chosenPlayer().playAtFizzBuzzToList(LongStream.rangeClosed(start, end).toArray());
    }
}