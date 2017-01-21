package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigIntegers;

import java.util.List;

import software.works.fizzbuzz.FizzBuzzRange.RangeHandler;
import software.works.fizzbuzz.engine.PlayerBuilder;

public class FizzBuzzWordsAsList {

    private PlayerBuilder playerBuilder;

    FizzBuzzWordsAsList(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    @SafeVarargs
    public final <T> List<String> of(T... values) {
        return playerBuilder.chosenPlayer().playAtFizzBuzzToList(toBigIntegers(values));
    }

    public <T> FizzBuzzRange<T, List<String>> from(T start) {
        RangeHandler<List<String>> rangeHandler = (values) -> playerBuilder.chosenPlayer().playAtFizzBuzzToList(values);
        return new FizzBuzzRange<T, List<String>>(rangeHandler).from(start);
    }
}