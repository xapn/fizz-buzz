package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicates.IS_MULTIPLE_OF;

import java.util.Arrays;
import java.util.List;

import software.works.fizzbuzz.Word;

public class DivisionPlayer extends AbstractPlayer {

    private List<Word> words;

    public DivisionPlayer() {
        defineDefaultWords();
        managePredicates();
    }

    public DivisionPlayer(Word... words) {
        this.words = Arrays.asList(words);
        managePredicates();
    }

    private void defineDefaultWords() {
        words = Arrays.asList(new Word("Fizz", 3), new Word("Buzz", 5));
    }

    @Override
    protected void recordPredicates(List<FizzBuzzPredicate> predicates) {
        words.stream().forEachOrdered(word -> {
            predicates.add(wordIf(word.getWord(), IS_MULTIPLE_OF.appliedTo(word.getNumber())));
        });
    }
}