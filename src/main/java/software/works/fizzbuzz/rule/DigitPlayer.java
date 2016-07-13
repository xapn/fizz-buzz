package software.works.fizzbuzz.rule;

import software.works.fizzbuzz.Player;

public class DigitPlayer implements Player {

    private static final String THREE = "3";
    private static final String FIVE = "5";

    @Override
    public String playAtFizzBuzz(int value) {
        String numericChain = String.valueOf(value);

        if (numericChain.contains(THREE) || numericChain.contains(FIVE)) {
            return fizzIfContaining3(numericChain) + buzzIfContaining5(numericChain);
        } else {
            return numericChain;
        }
    }

    private String fizzIfContaining3(String numericChain) {
        return numericChain.contains(THREE) ? FIZZ : "";
    }

    private String buzzIfContaining5(String numericChain) {
        return numericChain.contains(FIVE) ? BUZZ : "";
    }
}