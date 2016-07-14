package software.works.fizzbuzz.rule;

abstract class Number {

    protected int value;

    Number(int value) {
        this.value = value;
        checkProperties();
    }

    abstract void checkProperties();

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}