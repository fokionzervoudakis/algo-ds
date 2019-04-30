package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinHeapTest_min_1 {
    private BinHeap<Integer> heap;

    @BeforeEach
    void beforeEach() {
        heap = new BinHeap<>(Integer::compareTo);
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

            var expected = "[1, 2, 3, 4, 5, 6, null, null, null, null]";
            var actual = heap.toString();

            assertEquals(expected, actual);
        }

        @Test
        void itDoesNotResizeTheBackingArrayIfItsCapacityIsNotExceeded() {
            heap.add(5);
            assertEquals("[1, 2, 3, 4, 5]", heap.toString());
        }
    }

    @Nested
    class WhenItRemovesElementsFromTheHeap {
        @Test
        void itReturnsTheSmallestValue() {
            assertEquals(1, heap.remove().intValue());
            assertEquals(2, heap.remove().intValue());
        }

        @Test
        void itReplacesRemovedElements() {
            heap.remove();
            heap.remove();
            heap.add(5);
            heap.add(6);
            assertEquals("[3, 4, 5, 6, null]", heap.toString());
        }

        @Test
        void itReducesTheSizeOfTheBackingArrayIfItsCapacityIsExcessive() {
            heap.remove();
            heap.remove();
            heap.remove();
            assertEquals("[4, null]", heap.toString());
        }

        @Test
        void itDoesNotResizeTheBackingArrayIfItsCapacityIsNotExcessive() {
            heap.remove();
            heap.remove();
            assertEquals("[3, 4, 3, 4, null]", heap.toString());
        }

        @Test
        void itMaintainsTheHeapPropertyAfterEachResize() {
            heap.remove();
            heap.remove();
            heap.remove();
            heap.add(5);
            heap.add(6);
            assertEquals("[4, 5, 6, null]", heap.toString());
        }
    }
}
