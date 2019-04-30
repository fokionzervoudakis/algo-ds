package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KadaneTest {
    private Kadane K;

    @BeforeEach
    void beforeEach() {
        K = new Kadane();
    }

    @Nested
    class WhenNumbersAreMixed {
        private int[] A;

        @BeforeEach
        void beforeEach() {
            // 4 + (−1) + 2 + 1 = 6
            A = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        }

        @Test
        void itReturnsTheMaxSumOfItemsInAContiguousSubArray() {
            assertEquals(6, K.max(A));
        }

        @Test
        void itReturnsAContiguousSubArrayWithTheMaxSum() {
            var expected = "[4, -1, 2, 1]";
            var actual = Arrays.toString(K.sub(A));
            assertEquals(expected, actual);
        }
    }

    @Nested
    class WhenAllNumbersArePositive {
        private int[] A1;
        private int[] A2;
        private int[] A3;

        @BeforeEach
        void beforeEach() {
            A1 = new int[] { 1 };
            A2 = new int[] { 1, 2 };
            A3 = new int[] { 1, 2, 3 };
        }

        @Test
        void itReturnsTheSumOfTheEntireArray() {
            assertEquals(1, K.max(A1));
            assertEquals(3, K.max(A2));
            assertEquals(6, K.max(A3));
        }

        @Test
        void itReturnsTheEntireArray() {
            assertEquals("[1]", Arrays.toString(K.sub(A1)));
            assertEquals("[1, 2]", Arrays.toString(K.sub(A2)));
            assertEquals("[1, 2, 3]", Arrays.toString(K.sub(A3)));
        }
    }

    @Nested
    class WhenAllNumbersAreNegative {
        private int[] A1;
        private int[] A2;
        private int[] A3;

        @BeforeEach
        void beforeEach() {
            A1 = new int[] { -1 };
            A2 = new int[] { -1, -2 };
            A3 = new int[] { -1, -2, -3 };
        }

        @Test
        void itReturnsTheNumberWithTheSmallestAbsoluteValue() {
            assertEquals(-1, K.max(A1));
            assertEquals(-1, K.max(A2));
            assertEquals(-1, K.max(A3));
        }

        @Test
        void itReturnsASubArrayWithTheNumberThatHasTheSmallestAbsoluteValue() {
            assertEquals("[-1]", Arrays.toString(K.sub(A1)));
            assertEquals("[-1]", Arrays.toString(K.sub(A2)));
            assertEquals("[-1]", Arrays.toString(K.sub(A3)));
        }
    }
}
