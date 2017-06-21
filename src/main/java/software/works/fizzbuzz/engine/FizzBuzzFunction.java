package software.works.fizzbuzz.engine;

import java.math.BigInteger;

@FunctionalInterface
public interface FizzBuzzFunction {

    /**
     * Return a word according to one predicate.
     *
     * @param value the value to be tested
     * @return the word of the predicate if true, otherwise empty string
     */
    String fizzBuzzOf(BigInteger value);
}