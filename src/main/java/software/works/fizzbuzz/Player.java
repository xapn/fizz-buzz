package software.works.fizzbuzz;

import java.util.List;

public interface Player {

    String playAtFizzBuzz(int value);

    String playAtFizzBuzz(int... values);

    List<String> playAtFizzBuzzToList(int... values);

    List<FizzbuzzifiedNumber> fizzbuzzify(int... values);
}