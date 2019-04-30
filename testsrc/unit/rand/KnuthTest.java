package rand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnuthTest {
    private Knuth K;

    @BeforeEach
    void beforeEach() {
        K = new Knuth();
    }

    @Test
    void itDoesNotShuffleZeroElements() {
        var A = new int[0];
        K.shuffle(A);
        assertEquals("[]", Arrays.toString(A));
    }

    @Test
    void itDoesNotShuffleOneElement() {
        var A = new int[] { 0 };
        K.shuffle(A);
        assertEquals("[0]", Arrays.toString(A));
    }
}
