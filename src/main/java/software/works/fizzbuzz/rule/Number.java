package software.works.fizzbuzz.rule;

class Number {

    protected int value;

    Number(int value) {
        this.value = value;
    }

    String toFizzBuzzIfItSatisfies(FizzBuzzPredicate predicate) {
        return predicate.fizzBuzz(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}