package sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingSortTest {
    private CountingSort sort;

    @BeforeEach
    void beforeEach() {
        sort = new CountingSort();
    }

    @Test
    void itSortsZeroElements() {
        var A = new int[0];
        assertEquals("[]", Arrays.toString(sort.sort(A, 10)));
    }

    @Test
    void itSortsOneElement() {
        var A = new int[] { 1 };
        assertEquals("[1]", Arrays.toString(sort.sort(A, 10)));
    }

    @Test
    void itSortsAnEvenNumberOfElements() {
        var A = new int[] { 5, 2, 1, 3, 6, 4 };
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(sort.sort(A, 10)));
    }

    @Test
    void itSortsAnOddNumberOfElements() {
        var A = new int[] { 5, 2, 1, 3, 4 };
        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(sort.sort(A, 10)));
    }

    @Test
    void itSortsDuplicateElements() {
        var A = new int[] { 5, 5, 2, 1, 1, 3, 4, 3, 3 };
        assertEquals("[1, 1, 2, 3, 3, 3, 4, 5, 5]", Arrays.toString(sort.sort(A, 10)));
    }
}
