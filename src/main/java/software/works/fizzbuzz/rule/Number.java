package software.works.fizzbuzz.rule;

class Number {

    protected int value;
    private boolean isMultipleOf3;
    private boolean isMultipleOf5;

    Number(int value) {
        this.value = value;
        checkIfThisNumberIsMultiple();
    }

    void checkIfThisNumberIsMultiple() {
        isMultipleOf3 = value % 3 == 0;
        isMultipleOf5 = value % 5 == 0;
    }

    public boolean isMultipleOf3() {
        return isMultipleOf3;
    }

    public boolean isMultipleOf5() {
        return isMultipleOf5;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}