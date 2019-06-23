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
}
