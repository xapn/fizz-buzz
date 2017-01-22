package software.works.fizzbuzz.engine.play;

import software.works.fizzbuzz.engine.FunctionTypes.PropertyPredicate;
import software.works.fizzbuzz.engine.NumberPredicate;

public class NumberCustomPredicatePlayer extends NumberPredicatePlayer {

    public NumberCustomPredicatePlayer(PropertyPredicate propertyPredicate) {
        setNumberPredicate(new NumberPredicate(propertyPredicate, (value, pair) -> {
            throw new UnsupportedOperationException(
                    "The words cannot be printed N times while specifying a custom number predicate!");
        }));
    }
}