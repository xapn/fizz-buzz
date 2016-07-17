package software.works.fizzbuzz;

import java.util.List;

public interface Player {

    String playAtFizzBuzz(int value);

    String playAtFizzBuzz(int... values);

    void adoptWords(List<Word> words);
}