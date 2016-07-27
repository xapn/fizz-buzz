package software.works.fizzbuzz;

import static java.util.stream.Collectors.joining;

import java.util.Comparator;
import java.util.Iterator;
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
        List<String> madeWords = playerBuilder.chosenPlayer().playAtFizzBuzzToList(values);

        List<String> knownWords = playerBuilder.getKnownWords();
        String knownWordsRegex = knownWords.stream().collect(joining("|", "(", ")"));
        Pattern knownWordsPattern = Pattern.compile(knownWordsRegex);

        Iterator<Integer> valueIterator = IntStream.of(values).iterator();

        Optional<FizzbuzzifiedNumber> theMostFizzbuzzified = madeWords.stream() //
                .map(word -> new FizzbuzzifiedNumber(valueIterator.next(), word, knownWordsPattern)) //
                .max(Comparator.naturalOrder());

        if (!theMostFizzbuzzified.isPresent() || theMostFizzbuzzified.get().getFizzbuzzified().matches("\\d")) {
            return Optional.empty();
        } else {
            return Optional.of(theMostFizzbuzzified.get().getNumber());
        }
    }

    public TheMostFizzbuzzifiedNumber from(int start) {
        this.start = start;
        return this;
    }

    public Optional<Integer> to(int end) {
        return in(IntStream.rangeClosed(start, end).toArray());
    }
}