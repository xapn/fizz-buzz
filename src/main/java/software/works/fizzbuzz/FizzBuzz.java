package software.works.fizzbuzz;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public String of(int number) {
        if (number % 3 == 0 || number % 5 == 0) {
            return fizzIfMultipleOf3(number) + buzzIfMultipleOf5(number);
        } else {
            return String.valueOf(number);
        }
    }

    private String fizzIfMultipleOf3(int number) {
        return number % 3 == 0 ? FIZZ : "";
    }

    private String buzzIfMultipleOf5(int number) {
        return number % 5 == 0 ? BUZZ : "";
    }
}