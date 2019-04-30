package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class QuickSelectTest {
    private QuickSelect select;

    @BeforeEach
    void beforeEach() {
        select = new QuickSelect();
    }

    @Test
    void itReturnsNullWhenItSearchesZeroElements() {
        assertNull(select.it(new int[0], 0));
    }

    @Nested
    class WhenItSearchesOneElement {
        private int[] A;

        @BeforeEach
        void beforeEach() {
            A = new int[] { 1 };
        }

        @Test
        void itReturnsTheFirstSmallestElement() {
            assertEquals(1, (int) select.it(A, 0));
        }

        @Test
        void itReturnsNullWhenTheTargetIsTooLarge() {
            assertNull(select.it(A, 1));
        }
    }

    @Nested
    class WhenItSearchesAnEvenNumberOfElements {
        private int[] A;

        @BeforeEach
        void beforeEach() {
            A = new int[] { 5, 2, 1, 3, 6, 4 };
        }

        @Test
        void itReturnsTheFirstSmallestElement() {
            assertEquals(1, (int) select.it(A, 0));
        }

        @Test
        void itReturnsTheSecondSmallestElement() {
            assertEquals(2, (int) select.it(A, 1));
        }

        @Test
        void itReturnsTheThirdSmallestElement() {
            assertEquals(3, (int) select.it(A, 2));
        }

        @Test
        void itReturnsTheLargestElement() {
            assertEquals(6, (int) select.it(A, 5));
        }

        @Test
        void itReturnsNullWhenTheTargetIsTooLarge() {
            assertNull(select.it(A, 6));
        }
    }

    @Nested
    class WhenItSearchesAnOddNumberOfElements {
        private int[] A;

        @BeforeEach
        void beforeEach() {
            A = new int[] { 5, 2, 1, 3, 4 };
        }

        @Test
        void itReturnsTheFirstSmallestElement() {
            assertEquals(1, (int) select.it(A, 0));
        }

        @Test
        void itReturnsTheSecondSmallestElement() {
            assertEquals(2, (int) select.it(A, 1));
        }

        @Test
        void itReturnsTheThirdSmallestElement() {
            assertEquals(3, (int) select.it(A, 2));
        }

        @Test
        void itReturnsTheLargestElement() {
            assertEquals(5, (int) select.it(A, 4));
        }

        @Test
        void itReturnsNullWhenTheTargetIsTooLarge() {
            assertNull(select.it(A, 5));
        }
    }
}
