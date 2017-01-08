package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigInteger;
import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;

import java.util.Optional;

import software.works.fizzbuzz.rule.PlayerBuilder;

class TheMostFizzyBuzzy {

    private FizzBuzzFinder finder;
    private long start;
    private Optional<FizzbuzzifiedNumber> theMostFizzyBuzzy;

    TheMostFizzyBuzzy(PlayerBuilder playerBuilder) {
        finder = new FizzBuzzFinder(playerBuilder);
    }

    public TheMostFizzyBuzzy in(long... values) {
        theMostFizzyBuzzy = finder.find(toBigInteger(values));
        return this;
    }

    public TheMostFizzyBuzzy in(String... values) {
        theMostFizzyBuzzy = finder.find(toBigInteger(values));
        return this;
    }

    public TheMostFizzyBuzzy from(long start) {
        this.start = start;
        return this;
    }

    public TheMostFizzyBuzzy to(long end) {
        theMostFizzyBuzzy = finder.find(toBigIntegerRangeClosed(start, end));
        return this;
    }

    public Optional<FizzbuzzifiedNumber> get() {
        return theMostFizzyBuzzy;
    }

    public Optional<String> asNumber() {
        return theMostFizzyBuzzy.isPresent() ? Optional.of(theMostFizzyBuzzy.get().getNumber().toString())
                : Optional.empty();
    }

    public Optional<String> asWord() {
        return theMostFizzyBuzzy.isPresent() ? Optional.of(theMostFizzyBuzzy.get().getFizzbuzzified())
                : Optional.empty();
    }
}