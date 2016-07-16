package software.works.fizzbuzz.rule;

import static software.works.fizzbuzz.rule.NumberPredicates.CONTAINS_DIGIT;

import java.util.Arrays;
import java.util.List;

import software.works.fizzbuzz.Word;

public class DigitPlayer extends AbstractPlayer {

    private List<Word> words;

    public DigitPlayer() {
        defineDefaultWords();
        managePredicates();
    }

    public DigitPlayer(Word... words) {
        this.words = Arrays.asList(words);
        managePredicates();
    }

    private void defineDefaultWords() {
        words = Arrays.asList(new Word("Fizz", 3), new Word("Buzz", 5));
    }

    @Override
    protected void recordPredicates(List<FizzBuzzPredicate> predicates) {
        words.stream().forEachOrdered(word -> {
            predicates.add(wordIf(word.getWord(), CONTAINS_DIGIT.appliedTo(word.getNumber())));
        });
    }
}