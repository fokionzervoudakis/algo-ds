package interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlidingWinTest_max {
    private SlidingWin win;

    @BeforeEach
    void beforeEach() {
        win = new SlidingWin();
    }

    @Test
    void itFindsTheSlidingMaxOfOneElement() {
        var expected = "[1]";
        var actual = win.max(new int[] { 1 }, 1).toString();
        assertEquals(expected, actual);
    }

    @Nested
    class WhenTheElementsAreAscending {
        private int[] A;

        @BeforeEach
        void beforeEach() {
            A = new int[] { 1, 2, 3, 4, 5 };
        }

        @Test
        void itFindsTheSlidingMaxWithWindowSizeOne() {
            var expected = "[1, 2, 3, 4, 5]";
            var actual = win.max(A, 1).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsTheSlidingMaxWithWindowSizeTwo() {
            var expected = "[2, 3, 4, 5]";
            var actual = win.max(A, 2).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsTheSlidingMaxWithWindowSizeThree() {
            var expected = "[3, 4, 5]";
            var actual = win.max(A, 3).toString();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class WhenTheElementsAreDescending {
        private int[] A;

        @BeforeEach
        void beforeEach() {
            A = new int[] { 5, 4, 3, 2, 1 };
        }

        @Test
        void itFindsTheSlidingMaxWithWindowSizeOne() {
            var expected = "[5, 4, 3, 2, 1]";
            var actual = win.max(A, 1).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsTheSlidingMaxWithWindowSizeTwo() {
            var expected = "[5, 4, 3, 2]";
            var actual = win.max(A, 2).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsTheSlidingMaxWithWindowSizeThree() {
            var expected = "[5, 4, 3]";
            var actual = win.max(A, 3).toString();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class WhenTheElementsAreMixed {
        private int[] A;

        @BeforeEach
        void beforeEach() {
            A = new int[] { 10, 5, 2, 7, 8, 7 };
        }

        @Test
        void itFindsTheSlidingMaxWithWindowSizeTwo() {
            var expected = "[10, 5, 7, 8, 8]";
            var actual = win.max(A, 2).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsTheSlidingMaxWithWindowSizeThree() {
            var expected = "[10, 7, 8, 8]";
            var actual = win.max(A, 3).toString();
            assertEquals(expected, actual);
        }
    }

    @Test
    void itFindsTheSlidingMaxWithAPathologicalDataDistribution() {
        var A = new int[] { 5, 4, 3, 2, 1, 6 };
        var expected = "[6]";
        var actual = win.max(A, 6).toString();
        assertEquals(expected, actual);
    }
}
