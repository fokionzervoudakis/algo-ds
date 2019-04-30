package sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectionSortTest {
    private SelectionSort sort;

    @BeforeEach
    void beforeEach() {
        sort = new SelectionSort();
    }

    @Test
    void itSortsZeroElements() {
        var A = new int[0];
        sort.sort(A);
        assertEquals("[]", Arrays.toString(A));
    }

    @Test
    void itSortsOneElement() {
        var A = new int[] { 1 };
        sort.sort(A);
        assertEquals("[1]", Arrays.toString(A));
    }

    @Test
    void itSortsAnEvenNumberOfElements() {
        var A = new int[] { 5, 2, 1, 3, 6, 4 };
        sort.sort(A);
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(A));
    }

    @Test
    void itSortsAnOddNumberOfElements() {
        var A = new int[] { 5, 2, 1, 3, 4 };
        sort.sort(A);
        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(A));
    }

    @Test
    void itSortsDuplicateElements() {
        var A = new int[] { 5, 5, 2, 1, 1, 3, 4, 3, 3 };
        sort.sort(A);
        assertEquals("[1, 1, 2, 3, 3, 3, 4, 5, 5]", Arrays.toString(A));
    }

    @Test
    void itSortsNegativeElements() {
        var A = new int[] { -5, -2, -1, -3, -4 };
        sort.sort(A);
        assertEquals("[-5, -4, -3, -2, -1]", Arrays.toString(A));
    }

    @Test
    void itSortsMixedElements() {
        var A = new int[] { 5, -2, 1, -3, 4 };
        sort.sort(A);
        assertEquals("[-3, -2, 1, 4, 5]", Arrays.toString(A));
    }
}
