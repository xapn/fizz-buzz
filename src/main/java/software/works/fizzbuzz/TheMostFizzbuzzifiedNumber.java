package software.works.fizzbuzz;

import java.util.Optional;
import java.util.stream.IntStream;

import software.works.fizzbuzz.rule.PlayerBuilder;

class TheMostFizzbuzzifiedNumber {

    private FizzBuzzFinder finder;
    private int start;

    TheMostFizzbuzzifiedNumber(PlayerBuilder playerBuilder) {
        finder = new FizzBuzzFinder(playerBuilder);
    }

    public Optional<Integer> in(int... values) {
        Optional<FizzbuzzifiedNumber> theMostFizzbuzzified = finder.find(values);
        return theMostFizzbuzzified.isPresent() ? Optional.of(theMostFizzbuzzified.get().getNumber())
                : Optional.empty();
    }

    public TheMostFizzbuzzifiedNumber from(int start) {
        this.start = start;
        return this;
    }

    public Optional<Integer> to(int end) {
        return in(IntStream.rangeClosed(start, end).toArray());
    }
}