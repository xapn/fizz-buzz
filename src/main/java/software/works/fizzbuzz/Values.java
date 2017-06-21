package software.works.fizzbuzz;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.math.BigInteger.ONE;
import static java.util.stream.Collectors.toList;

public class Values {

    public static BigInteger toBigInteger(int value) {
        return BigInteger.valueOf(value);
    }

    public static BigInteger toBigInteger(long value) {
        return BigInteger.valueOf(value);
    }

    public static BigInteger toBigInteger(String value) {
        return new BigInteger(value);
    }

    public static BigInteger toBigInteger(Object value) {
        if (value instanceof Integer) {
            return toBigInteger((int) value);
        } else if (value instanceof Long) {
            return toBigInteger((long) value);
        } else if (value instanceof String) {
            return toBigInteger((String) value);
        } else if (value instanceof BigInteger) {
            return (BigInteger) value;
        } else {
            throw new IllegalArgumentException("Unexpected type of argument: value instance of " + value.getClass());
        }
    }

    public static List<BigInteger> toBigIntegers(int... values) {
        return IntStream
                .of(values)
                .mapToObj(BigInteger::valueOf)
                .collect(toList());
    }

    public static List<BigInteger> toBigIntegers(Integer... values) {
        return Arrays
                .asList(values)
                .stream()
                .map(BigInteger::valueOf)
                .collect(toList());
    }

    public static List<BigInteger> toBigIntegers(long... values) {
        return LongStream
                .of(values)
                .mapToObj(BigInteger::valueOf)
                .collect(toList());
    }

    public static List<BigInteger> toBigIntegers(Long... values) {
        return Arrays
                .asList(values)
                .stream()
                .map(BigInteger::valueOf)
                .collect(toList());
    }

    public static List<BigInteger> toBigIntegers(String... values) {
        return Arrays
                .asList(values)
                .stream()
                .map(BigInteger::new)
                .collect(toList());
    }

    public static List<BigInteger> toBigIntegers(BigInteger... values) {
        return Arrays.asList(values);
    }

    public static List<BigInteger> toBigIntegers(Object... values) {
        if (values instanceof Integer[]) {
            return toBigIntegers((Integer[]) values);
        } else if (values instanceof Long[]) {
            return toBigIntegers((Long[]) values);
        } else if (values instanceof String[]) {
            return toBigIntegers((String[]) values);
        } else if (values instanceof BigInteger[]) {
            return toBigIntegers((BigInteger[]) values);
        } else {
            throw new IllegalArgumentException("Unexpected type of argument: values instance of " + values.getClass());
        }
    }

    public static List<BigInteger> toBigIntegerRangeClosed(Integer start, Integer end) {
        return IntStream
                .rangeClosed(start, end)
                .mapToObj(BigInteger::valueOf)
                .collect(toList());
    }

    public static List<BigInteger> toBigIntegerRangeClosed(Long start, Long end) {
        return LongStream
                .rangeClosed(start, end)
                .mapToObj(BigInteger::valueOf)
                .collect(toList());
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

    public static List<BigInteger> toBigIntegerRangeClosed(String start, String end) {
        return toBigIntegerRangeClosed(toBigInteger(start), toBigInteger(end));
    }

    public static <T> List<BigInteger> toBigIntegerRangeClosed(T start, T end) {
        if (start instanceof Integer && end instanceof Integer) {
            return toBigIntegerRangeClosed((Integer) start, (Integer) end);
        } else if (start instanceof Long && end instanceof Long) {
            return toBigIntegerRangeClosed((Long) start, (Long) end);
        } else if (start instanceof BigInteger && end instanceof BigInteger) {
            return toBigIntegerRangeClosed((BigInteger) start, (BigInteger) end);
        } else if (start instanceof String && end instanceof String) {
            return toBigIntegerRangeClosed((String) start, (String) end);
        } else {
            throw new IllegalArgumentException(
                    "Unexpected type of arguments: start instance of " + start.getClass() + ", end instance of " +
                            end.getClass());
        }
    }
}