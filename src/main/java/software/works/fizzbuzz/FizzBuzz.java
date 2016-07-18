package software.works.fizzbuzz;

import static software.works.fizzbuzz.rule.DictionaryWord.BOOM;
import static software.works.fizzbuzz.rule.DictionaryWord.BUZZ;
import static software.works.fizzbuzz.rule.DictionaryWord.FIZZ;

import software.works.fizzbuzz.rule.DigitPlayer;
import software.works.fizzbuzz.rule.DivisionPlayer;
import software.works.fizzbuzz.rule.PlayerBuilder;

public class FizzBuzz {

    private static final String COMMA_SEPARATOR = ", ";
    private static final String SEMI_COLON_SEPARATOR = "; ";

    private PlayerBuilder playerBuilder;

    public FizzBuzz() {
        playerBuilder = new PlayerBuilder();
    }

    public String of(int value) {
        return playerBuilder.chosenPlayer().playAtFizzBuzz(value);
    }

    public String of(int... values) {
        return playerBuilder.chosenPlayer().playAtFizzBuzz(values);
    }

    public FizzBuzzRange from(int start) {
        return new FizzBuzzRange(playerBuilder.chosenPlayer()).from(start);
    }

    public FizzBuzz whenNumberHasFactors() {
        playerBuilder.append(new DivisionPlayer());
        return this;
    }

    public FizzBuzz whenNumberContainsDigits() {
        playerBuilder.append(new DigitPlayer());
        return this;
    }

    public FizzBuzz boom() {
        playerBuilder //
                .append(FIZZ).append(BUZZ).append(BOOM) //
                .append(new DivisionPlayer()) //
                .append(new DigitPlayer());
        return this;
    }

    public FizzBuzz separatedBy(String wordSeparator) {
        playerBuilder.append(wordSeparator);
        return this;
    }

    public FizzBuzz separatedByComma() {
        playerBuilder.append(COMMA_SEPARATOR);
        return this;
    }

    public FizzBuzz separatedBySemiColon() {
        playerBuilder.append(SEMI_COLON_SEPARATOR);
        return this;
    }
}