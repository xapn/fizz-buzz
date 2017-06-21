package software.works.fizzbuzz.engine.build;

import static java.util.stream.Collectors.toList;

import java.util.List;

import software.works.fizzbuzz.FizzBuzzPlayer;
import software.works.fizzbuzz.engine.FizzBuzzFunction;
import software.works.fizzbuzz.engine.NumberPredicate;
import software.works.fizzbuzz.engine.play.NumberPredicatePlayer;
import software.works.fizzbuzz.engine.play.OrdinaryPlayer;

class WordCentricPlayerBuilder extends AbstractCentricPlayerBuilder {

    @Override
    protected FizzBuzzPlayer buildPlayer(List<NumberPredicatePlayer> players) {
        List<NumberPredicate> allNumberPredicates = players.stream() //
                .map(player -> player.getNumberPredicate()) //
                .collect(toList());
        List<FizzBuzzFunction> wordCentricFunctions = buildWordCentricFunctions(allNumberPredicates);
        FizzBuzzPlayer wordCentricPlayer = new OrdinaryPlayer(wordCentricFunctions, configuration) {};

        return wordCentricPlayer;
    }

    private List<FizzBuzzFunction> buildWordCentricFunctions(List<NumberPredicate> numberPredicates) {
        return wordPropertyPairs.stream() //
                .map(pair -> new RightWord(pair).ifNumberSatisfies(numberPredicates)) //
                .collect(toList());
    }
}
