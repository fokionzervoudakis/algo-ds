package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibTest {
    private Fib fib;

    @BeforeEach
    void beforeEach() {
        fib = new Fib();
    }

    @Test
    void itCalculatesFibonacciIteratively() {
        assertEquals(0, fib.it(0));
        assertEquals(1, fib.it(1));
        assertEquals(55, fib.it(10));
    }

    @Test
    void itCalculatesFibonacciRecursively() {
        assertEquals(0, fib.rec(0));
        assertEquals(1, fib.rec(1));
        assertEquals(55, fib.rec(10));
    }

    @Nested
    class WhenItUsesMemoization {
        private DpFib.Mem mem;

        @BeforeEach
        void beforeEach() {
            mem = new DpFib().new Mem();
        }

        @Test
        void itCalculatesFibonacciNumbers() {
            assertEquals(0, mem.fib(0));
            assertEquals(1, mem.fib(1));
            assertEquals(55, mem.fib(10));
        }

        @Test
        void itCalculatesLargeFibonacciNumbers() {
            assertEquals(102334155, mem.fib(40));
        }
    }

    @Nested
    class WhenItUsesTabulation {
        private DpFib.Tab tab;

        @BeforeEach
        void beforeEach() {
            tab = new DpFib().new Tab();
        }

        @Test
        void itCalculatesFibonacciNumbers() {
            assertEquals(0, tab.fib(0));
            assertEquals(1, tab.fib(1));
            assertEquals(55, tab.fib(10));
        }

        @Test
        void itCalculatesLargeFibonacciNumbers() {
            assertEquals(102334155, tab.fib(40));
        }
    }
}
