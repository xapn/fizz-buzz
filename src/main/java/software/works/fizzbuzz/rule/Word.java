package software.works.fizzbuzz.rule;

class Word {

    private String word;
    private int property;

    Word(String word, int property) {
        this.word = word;
        this.property = property;
        validate();
    }

    private void validate() {
        if (word == null || word.isEmpty() || property < 0) {
            throw new IllegalStateException("Invalid word: '" + word
                    + "' must be a word associated to a positive integer '" + property + "' as property!");
        }
    }

    FizzBuzzPredicate ifNumberSatisfies(NumberPredicate predicate) {
        return value -> predicate.appliedTo(property).test(value) ? word : "";
    }

    @Override
    public String toString() {
        return String.format("{word: %s, property: %d}", word, property);
    }
}