package software.works.fizzbuzz.rule;

import software.works.fizzbuzz.Player;

public class DivisionPlayer implements Player {

    @Override
    public String playAtFizzBuzz(int value) {
        Multiple multiple = new Multiple(value);

        if (multiple.isMultipleOf3() || multiple.isMultipleOf5()) {
            return fizzIfMultipleOf3(multiple) + buzzIfMultipleOf5(multiple);
        } else {
            return String.valueOf(multiple);
        }
    }

    private String fizzIfMultipleOf3(Multiple multiple) {
        return multiple.isMultipleOf3() ? FIZZ : "";
    }

    private String buzzIfMultipleOf5(Multiple multiple) {
        return multiple.isMultipleOf5() ? BUZZ : "";
    }
}