package software.works.fizzbuzz.rule;

import software.works.fizzbuzz.Player;

public class DigitPlayer implements Player {

    @Override
    public String playAtFizzBuzz(int value) {
        Digits digits = new Digits(value);

        if (digits.contains3() || digits.contains5()) {
            return fizzIfContaining3(digits) + buzzIfContaining5(digits);
        } else {
            return digits.toString();
        }
    }

    private String fizzIfContaining3(Digits digits) {
        return digits.contains3() ? FIZZ : "";
    }

    private String buzzIfContaining5(Digits digits) {
        return digits.contains5() ? BUZZ : "";
    }
}