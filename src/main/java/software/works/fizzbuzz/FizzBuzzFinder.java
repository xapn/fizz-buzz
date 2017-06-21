package software.works.fizzbuzz;

import static java.util.stream.Collectors.joining;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import software.works.fizzbuzz.engine.build.PlayerBuilder;

class FizzBuzzFinder {

    private PlayerBuilder playerBuilder;

    FizzBuzzFinder(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    Optional<FizzbuzzifiedNumber> find(List<BigInteger> values) {
        List<FizzbuzzifiedNumber> fizzbuzzified = playerBuilder.chosenPlayer().fizzbuzzify(values);
        Pattern knownWords = knownWords();

        Optional<FizzbuzzifiedNumber> theMostFizzbuzzified = fizzbuzzified.stream() //
                .map(number -> {
                    number.setKnownWords(knownWords);
                    return number;
                }).max(Comparator.naturalOrder());

        return isFizzbuzzified(theMostFizzbuzzified) ? theMostFizzbuzzified : Optional.empty();
    }

    private Pattern knownWords() {
        List<String> knownWords = playerBuilder.getKnownWords();
        String knownWordsRegex = knownWords.stream().collect(joining("|", "(", ")"));
        return Pattern.compile(knownWordsRegex);
    }

    private boolean isFizzbuzzified(Optional<FizzbuzzifiedNumber> theMostFizzbuzzified) {
        return theMostFizzbuzzified.isPresent() && theMostFizzbuzzified.get().isFizzbuzzified();
    }
}