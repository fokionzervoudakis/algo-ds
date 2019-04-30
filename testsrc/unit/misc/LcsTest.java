package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LcsTest {
    private Lcs lcs;

    @BeforeEach
    void beforeEach() {
        lcs = new Lcs();
    }

    @Test
    void itReturnsZeroWhenBothArraysAreEmpty() {
        assertEquals(0, lcs.len(new char[0], new char[0]));
    }

    @Test
    void itReturnsZeroWhenOneArrayIsEmpty() {
        char[] A = { 'a' };
        assertEquals(0, lcs.len(A, new char[0]));
        assertEquals(0, lcs.len(new char[0], A));
    }

    @Test
    void itReturnsZeroWhenAnLscDoesNotExist() {
        assertEquals(0, lcs.len(new char[] { 'a' }, new char[] { 'b' }));
    }

    @Test
    void itReturnsTheLcs() {
        assertEquals(1, lcs.len(new char[] { 'a' }, new char[] { 'a' }));
        assertEquals(2, lcs.len(new char[] { 'a', 'g' }, new char[] { 'a', 'g' }));
        assertEquals(1, lcs.len(new char[] { 'a', 'g' }, new char[] { 'g', 'a' }));

        // [1234]
        // [12]245[3]332[4]
        assertEquals(4, lcs.len("1234".toCharArray(), "1224533324".toCharArray()));

        // [t]hi[s] [i]s a [test]
        // [t]e[s]t[i]ng123[test]ing
        assertEquals(7, lcs.len("this is a test".toCharArray(), "testing123testing".toCharArray()));
    }
}
