package interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlidingWinTest_min {
    private SlidingWin win;

    @BeforeEach
    void beforeEach() {
        win = new SlidingWin();
    }

    @Test
    void itFindsTheSlidingMinOfOneElement() {
        var expected = "[1]";
        var actual = win.min(new int[] { 1 }, 1).toString();
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
        void itFindsTheSlidingMinWithWindowSizeOne() {
            var expected = "[1, 2, 3, 4, 5]";
            var actual = win.min(A, 1).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsTheSlidingMinWithWindowSizeTwo() {
            var expected = "[1, 2, 3, 4]";
            var actual = win.min(A, 2).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsTheSlidingMinWithWindowSizeThree() {
            var expected = "[1, 2, 3]";
            var actual = win.min(A, 3).toString();
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
        void itFindsTheSlidingMinWithWindowSizeOne() {
            var expected = "[5, 4, 3, 2, 1]";
            var actual = win.min(A, 1).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsTheSlidingMinWithWindowSizeTwo() {
            var expected = "[4, 3, 2, 1]";
            var actual = win.min(A, 2).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsTheSlidingMinWithWindowSizeThree() {
            var expected = "[3, 2, 1]";
            var actual = win.min(A, 3).toString();
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
        void itFindsTheSlidingMinWithWindowSizeTwo() {
            var expected = "[5, 2, 2, 7, 7]";
            var actual = win.min(A, 2).toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsTheSlidingMinWithWindowSizeThree() {
            var expected = "[2, 2, 2, 7]";
            var actual = win.min(A, 3).toString();
            assertEquals(expected, actual);
        }
    }

    @Test
    void itFindsTheSlidingMinWithAPathologicalDataDistribution() {
        var A = new int[] { 2, 3, 4, 5, 6, 1 };
        var expected = "[1]";
        var actual = win.min(A, 6).toString();
        assertEquals(expected, actual);
    }
}
