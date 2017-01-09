package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigInteger;
import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;

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

    public TheMostFizzyBuzzy in(long... values) {
        theMostFizzyBuzzy = finder.find(toBigInteger(values));
        return this;
    }

    public TheMostFizzyBuzzy in(String... values) {
        theMostFizzyBuzzy = finder.find(toBigInteger(values));
        return this;
    }

    public TheMostFizzyBuzzy in(BigInteger... values) {
        theMostFizzyBuzzy = finder.find(toBigInteger(values));
        return this;
    }

    public TheMostFizzyBuzzy from(long start) {
        this.start = toBigInteger(start);
        return this;
    }

    public TheMostFizzyBuzzy from(String start) {
        this.start = toBigInteger(start);
        return this;
    }

    public TheMostFizzyBuzzy to(long end) {
        theMostFizzyBuzzy = finder.find(toBigIntegerRangeClosed(start, toBigInteger(end)));
        return this;
    }

    public TheMostFizzyBuzzy to(String end) {
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