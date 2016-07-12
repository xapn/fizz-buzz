package software.works.fizzbuzz;

public class FizzBuzzRange {

    private FizzBuzz fizzBuzz;
    private int start;

    FizzBuzzRange(FizzBuzz fizzBuzz, int start) {
        this.fizzBuzz = fizzBuzz;
        this.start = start;
    }

    public String to(int end) {
        StringBuilder result = new StringBuilder();

        for (int value = start; value <= end; value++) {
            result.append(fizzBuzz.playAtFizzBuzz(value)).append(" ");
        }

        return result.substring(0, result.length() - 1).toString();
    }
}
