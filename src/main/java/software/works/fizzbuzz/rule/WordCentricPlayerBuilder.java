package software.works.fizzbuzz.rule;

import static java.util.stream.Collectors.toList;

import java.util.List;

import software.works.fizzbuzz.FizzBuzzPlayer;

class WordCentricPlayerBuilder {

    private final List<WordPropertyPair> wordPropertyPairs;
    private final PlayerConfiguration configuration;

    WordCentricPlayerBuilder(List<WordPropertyPair> wordPropertyPairs, PlayerConfiguration configuration) {
        this.wordPropertyPairs = wordPropertyPairs;
        this.configuration = configuration;
    }

    FizzBuzzPlayer build(List<NumberPredicatePlayer> players) {
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
