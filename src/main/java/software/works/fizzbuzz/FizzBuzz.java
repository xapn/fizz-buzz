package software.works.fizzbuzz;

public class FizzBuzz {

    public String of(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        } else {
            return String.valueOf(number);
        }
    }
}