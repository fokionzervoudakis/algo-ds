package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GcdTest {
    private Gcd gcd;

    @BeforeEach
    void beforeEach() {
        gcd = new Gcd();
    }

    @Test
    void itCalculatesTheGreatestCommonDivisorIteratively() {
        assertEquals(4, gcd.it(12, 8));
        assertEquals(5, gcd.it(25, 20));
        assertEquals(1, gcd.it(5, 12));
    }

    @Test
    void itCalculatesTheGreatestCommonDivisorRecursively() {
        assertEquals(4, gcd.rec(12, 8));
        assertEquals(5, gcd.rec(25, 20));
        assertEquals(1, gcd.rec(5, 12));
    }

    @Test
    void itCalculatesTheGcdOfOneNumber() {
        assertEquals(0, gcd.multiRec(new int[] { 0 }));
        assertEquals(1, gcd.multiRec(new int[] { 1 }));
        assertEquals(2, gcd.multiRec(new int[] { 2 }));
    }

    @Test
    void itCalculatesTheGcdOfEvenPositiveNumbers() {
        assertEquals(1, gcd.multiRec(new int[] { 1, 3, 5 }));
    }

    @Test
    void itCalculatesTheGcdOfOddPositiveNumbers() {
        assertEquals(2, gcd.multiRec(new int[] { 0, 2, 4, 6, 8 }));
    }

    @Test
    void itCalculatesTheGcdOfEvenMixedNumbers() {
        assertEquals(-1, gcd.multiRec(new int[] { -3, -1, 1, 3 }));
    }

    @Test
    void itCalculatesTheGcdOfManyOddMixedNumbers() {
        assertEquals(-2, gcd.multiRec(new int[] { -4, -2, 0, 2, 4 }));
    }

    @Test
    void itCalculatesTheGcdOfEvenNegativeNumbers() {
        assertEquals(-2, gcd.multiRec(new int[] { -2, -4, -6 }));
    }

    @Test
    void itCalculatesTheGcdOfOddNegativeNumbers() {
        assertEquals(-1, gcd.multiRec(new int[] { -1, -3, -5 }));
    }
}
