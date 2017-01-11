package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;
import static software.works.fizzbuzz.I.fizzbuzzify;
import static software.works.fizzbuzz.I.fizzbuzzpopwhackify;
import static software.works.fizzbuzz.I.fizzbuzzwoofify;
import static software.works.fizzbuzz.I.learnDivision;
import static software.works.fizzbuzz.I.sevenboomify;

import org.junit.Test;

public class FizzBuzzifyingTest {

    @Test
    public void should_fizzbuzzify_some_arbitrary_values() {
        assertThat(fizzbuzzify(3, 5, 15)).isEqualTo(new FizzBuzz().of(3, 5, 15));
    }

    @Test
    public void should_fizzbuzzify_a_range_of_values() {
        assertThat(fizzbuzzify(1).until(15)).isEqualTo(new FizzBuzz().from(1).to(15));
    }

    @Test
    public void should_let_learn_division_by_fizzbuzzifying_some_arbitrary_values() {
        assertThat(learnDivision().byFizzbuzzifying(3, 5, 15))
                .isEqualTo(new FizzBuzz().whenNumberHasFactors().of(3, 5, 15));
    }

    @Test
    public void should_let_learn_division_by_fizzbuzzifying_a_range_of_values() {
        assertThat(learnDivision().byFizzbuzzifying(1).until(15))
                .isEqualTo(new FizzBuzz().whenNumberHasFactors().from(1).to(15));
    }

    @Test
    public void should_sevenboomify_some_arbitrary_values() {
        assertThat(sevenboomify(3, 5, 15)).isEqualTo(new FizzBuzz().boom().of(3, 5, 15));
    }

    @Test
    public void should_sevenboomify_a_range_of_values() {
        assertThat(sevenboomify(1).until(15)).isEqualTo(new FizzBuzz().boom().from(1).to(15));
    }

    @Test
    public void should_fizzbuzzwoofify_some_arbitrary_values() {
        assertThat(fizzbuzzwoofify(3, 5, 7, 15, 21)).isEqualTo(new FizzBuzz().woof().of(3, 5, 7, 15, 21));
    }

    @Test
    public void should_fizzbuzzwoofify_a_range_of_values() {
        assertThat(fizzbuzzwoofify(1).until(21)).isEqualTo(new FizzBuzz().woof().from(1).to(21));
    }

    @Test
    public void should_fizzbuzzpopwhackify_some_arbitrary_values() {
        assertThat(fizzbuzzpopwhackify(3, 5, 7, 11)).isEqualTo(new FizzBuzz().popWhack().of(3, 5, 7, 11));
    }
}