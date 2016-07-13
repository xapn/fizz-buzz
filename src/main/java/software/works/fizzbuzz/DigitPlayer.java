package software.works.fizzbuzz;

class DigitPlayer extends Player {

    @Override
    String playAtFizzBuzz(int value) {
        String numericChain = String.valueOf(value);

        if (numericChain.contains("3") || numericChain.contains("5")) {
            return fizzIfContaining3(numericChain) + buzzIfContaining5(numericChain);
        } else {
            return numericChain;
        }
    }

    private String fizzIfContaining3(String numericChain) {
        return numericChain.contains("3") ? FIZZ : "";
    }

    private String buzzIfContaining5(String numericChain) {
        return numericChain.contains("5") ? BUZZ : "";
    }
}