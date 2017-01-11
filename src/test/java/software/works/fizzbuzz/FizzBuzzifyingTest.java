package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;
import static software.works.fizzbuzz.I.fizzbuzzify;

import org.junit.Test;

public class FizzBuzzifyingTest {

    @Test
    public void should_fizzbuzzify_some_arbitrary_values() {
        assertThat(fizzbuzzify(3, 5, 15)).isEqualTo(new FizzBuzz().of(3, 5, 15));
    }
}