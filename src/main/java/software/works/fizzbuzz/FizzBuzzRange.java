package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;

public class FizzBuzzRange<T, R> {

    private Function<List<BigInteger>, R> handler;
    private T start;

    FizzBuzzRange(Function<List<BigInteger>, R> handler) {
        this.handler = handler;
    }

    FizzBuzzRange<T, R> from(T start) {
        this.start = start;
        return this;
    }

    public R to(T end) {
        return handler.apply(toBigIntegerRangeClosed(start, end));
    }
}