package sort.external;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortTest {
    private MergeSort<Integer> sort;

    @BeforeEach
    void beforeEach() {
        sort = new MergeSort<>();
    }

    @Test
    void itSortsZeroElements() {
        var A = new Integer[0];
        assertEquals("[]", Arrays.toString(sort.sort(A)));
    }

    @Test
    void itSortsOneElement() {
        var A = new Integer[] { 1 };
        assertEquals("[1]", Arrays.toString(sort.sort(A)));
    }

    @Test
    void itSortsAnEvenNumberOfElements() {
        var A = new Integer[] { 5, 2, 1, 3, 6, 4 };
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(sort.sort(A)));
    }

    @Test
    void itSortsAnOddNumberOfElements() {
        var A = new Integer[] { 5, 2, 1, 3, 4 };
        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(sort.sort(A)));
    }

    @Test
    void itSortsDuplicateElements() {
        var A = new Integer[] { 5, 5, 2, 1, 1, 3, 4, 3, 3 };
        assertEquals("[1, 1, 2, 3, 3, 3, 4, 5, 5]", Arrays.toString(sort.sort(A)));
    }

    @Test
    void itSortsNegativeElements() {
        var A = new Integer[] { -5, -2, -1, -3, -4 };
        assertEquals("[-5, -4, -3, -2, -1]", Arrays.toString(sort.sort(A)));
    }

    @Test
    void itSortsMixedElements() {
        var A = new Integer[] { 5, -2, 1, -3, 4 };
        assertEquals("[-3, -2, 1, 4, 5]", Arrays.toString(sort.sort(A)));
    }
}
