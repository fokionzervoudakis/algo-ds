package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DpLisTest {
    private DpLis lis;

    @BeforeEach
    void beforeEach() {
        lis = new DpLis();
    }

    @Test
    void itReturnsTheLisOfZeroElements() {
        assertEquals(0, lis.len(new int[0]));
    }

    @Test
    void itReturnsTheLisOfOneElement() {
        assertEquals(1, lis.len(new int[] { 1 }));
    }

    @Test
    void itReturnsTheLisOfManyAscendingElements() {
        assertEquals(3, lis.len(new int[] { 1, 2, 3 }));
    }

    @Test
    void itReturnsTheLisOfManyDescendingElements() {
        assertEquals(1, lis.len(new int[] { 3, 2, 1 }));
    }

    @Test
    void itReturnsTheLisOfManyUnorderedElements() {
        // The first 16 terms of the binary van der Corput sequence:
        var A = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        assertEquals(6, lis.len(A));
    }
}
