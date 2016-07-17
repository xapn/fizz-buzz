package software.works.fizzbuzz;

import java.util.List;

import software.works.fizzbuzz.rule.Word;

public interface Player {

    String playAtFizzBuzz(int value);

    String playAtFizzBuzz(int... values);

    void adoptWords(List<Word> words);
}