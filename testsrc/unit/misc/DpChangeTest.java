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
        assertEquals(0, change.make(new int[0], 0));
        assertEquals(-1, change.make(new int[0], 1));
        assertEquals(-1, change.make(new int[0], 2));
    }

    @Test
    void itMakesChangeWithOneCoin() {
        var A = new int[] { 1 };
        assertEquals(0, change.make(A, 0));
        assertEquals(1, change.make(A, 1));
        assertEquals(2, change.make(A, 2));
    }

    @Test
    void itMakesChangeWithManyCoins() {
        var A = new int[] { 3, 1, 2 };
        assertEquals(0, change.make(A, 0));
        assertEquals(1, change.make(A, 1));
        assertEquals(1, change.make(A, 2));
        assertEquals(1, change.make(A, 3));
        assertEquals(2, change.make(A, 4));
        assertEquals(2, change.make(A, 5));
        assertEquals(2, change.make(A, 6));
        assertEquals(3, change.make(A, 7));
        assertEquals(3, change.make(A, 8));
        assertEquals(3, change.make(A, 9));
        assertEquals(4, change.make(A, 10));
        assertEquals(4, change.make(A, 11));
        assertEquals(4, change.make(A, 12));
        assertEquals(5, change.make(A, 13));
        assertEquals(5, change.make(A, 14));
    }
}
