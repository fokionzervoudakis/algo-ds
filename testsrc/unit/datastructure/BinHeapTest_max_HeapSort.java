package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinHeapTest_max_HeapSort {
    private Comparator<Integer> c;

    @BeforeEach
    void beforeEach() {
        c = Comparator.reverseOrder();
    }

    @Test
    void itSortsZeroElements() {
        var heap = new BinHeap<>(new Integer[0], c);
        heap.sort();
        assertEquals("[]", heap.toString());
        assertEquals(0, heap.len);
    }

    @Test
    void itSortsOneElement() {
        var heap = new BinHeap<>(new Integer[] { 1 }, c);
        heap.sort();
        assertEquals("[1]", heap.toString());
        assertEquals(1, heap.len);
    }

    @Test
    void itSortsAnEvenNumberOfElementsInDescendingOrder() {
        var heap = new BinHeap<>(new Integer[] { 5, 2, 1, 3, 6, 4 }, c);
        heap.sort();
        assertEquals("[6, 5, 4, 3, 2, 1]", heap.toString());
        assertEquals(6, heap.len);
    }

    @Test
    void itSortsAnOddNumberOfElementsInDescendingOrder() {
        var heap = new BinHeap<>(new Integer[] { 5, 2, 1, 3, 4 }, c);
        heap.sort();
        assertEquals("[5, 4, 3, 2, 1]", heap.toString());
        assertEquals(5, heap.len);
    }
}
