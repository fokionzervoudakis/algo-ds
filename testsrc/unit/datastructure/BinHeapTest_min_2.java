package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinHeapTest_min_2 {
    private BinHeap<Integer> heap;

    @BeforeEach
    void beforeEach() {
        heap = new BinHeap<>(Integer::compareTo);
    }

    @Test
    void itSiftsElementsUpWhenAddingElementsOntoTheHeap() {
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        assertEquals("[1, 2, 4, 5, 3]", heap.toString());
    }

    @Test
    void itDoesNotSiftElementsUpIfTheyMaintainTheHeapProperty() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        assertEquals("[1, 2, 3, 4, 5]", heap.toString());
    }

    @Test
    void itSiftsElementsDownWhenRemovingElementsFromTheHeap() {
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        heap.remove();
        assertEquals("[2, 3, 4, 5, 3]", heap.toString());
    }
}
