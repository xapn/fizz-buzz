package software.works.fizzbuzz;

import software.works.fizzbuzz.FizzBuzzRange.RangeHandler;
import software.works.fizzbuzz.engine.build.PlayerBuilder;

import java.util.Optional;

import static software.works.fizzbuzz.Values.toBigIntegers;

public class TheMostFizzyBuzzy {

    private FizzBuzzFinder finder;
    private Optional<FizzbuzzifiedNumber> theMostFizzyBuzzy;

    TheMostFizzyBuzzy(PlayerBuilder playerBuilder) {
        finder = new FizzBuzzFinder(playerBuilder);
    }

    @SafeVarargs
    public final <T> TheMostFizzyBuzzy in(T... values) {
        theMostFizzyBuzzy = finder.find(toBigIntegers(values));
        return this;
    }

    public <T> FizzBuzzRange<T, TheMostFizzyBuzzy> from(T start) {
        RangeHandler<TheMostFizzyBuzzy> rangeHandler = (values) -> {
            theMostFizzyBuzzy = finder.find(values);
            return this;
        };
        return new FizzBuzzRange<T, TheMostFizzyBuzzy>(rangeHandler).from(start);
    }

    public Optional<FizzbuzzifiedNumber> get() {
        return theMostFizzyBuzzy;
    }

    public Optional<String> asNumber() {
        return theMostFizzyBuzzy.isPresent() ? Optional.of(theMostFizzyBuzzy
                .get()
                .getNumber()
                .toString()) : Optional.empty();
    }

    public Optional<String> asWord() {
        return theMostFizzyBuzzy.isPresent() ? Optional.of(theMostFizzyBuzzy
                .get()
                .getFizzbuzzified()) : Optional.empty();
    }
}