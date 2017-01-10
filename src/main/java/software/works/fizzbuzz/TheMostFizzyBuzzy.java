package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;
import static software.works.fizzbuzz.Values.toBigIntegers;

import java.util.Optional;

import software.works.fizzbuzz.rule.PlayerBuilder;

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

    public <T> TheMostFizzyBuzzyOfRange<T> from(T start) {
        return new TheMostFizzyBuzzyOfRange<T>(this).from(start);
    }

    class TheMostFizzyBuzzyOfRange<T> {

        private TheMostFizzyBuzzy enclosing;
        private T start;

        TheMostFizzyBuzzyOfRange(TheMostFizzyBuzzy theMostFizzyBuzzy) {
            this.enclosing = theMostFizzyBuzzy;
        }

        TheMostFizzyBuzzyOfRange<T> from(T start) {
            this.start = start;
            return this;
        }

        public TheMostFizzyBuzzy to(T end) {
            theMostFizzyBuzzy = finder.find(toBigIntegerRangeClosed(start, end));
            return enclosing;
        }
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