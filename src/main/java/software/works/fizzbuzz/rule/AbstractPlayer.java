package software.works.fizzbuzz.rule;

import static java.util.stream.Collectors.joining;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import software.works.fizzbuzz.Player;

abstract class AbstractPlayer implements Player {

    private static final String DELIMITER = " ";

    private NumberPredicate numberPredicate;
    protected List<FizzBuzzPredicate> predicates;

    @Override
    public String playAtFizzBuzz(int value) {
        String fizzBuzz = predicates.stream() //
                .map(predicate -> predicate.fizzBuzzOf(value)) //
                .collect(joining());

        return fizzBuzz.isEmpty() ? String.valueOf(value) : fizzBuzz;
    }

    public String playAtFizzBuzz(int... values) {
        return IntStream.of(values) //
                .mapToObj(this::playAtFizzBuzz) //
                .collect(joining(DELIMITER));
    }

    NumberPredicate getNumberPredicate() {
        return numberPredicate;
    }

    protected void setNumberPredicate(NumberPredicate numberPredicate) {
        this.numberPredicate = numberPredicate;
    }

    protected List<FizzBuzzPredicate> getPredicates() {
        return Collections.unmodifiableList(predicates);
    }

    void setPredicates(List<FizzBuzzPredicate> predicates) {
        this.predicates = predicates;
    }
}