package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DpKnapsackTest {
    @Nested
    class WhenItUsesTopDownDp {
        private DpKnapsack.Mem mem;

        @BeforeEach
        void beforeEach() {
            mem = new DpKnapsack().new Mem();
        }

        @Test
        void itMaximizesZeroItems() {
            assertEquals(0, mem.max(new int[0], new int[0], 0));
        }

        @Test
        void itMaximizesOneItem() {
            var A = new int[] { 1 };
            assertEquals(0, mem.max(A, A, 0));
            assertEquals(1, mem.max(A, A, 1));
            assertEquals(1, mem.max(A, A, 2));
        }

        @Test
        void itMaximizesManyItems() {
            var w = new int[] { 3, 1, 2 };
            var v = new int[] { 30, 10, 20 };
            assertEquals(0, mem.max(w, v, 0));
            assertEquals(10, mem.max(w, v, 1));
            assertEquals(20, mem.max(w, v, 2));
            assertEquals(30, mem.max(w, v, 3));
            assertEquals(40, mem.max(w, v, 4));
            assertEquals(50, mem.max(w, v, 5));
            assertEquals(60, mem.max(w, v, 6));
            assertEquals(60, mem.max(w, v, 7));
        }

        @Test
        void itMaximizesManyDuplicateItems() {
            var w = new int[] { 3, 1, 2, 1, 4, 2 };
            var v = new int[] { 30, 10, 20, 10, 40, 20 };
            assertEquals(0, mem.max(w, v, 0));
            assertEquals(10, mem.max(w, v, 1));
            assertEquals(20, mem.max(w, v, 2));
            assertEquals(30, mem.max(w, v, 3));
            assertEquals(40, mem.max(w, v, 4));
            assertEquals(50, mem.max(w, v, 5));
            assertEquals(60, mem.max(w, v, 6));
            assertEquals(70, mem.max(w, v, 7));
            assertEquals(80, mem.max(w, v, 8));
            assertEquals(90, mem.max(w, v, 9));
            assertEquals(100, mem.max(w, v, 10));
            assertEquals(110, mem.max(w, v, 11));
            assertEquals(120, mem.max(w, v, 12));
            assertEquals(130, mem.max(w, v, 13));
            assertEquals(130, mem.max(w, v, 14));
        }
    }

    @Nested
    class WhenItUsesBottomUpDp {
        private DpKnapsack.Tab tab;

        @BeforeEach
        void beforeEach() {
            tab = new DpKnapsack().new Tab();
        }

        @Test
        void itMaximizesZeroItems() {
            assertEquals(0, tab.max(new int[0], new int[0], 0));
        }

        @Test
        void itMaximizesOneItem() {
            var w = new int[] { 1 };
            var v = new int[] { 1 };
            assertEquals(0, tab.max(w, v, 0));
            assertEquals(1, tab.max(w, v, 1));
            assertEquals(1, tab.max(w, v, 2));
        }

        @Test
        void itMaximizesManyItems() {
            var w = new int[] { 3, 1, 2 };
            var v = new int[] { 30, 10, 20 };
            assertEquals(0, tab.max(w, v, 0));
            assertEquals(10, tab.max(w, v, 1));
            assertEquals(20, tab.max(w, v, 2));
            assertEquals(30, tab.max(w, v, 3));
            assertEquals(40, tab.max(w, v, 4));
            assertEquals(50, tab.max(w, v, 5));
            assertEquals(60, tab.max(w, v, 6));

            //   size=7: 0, 1,  2,  3,  4,  5,  6,  7
            // w=3,v=30: 0, 0,  0,  30, 30, 30, 30, 30
            // w=1,v=10: 0, 10, 10, 30, 40, 40, 40, 40
            // w=2,v=20: 0, 10, 20, 30, 40, 50, 60, 60

            assertEquals(60, tab.max(w, v, 7));
        }

        @Test
        void itMaximizesManyDuplicateItems() {
            var w = new int[] { 3, 1, 2, 1, 4, 2 };
            var v = new int[] { 30, 10, 20, 10, 40, 20 };
            assertEquals(0, tab.max(w, v, 0));
            assertEquals(10, tab.max(w, v, 1));
            assertEquals(20, tab.max(w, v, 2));
            assertEquals(30, tab.max(w, v, 3));
            assertEquals(40, tab.max(w, v, 4));
            assertEquals(50, tab.max(w, v, 5));
            assertEquals(60, tab.max(w, v, 6));
            assertEquals(70, tab.max(w, v, 7));
            assertEquals(80, tab.max(w, v, 8));
            assertEquals(90, tab.max(w, v, 9));
            assertEquals(100, tab.max(w, v, 10));
            assertEquals(110, tab.max(w, v, 11));
            assertEquals(120, tab.max(w, v, 12));
            assertEquals(130, tab.max(w, v, 13));

            //  size=14: 0, 1,  2,  3,  4,  5,  6,  7,  8,  9,  10,  11,  12,  13,  14
            // w=3,v=30: 0, 0,  0,  30, 30, 30, 30, 30, 30, 30, 30,  30,  30,  30,  30
            // w=1,v=10: 0, 10, 10, 30, 40, 40, 40, 40, 40, 40, 40,  40,  40,  40,  40
            // w=2,v=20: 0, 10, 20, 30, 40, 50, 60, 60, 60, 60, 60,  60,  60,  60,  60
            // w=1,v=10: 0, 10, 20, 30, 40, 50, 60, 70, 70, 70, 70,  70,  70,  70,  70
            // w=4,v=40: 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 110, 110, 110
            // w=2,v=20: 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 130

            assertEquals(130, tab.max(w, v, 14));
        }
    }
}
