package software.works.fizzbuzz.engine;

import software.works.fizzbuzz.engine.FunctionTypes.PropertyPredicate;

public class NumberCustomPredicatePlayer extends NumberPredicatePlayer {

    public NumberCustomPredicatePlayer(PropertyPredicate propertyPredicate) {
        setNumberPredicate(new NumberPredicate(propertyPredicate, (value, pair) -> {
            throw new UnsupportedOperationException(
                    "The words cannot be printed N times while specifying a custom number predicate!");
        }));
    }
}