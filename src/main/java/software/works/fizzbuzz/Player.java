package software.works.fizzbuzz;

class Player {

    protected static final String FIZZ = "Fizz";
    protected static final String BUZZ = "Buzz";

    String playAtFizzBuzz(int value) {
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
}