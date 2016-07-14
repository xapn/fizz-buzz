package software.works.fizzbuzz.rule;

class Digits extends Number {

    private boolean contains3;
    private boolean contains5;

    public Digits(int value) {
        super(value);
    }

    @Override
    void checkProperties() {
        String digits = String.valueOf(value);
        contains3 = digits.contains("3");
        contains5 = digits.contains("5");
    }

    public boolean contains3() {
        return contains3;
    }

    public boolean contains5() {
        return contains5;
    }
}