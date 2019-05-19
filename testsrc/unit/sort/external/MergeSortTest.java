package sort.external;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortTest {
    @Test
    void itSortsZeroElements() {
        var A = new String[0];
        assertEquals("[]", Arrays.toString(MergeSort.sort(A)));
    }

    @Test
    void itSortsOneElement() {
        var A = new String[] { "a" };
        assertEquals("[a]", Arrays.toString(MergeSort.sort(A)));
    }

    @Test
    void itSortsAnEvenNumberOfElements() {
        var A = new String[] { "e", "b", "a", "c", "f", "d" };
        assertEquals("[a, b, c, d, e, f]", Arrays.toString(MergeSort.sort(A)));
    }

    @Test
    void itSortsAnOddNumberOfElements() {
        var A = new String[] { "e", "b", "a", "c", "d" };
        assertEquals("[a, b, c, d, e]", Arrays.toString(MergeSort.sort(A)));
    }

    @Test
    void itSortsDuplicateElements() {
        var A = new String[] { "e", "e", "b", "a", "a", "c", "d", "c", "c" };
        assertEquals("[a, a, b, c, c, c, d, e, e]", Arrays.toString(MergeSort.sort(A)));
    }
}
