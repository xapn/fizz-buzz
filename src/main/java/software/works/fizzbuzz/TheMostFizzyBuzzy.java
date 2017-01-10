package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigInteger;
import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;
import static software.works.fizzbuzz.Values.toBigIntegers;

import java.math.BigInteger;
import java.util.Optional;

import software.works.fizzbuzz.rule.PlayerBuilder;

class TheMostFizzyBuzzy {

    private FizzBuzzFinder finder;
    private BigInteger start;
    private Optional<FizzbuzzifiedNumber> theMostFizzyBuzzy;

    TheMostFizzyBuzzy(PlayerBuilder playerBuilder) {
        finder = new FizzBuzzFinder(playerBuilder);
    }

    @SafeVarargs
    public final <T> TheMostFizzyBuzzy in(T... values) {
        theMostFizzyBuzzy = finder.find(toBigIntegers(values));
        return this;
    }

    public <T> TheMostFizzyBuzzy from(T start) {
        this.start = toBigInteger(start);
        return this;
    }

    public <T> TheMostFizzyBuzzy to(T end) {
        theMostFizzyBuzzy = finder.find(toBigIntegerRangeClosed(start, toBigInteger(end)));
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