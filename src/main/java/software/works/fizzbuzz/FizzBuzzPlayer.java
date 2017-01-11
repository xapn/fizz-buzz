package software.works.fizzbuzz;

import java.math.BigInteger;
import java.util.List;

public interface FizzBuzzPlayer {

    String playAtFizzBuzz(BigInteger value);

    String playAtFizzBuzz(List<BigInteger> values);

    List<String> playAtFizzBuzzToList(List<BigInteger> values);

    List<FizzbuzzifiedNumber> fizzbuzzify(List<BigInteger> values);
}