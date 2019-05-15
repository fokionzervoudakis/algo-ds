package rand;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnuthTest {
    @Test
    void itDoesNotShuffleZeroElements() {
        var A = new int[0];
        Knuth.shuffle(A);
        assertEquals("[]", Arrays.toString(A));
    }

    @Test
    void itDoesNotShuffleOneElement() {
        var A = new int[] { 0 };
        Knuth.shuffle(A);
        assertEquals("[0]", Arrays.toString(A));
    }
}
