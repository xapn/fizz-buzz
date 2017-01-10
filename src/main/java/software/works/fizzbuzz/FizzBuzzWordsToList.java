package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;
import static software.works.fizzbuzz.Values.toBigIntegers;

import java.util.List;

import software.works.fizzbuzz.rule.PlayerBuilder;

class FizzBuzzWordsToList {

    private PlayerBuilder playerBuilder;
    private long start;

    FizzBuzzWordsToList(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    public List<String> of(long... values) {
        return playerBuilder.chosenPlayer().playAtFizzBuzzToList(toBigIntegers(values));
    }

    public FizzBuzzWordsToList from(long start) {
        this.start = start;
        return this;
    }

    public List<String> to(long end) {
        return playerBuilder.chosenPlayer().playAtFizzBuzzToList(toBigIntegerRangeClosed(start, end));
    }
}