package datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuffixArrTest {
    @Test
    void itAddsZeroSuffixes() {
        var arr = new SuffixArr("");
        assertEquals("[]", arr.toString());
    }

    @Test
    void itAddsOneSuffix() {
        var arr = new SuffixArr("a");
        assertEquals("[a]", arr.toString());
    }

    @Test
    void itAddsManySuffixes() {
        var arr = new SuffixArr("abc");
        assertEquals("[abc, bc, c]", arr.toString());
    }

    @Test
    void itCalculatesLcpLength() {
        var arr = new SuffixArr("banana");
        assertEquals(1, arr.lcpLength(1));
        assertEquals(3, arr.lcpLength(2));
        assertEquals(0, arr.lcpLength(3));
        assertEquals(0, arr.lcpLength(4));
        assertEquals(2, arr.lcpLength(5));
    }
}
