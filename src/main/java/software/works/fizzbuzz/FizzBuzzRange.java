package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;

public class FizzBuzzRange<T, R> {

    static interface RangeHandler<R> extends Function<List<BigInteger>, R> {}

    private RangeHandler<R> handler;
    private T start;

    FizzBuzzRange(RangeHandler<R> rangeHandler) {
        this.handler = rangeHandler;
    }

    FizzBuzzRange<T, R> from(T start) {
        this.start = start;
        return this;
    }

    public R to(T end) {
        return handler.apply(toBigIntegerRangeClosed(start, end));
    }
}