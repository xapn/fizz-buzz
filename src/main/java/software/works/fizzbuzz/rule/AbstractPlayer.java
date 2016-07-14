package software.works.fizzbuzz.rule;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import software.works.fizzbuzz.Player;

abstract class AbstractPlayer implements Player {

    protected List<FizzBuzzPredicate> predicates;

    protected FizzBuzzPredicate wordIf(String word, Predicate<Integer> predicate) {
        return value -> predicate.test(value) ? word : "";
    }

    List<FizzBuzzPredicate> getPredicates() {
        return Collections.unmodifiableList(predicates);
    }
}