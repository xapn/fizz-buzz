package software.works.fizzbuzz;

import software.works.fizzbuzz.rule.DigitPlayer;
import software.works.fizzbuzz.rule.DivisionPlayer;
import software.works.fizzbuzz.rule.PlayerBuilder;

public class FizzBuzz {

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
                .append(new Word("Fizz", 3)) //
                .append(new Word("Buzz", 5)) //
                .append(new Word("Boom", 7)) //
                .append(new DivisionPlayer()) //
                .append(new DigitPlayer());
        return this;
    }
}