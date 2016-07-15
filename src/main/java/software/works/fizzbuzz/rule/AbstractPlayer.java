package software.works.fizzbuzz.rule;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import software.works.fizzbuzz.Player;

abstract class AbstractPlayer implements Player {

    private List<FizzBuzzPredicate> predicates;

    AbstractPlayer() {
        managePredicates();
    }

    private void managePredicates() {
        predicates = new ArrayList<>();
        recordPredicates(predicates);
        validatePredicates(predicates);
    }

    protected abstract void recordPredicates(List<FizzBuzzPredicate> predicates);

    final protected FizzBuzzPredicate wordIf(String word, Predicate<Integer> predicate) {
        return value -> predicate.test(value) ? word : "";
    }

    private void validatePredicates(List<FizzBuzzPredicate> predicates) {
        if (predicates == null || predicates.isEmpty()) {
            throw new IllegalStateException("No predicate found!");
        }
    }

    @Override
    public String playAtFizzBuzz(int value) {
        String fizzBuzz = predicates.stream() //
                .map(predicate -> predicate.fizzBuzzOf(value)) //
                .collect(joining());

        return fizzBuzz.isEmpty() ? String.valueOf(value) : fizzBuzz;
    };

    List<FizzBuzzPredicate> getPredicates() {
        return Collections.unmodifiableList(predicates);
    }
}