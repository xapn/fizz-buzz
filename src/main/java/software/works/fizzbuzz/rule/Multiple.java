package software.works.fizzbuzz.rule;

class Multiple extends Number {

    private boolean isMultipleOf3;
    private boolean isMultipleOf5;

    Multiple(int value) {
        super(value);
    }

    @Override
    void checkProperties() {
        isMultipleOf3 = value % 3 == 0;
        isMultipleOf5 = value % 5 == 0;
    }

    public boolean isMultipleOf3() {
        return isMultipleOf3;
    }

    public boolean isMultipleOf5() {
        return isMultipleOf5;
    }
}