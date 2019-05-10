package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiffTest {
    private Diff diff;

    @BeforeEach
    void beforeEach() {
        diff = new Diff();
    }

    @Test
    void itDiffsNothingWhenBothArraysAreEmpty() {
        assertTrue(diff.diff(new char[0], new char[0]).isEmpty());
    }

    @Test
    void itDiffsNothingWhenOneArrayIsEmpty() {
        char[] A = { 'a' };
        assertTrue(diff.diff(A, new char[0]).isEmpty());
        assertTrue(diff.diff(new char[0], A).isEmpty());
    }

    @Test
    void itDiffsNothingWhenAnLcsDoesNotExist() {
        // TODO fix output
        assertEquals("", diff.diff(new char[] { 'a' }, new char[] { 'b' }));
    }

    @Test
    void itDiffsMatchingCharSequences() {
        assertEquals("  a", diff.diff(new char[] { 'a' }, new char[] { 'a' }));
        assertEquals("  a  g", diff.diff(new char[] { 'a', 'g' }, new char[] { 'a', 'g' }));
        assertEquals("  g +a", diff.diff(new char[] { 'a', 'g' }, new char[] { 'g', 'a' }));
    }

    @Test
    void itDiffsCharSequencesThatDoNotMatch_1() {
        var expected = "  1 +2  2 +4 +5 +3 +3  3 +2  4";
        var actual = diff.diff("1234".toCharArray(), "1224533324".toCharArray());
        assertEquals(expected, actual);
    }

    @Test
    void itDiffsCharSequencesThatDoNotMatch_2() {
        var expected = "  t -h +e -i -s -  +s +t -i -s +i +n -  -a -  +g +1 +2 +3  t  e  s  t +i +n +g";
        var actual = diff.diff("this is a test".toCharArray(), "testing123testing".toCharArray());
        assertEquals(expected, actual);
    }
}
