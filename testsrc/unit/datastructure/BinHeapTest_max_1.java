package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinHeapTest_max_1 {
    private BinHeap<Integer> heap;

    @BeforeEach
    void beforeEach() {
        heap = new BinHeap<Integer>(Comparator.reverseOrder());
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
    }

    @Nested
    class WhenItAddsElementsOntoTheHeap {
        @Test
        void itIncreasesTheSizeOfTheBackingArrayIfItsCapacityIsExceeded() {
            heap.add(5);
            heap.add(6);

            var expected = "[6, 4, 5, 1, 3, 2, null, null, null, null]";
            var actual = heap.toString();

            assertEquals(expected, actual);
        }

        @Test
        void itDoesNotResizeTheBackingArrayIfItsCapacityIsNotExceeded() {
            heap.add(5);
            assertEquals("[5, 4, 2, 1, 3]", heap.toString());
        }
    }

    @Nested
    class WhenItRemovesElementsFromTheHeap {
        @Test
        void itReturnsTheLargestValue() {
            assertEquals(4, heap.remove().intValue());
            assertEquals(3, heap.remove().intValue());
        }

        @Test
        void itReplacesRemovedElements() {
            heap.remove();
            heap.remove();
            heap.add(5);
            heap.add(6);
            assertEquals("[6, 5, 2, 1, null]", heap.toString());
        }

        @Test
        void itReducesTheSizeOfTheBackingArrayIfItsCapacityIsExcessive() {
            heap.remove();
            heap.remove();
            heap.remove();
            assertEquals("[1, null]", heap.toString());
        }

        @Test
        void itDoesNotResizeTheBackingArrayIfItsCapacityIsNotExcessive() {
            heap.remove();
            heap.remove();
            assertEquals("[2, 1, 2, 1, null]", heap.toString());
        }

        @Test
        void itMaintainsTheHeapPropertyAfterEachResize() {
            heap.remove();
            heap.remove();
            heap.remove();
            heap.add(5);
            heap.add(6);
            assertEquals("[6, 1, 5, null]", heap.toString());
        }
    }
}
