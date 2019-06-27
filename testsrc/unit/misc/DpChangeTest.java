package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DpChangeTest {
    private DpChange change;

    @BeforeEach
    void beforeEach() {
        change = new DpChange();
    }

    @Test
    void itMakesChangeWithZeroCoins() {
        assertEquals(0, change.min(new int[0], 0));
        assertEquals(-1, change.min(new int[0], 1));
        assertEquals(-1, change.min(new int[0], 2));
    }

    @Test
    void itMakesChangeWithOneCoin() {
        var A = new int[] { 1 };
        assertEquals(0, change.min(A, 0));
        assertEquals(1, change.min(A, 1));
        assertEquals(2, change.min(A, 2));
    }

    @Test
    void itMakesChangeWithManyCoins() {
        var A = new int[] { 3, 1, 2 };
        assertEquals(0, change.min(A, 0));
        assertEquals(1, change.min(A, 1));
        assertEquals(1, change.min(A, 2));
        assertEquals(1, change.min(A, 3));
        assertEquals(2, change.min(A, 4));
        assertEquals(2, change.min(A, 5));
        assertEquals(2, change.min(A, 6));
        assertEquals(3, change.min(A, 7));
        assertEquals(3, change.min(A, 8));
        assertEquals(3, change.min(A, 9));
        assertEquals(4, change.min(A, 10));
        assertEquals(4, change.min(A, 11));
        assertEquals(4, change.min(A, 12));
        assertEquals(5, change.min(A, 13));
        assertEquals(5, change.min(A, 14));
    }
}
