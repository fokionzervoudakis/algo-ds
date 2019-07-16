package datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuffixArrTest {
    @Test
    void itAddsZeroSuffixes() {
        assertEquals("[],[]", new SuffixArr("").toString());
    }

    @Test
    void itAddsOneSuffix() {
        assertEquals("[a:0],[a:0]", new SuffixArr("a").toString());
        assertEquals("[b:0],[b:0]", new SuffixArr("b").toString());
        assertEquals("[c:0],[c:0]", new SuffixArr("c").toString());
    }

    @Test
    void itAddsManySuffixes() {
        var expected = "[banana:0, anana:1, nana:2, ana:3, na:4, a:5]," +
                "[a:5, ana:3, anana:1, banana:0, na:4, nana:2]";
        var actual = new SuffixArr("banana").toString();
        assertEquals(expected, actual);
    }

    @Test
    void itCalculatesTheLcpLength() {
        var arr = new SuffixArr("banana");
        assertEquals(1, arr.lcpLength(1));
        assertEquals(3, arr.lcpLength(2));
        assertEquals(0, arr.lcpLength(3));
        assertEquals(0, arr.lcpLength(4));
        assertEquals(2, arr.lcpLength(5));
    }

    @Test
    void itReturnsTheSuffixIndex() {
        var arr = new SuffixArr("banana");
        assertEquals(5, arr.indexAt(0));
        assertEquals(3, arr.indexAt(1));
        assertEquals(1, arr.indexAt(2));
        assertEquals(0, arr.indexAt(3));
        assertEquals(4, arr.indexAt(4));
        assertEquals(2, arr.indexAt(5));
    }

    @Test
    void itReturnsTheSuffix() {
        var arr = new SuffixArr("banana");
        assertEquals("banana:0", arr.suffixAt(0).toString());
        assertEquals("anana:1", arr.suffixAt(1).toString());
        assertEquals("nana:2", arr.suffixAt(2).toString());
        assertEquals("ana:3", arr.suffixAt(3).toString());
        assertEquals("na:4", arr.suffixAt(4).toString());
        assertEquals("a:5", arr.suffixAt(5).toString());
    }
}
