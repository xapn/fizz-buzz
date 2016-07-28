package software.works.fizzbuzz;

import java.util.List;
import java.util.stream.IntStream;

import software.works.fizzbuzz.rule.PlayerBuilder;

class FizzBuzzWordsToList {

    private PlayerBuilder playerBuilder;
    private int start;

    FizzBuzzWordsToList(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    public List<String> of(int... values) {
        return playerBuilder.chosenPlayer().playAtFizzBuzzToList(values);
    }

    public FizzBuzzWordsToList from(int start) {
        this.start = start;
        return this;
    }

    public List<String> to(int end) {
        return playerBuilder.chosenPlayer().playAtFizzBuzzToList(IntStream.rangeClosed(start, end).toArray());
    }
}