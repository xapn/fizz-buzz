package software.works.fizzbuzz;

import static java.math.BigInteger.ONE;
import static java.util.stream.Collectors.toList;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Values {

    public static BigInteger toBigInteger(long value) {
        return BigInteger.valueOf(value);
    }

    public static BigInteger toBigInteger(String value) {
        return new BigInteger(value);
    }

    public static List<BigInteger> toBigInteger(long... values) {
        return LongStream.of(values).mapToObj(BigInteger::valueOf).collect(toList());
    }

    public static List<BigInteger> toBigInteger(String... values) {
        return Arrays.asList(values).stream().map(BigInteger::new).collect(toList());
    }

    public static List<BigInteger> toBigIntegerRangeClosed(long start, long end) {
        return LongStream.rangeClosed(start, end).mapToObj(BigInteger::valueOf).collect(toList());
    }

    public static List<BigInteger> toBigIntegerRangeClosed(BigInteger start, BigInteger end) {
        List<BigInteger> range = new ArrayList<>();

        BigInteger current = start;
        while (current.compareTo(end) <= 0) {
            range.add(current);
            current = current.add(ONE);
        }

        return range;
    }
}