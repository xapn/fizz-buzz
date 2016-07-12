package software.works.fizzbuzz;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public String of(int number) {
        if (number % 3 == 0) {
            return FIZZ;
        } else if (number % 5 == 0) {
            return BUZZ;
        } else {
            return String.valueOf(number);
        }
    }
}