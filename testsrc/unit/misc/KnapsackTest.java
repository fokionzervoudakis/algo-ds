package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackTest {
    private Knapsack K;

    @BeforeEach
    void beforeEach() {
        K = new Knapsack();
    }

    @Test
    void itMaximizesZeroItems() {
        assertEquals(0, K.max(new int[0], new int[0], 0));
    }

    @Test
    void itMaximizesOneItem() {
        var A = new int[] { 1 };
        assertEquals(0, K.max(A, A, 0));
        assertEquals(1, K.max(A, A, 1));
        assertEquals(1, K.max(A, A, 2));
    }

    @Test
    void itMaximizesManyItems() {
        var w = new int[] { 3, 1, 2 };
        var v = new int[] { 30, 10, 20 };
        assertEquals(0, K.max(w, v, 0));
        assertEquals(10, K.max(w, v, 1));
        assertEquals(20, K.max(w, v, 2));
        assertEquals(30, K.max(w, v, 3));
        assertEquals(40, K.max(w, v, 4));
        assertEquals(50, K.max(w, v, 5));
        assertEquals(60, K.max(w, v, 6));
        assertEquals(60, K.max(w, v, 7));
    }

    @Test
    void itMaximizesManyDuplicateItems() {
        var w = new int[] { 3, 1, 2, 1, 4, 2 };
        var v = new int[] { 30, 10, 20, 10, 40, 20 };
        assertEquals(0, K.max(w, v, 0));
        assertEquals(10, K.max(w, v, 1));
        assertEquals(20, K.max(w, v, 2));
        assertEquals(30, K.max(w, v, 3));
        assertEquals(40, K.max(w, v, 4));
        assertEquals(50, K.max(w, v, 5));
        assertEquals(60, K.max(w, v, 6));
        assertEquals(70, K.max(w, v, 7));
        assertEquals(80, K.max(w, v, 8));
        assertEquals(90, K.max(w, v, 9));
        assertEquals(100, K.max(w, v, 10));
        assertEquals(110, K.max(w, v, 11));
        assertEquals(120, K.max(w, v, 12));
        assertEquals(130, K.max(w, v, 13));
        assertEquals(130, K.max(w, v, 14));
    }
}
