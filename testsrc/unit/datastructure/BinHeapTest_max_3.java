package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinHeapTest_max_3 {
    private Comparator<Integer> c;

    @BeforeEach
    void beforeEach() {
        c = Comparator.reverseOrder();
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
            var A = new Integer[] { 1, 2, 3, 4, 5, 6 };
            var expected = "[6, 5, 3, 4, 2, 1]";
            var actual = new BinHeap<>(A, c).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itDoesNotSiftElementsDownIfTheyMaintainTheHeapProperty() {
            var A = new Integer[] { 6, 5, 4, 3, 2, 1 };
            var expected = "[6, 5, 4, 3, 2, 1]";
            var actual = new BinHeap<>(A, c).toString();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class WhenItAddsAnOddNumberOfElements {
        @Test
        void itSiftsElementsDownIfTheyDoNotMaintainTheHeapProperty() {
            var A = new Integer[] { 1, 2, 3, 4, 5 };
            var expected = "[5, 4, 3, 1, 2]";
            var actual = new BinHeap<>(A, c).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itDoesNotSiftElementsDownIfTheyMaintainTheHeapProperty() {
            var A = new Integer[] { 5, 4, 3, 2, 1 };
            var expected = "[5, 4, 3, 2, 1]";
            var actual = new BinHeap<>(A, c).toString();
            assertEquals(expected, actual);
        }
    }
}
