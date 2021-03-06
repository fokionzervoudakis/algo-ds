package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinSearchTest {
    private BinSearch search;

    @BeforeEach
    void beforeEach() {
        search = new BinSearch();
    }

    @Nested
    class WhenItHasZeroElements {
        private int[] A;

        @BeforeEach
        void beforeEach() {
            A = new int[0];
        }

        @Test
        void itReturnsTheInsertionPointIteratively() {
            assertEquals(-1, Arrays.binarySearch(A, 1));
            assertEquals(-1, search.it(A, 1));
        }

        @Test
        void itReturnsTheInsertionPointRecursively() {
            assertEquals(-1, Arrays.binarySearch(A, 1));
            assertEquals(-1, search.rec(A, 1));
        }
    }

    @Nested
    class WhenItHasAnEvenNumberOfElements {
        private int[] A;

        @BeforeEach
        void beforeEach() {
            A = new int[] { 7, 8, 9, 11 };
        }

        @Test
        void itReturnsTheIndexOfAnElementIfItExists() {
            assertEquals(1, Arrays.binarySearch(A, 8));
            assertEquals(1, search.it(A, 8));
            assertEquals(1, search.rec(A, 8));
        }

        @Test
        void itReturnsTheIndexOfTheFirstElement() {
            assertEquals(0, Arrays.binarySearch(A, 7));
            assertEquals(0, search.it(A, 7));
            assertEquals(0, search.rec(A, 7));
        }

        @Test
        void itReturnsTheIndexOfTheLastElement() {
            assertEquals(3, Arrays.binarySearch(A, 11));
            assertEquals(3, search.it(A, 11));
            assertEquals(3, search.rec(A, 11));
        }

        @Test
        void itReturnsTheLeftmostInsertionPointIfTheElementDoesNotExist() {
            assertEquals(-1, Arrays.binarySearch(A, 6));
            assertEquals(-1, search.it(A, 6));
            assertEquals(-1, search.rec(A, 6));
        }

        @Test
        void itReturnsANegativeInsertionPointIfTheElementDoesNotExist() {
            assertEquals(-4, Arrays.binarySearch(A, 10));
            assertEquals(-4, search.it(A, 10));
            assertEquals(-4, search.rec(A, 10));
        }

        @Test
        void itReturnsARightmostNegativeInsertionPointIfTheElementDoesNotExist() {
            assertEquals(-5, Arrays.binarySearch(A, 12));
            assertEquals(-5, search.it(A, 12));
            assertEquals(-5, search.rec(A, 12));
        }
    }

    @Nested
    class WhenItHasAnOddNumberOfElements {
        private int[] A;

        @BeforeEach
        void beforeEach() {
            A = new int[] { 8, 9, 11 };
        }

        @Test
        void itReturnsTheIndexOfAnElementIfItExists() {
            assertEquals(1, search.it(A, 9));
            assertEquals(1, search.rec(A, 9));
        }

        @Test
        void itReturnsTheIndexOfTheFirstElement() {
            assertEquals(0, search.it(A, 8));
            assertEquals(0, search.rec(A, 8));
        }

        @Test
        void itReturnsTheIndexOfTheLastElement() {
            assertEquals(2, search.it(A, 11));
            assertEquals(2, search.rec(A, 11));
        }

        @Test
        void itReturnsTheLeftmostInsertionPointIfTheElementDoesNotExist() {
            assertEquals(-1, search.it(A, 6));
            assertEquals(-1, search.rec(A, 6));
        }

        @Test
        void itReturnsANegativeInsertionPointIfTheElementDoesNotExist() {
            assertEquals(-3, search.it(A, 10));
            assertEquals(-3, search.rec(A, 10));
        }

        @Test
        void itReturnsARightmostNegativeInsertionPointIfTheElementDoesNotExist() {
            assertEquals(-4, search.it(A, 12));
            assertEquals(-4, search.rec(A, 12));
        }
    }
}
