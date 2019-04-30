package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinHeapTest_min_3 {
    private Comparator<Integer> c;

    @BeforeEach
    void beforeEach() {
        c = Integer::compareTo;
    }

    @Test
    void itAddsZeroElements() {
        assertEquals("[]", new BinHeap<>(new Integer[0], c).toString());
    }

    @Test
    void itAddsOneElement() {
        assertEquals("[1]", new BinHeap<>(new Integer[] { 1 }, c).toString());
    }

    @Nested
    class WhenItAddsAnEvenNumberOfElements {
        @Test
        void itSiftsElementsDownIfTheyDoNotMaintainTheHeapProperty() {
            var A = new Integer[] { 6, 5, 4, 3, 2, 1 };
            var expected = "[1, 2, 4, 3, 5, 6]";
            var actual = new BinHeap<>(A, c).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itDoesNotSiftElementsDownIfTheyMaintainTheHeapProperty() {
            var A = new Integer[] { 1, 2, 3, 4, 5, 6 };
            var expected = "[1, 2, 3, 4, 5, 6]";
            var actual = new BinHeap<>(A, c).toString();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class WhenItAddsAnOddNumberOfElements {
        @Test
        void itSiftsElementsDownIfTheyDoNotMaintainTheHeapProperty() {
            var A = new Integer[] { 5, 4, 3, 2, 1 };
            var expected = "[1, 2, 3, 5, 4]";
            var actual = new BinHeap<>(A, c).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itDoesNotSiftElementsDownIfTheyMaintainTheHeapProperty() {
            var A = new Integer[] { 1, 2, 3, 4, 5 };
            var expected = "[1, 2, 3, 4, 5]";
            var actual = new BinHeap<>(A, c).toString();
            assertEquals(expected, actual);
        }
    }
}
