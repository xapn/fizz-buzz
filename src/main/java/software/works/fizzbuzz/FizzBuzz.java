package software.works.fizzbuzz;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    private int start;

    public String of(int value) {
        Number number = new Number(value);

        if (number.isMultipleOf3() || number.isMultipleOf5()) {
            return fizzIfMultipleOf3(number) + buzzIfMultipleOf5(number);
        } else {
            return String.valueOf(number);
        }
    }

    private String fizzIfMultipleOf3(Number number) {
        return number.isMultipleOf3() ? FIZZ : "";
    }

    private String buzzIfMultipleOf5(Number number) {
        return number.isMultipleOf5() ? BUZZ : "";
    }

    public FizzBuzz from(int start) {
        this.start = start;
        return this;
    }

    public String to(int end) {
        StringBuilder result = new StringBuilder();

        for (int value = start; value <= end; value++) {
            result.append(of(value)).append(" ");
        }

        return result.substring(0, result.length() - 1).toString();
    }
}