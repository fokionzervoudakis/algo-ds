package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinHeapTest_max_2 {
    private BinHeap<Integer> heap;

    @BeforeEach
    void beforeEach() {
        heap = new BinHeap<Integer>(Comparator.reverseOrder());
    }

    @Test
    void itSiftsElementsUpWhenAddingElementsOntoTheHeap() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        assertEquals("[5, 4, 2, 1, 3]", heap.toString());
    }

    @Test
    void itDoesNotSiftElementsUpIfTheyMaintainTheHeapProperty() {
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        assertEquals("[5, 4, 3, 2, 1]", heap.toString());
    }

    @Test
    void itSiftsElementsDownWhenRemovingElementsFromTheHeap() {
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        heap.remove();
        assertEquals("[4, 2, 3, 1, 1]", heap.toString());
    }
}
