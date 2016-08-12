package software.works.fizzbuzz;

import java.util.List;

public interface Player {

    String playAtFizzBuzz(long value);

    String playAtFizzBuzz(long... values);

    List<String> playAtFizzBuzzToList(long... values);

    List<FizzbuzzifiedNumber> fizzbuzzify(long... values);
}