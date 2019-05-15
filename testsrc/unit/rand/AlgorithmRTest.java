package rand;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmRTest {
    @Test
    void itDoesNotPickAnythingWithZeroElements() {
        var A = new int[0];
        AlgorithmR.pick(A);
        assertEquals("[]", Arrays.toString(A));
    }

    @Test
    void itPicksOneElement() {
        var A = new int[] { 0 };
        AlgorithmR.pick(A);
        assertEquals("[0]", Arrays.toString(A));
    }
}
