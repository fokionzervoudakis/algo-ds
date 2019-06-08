package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LisTest {
    private Lis lis;

    @BeforeEach
    void beforeEach() {
        lis = new Lis();
    }

    @Test
    void itReturnsTheListOfZeroElements() {
        assertEquals(0, lis.len(new int[0]));
    }

    @Test
    void itReturnsTheListOfOneElement() {
        assertEquals(1, lis.len(new int[] { 1 }));
    }

    @Test
    void itReturnsTheListOfManyAscendingElements() {
        assertEquals(3, lis.len(new int[] { 1, 2, 3 }));
    }

    @Test
    void itReturnsTheListOfManyDescendingElements() {
        assertEquals(1, lis.len(new int[] { 3, 2, 1 }));
    }

    @Test
    void itReturnsTheListOfManyUnorderedElements() {
        // The first 16 terms of the binary van der Corput sequence:
        var A = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        assertEquals(6, lis.len(A));
    }
}
