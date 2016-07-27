package software.works.fizzbuzz;

import static java.util.stream.Collectors.joining;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import software.works.fizzbuzz.rule.PlayerBuilder;

class TheMostFizzbuzzifiedNumber {

    private PlayerBuilder playerBuilder;
    private int start;

    TheMostFizzbuzzifiedNumber(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    public Optional<Integer> in(int... values) {
        List<FizzbuzzifiedNumber> fizzbuzzified = playerBuilder.chosenPlayer().fizzbuzzify(values);
        Pattern knownWords = knownWords();

        Optional<FizzbuzzifiedNumber> theMostFizzbuzzified = fizzbuzzified.stream() //
                .map(number -> {
                    number.setKnownWords(knownWords);
                    return number;
                }).max(Comparator.naturalOrder());

        return isFizzbuzzified(theMostFizzbuzzified) ? Optional.of(theMostFizzbuzzified.get().getNumber())
                : Optional.empty();
    }

    private Pattern knownWords() {
        List<String> knownWords = playerBuilder.getKnownWords();
        String knownWordsRegex = knownWords.stream().collect(joining("|", "(", ")"));
        return Pattern.compile(knownWordsRegex);
    }

    private boolean isFizzbuzzified(Optional<FizzbuzzifiedNumber> theMostFizzbuzzified) {
        return theMostFizzbuzzified.isPresent() && theMostFizzbuzzified.get().isFizzbuzzified();
    }

    public TheMostFizzbuzzifiedNumber from(int start) {
        this.start = start;
        return this;
    }

    public Optional<Integer> to(int end) {
        return in(IntStream.rangeClosed(start, end).toArray());
    }
}