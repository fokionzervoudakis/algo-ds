package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LpsLrsTest {
    private LpsLrs lpsLrs;

    @BeforeEach
    void beforeEach() {
        lpsLrs = new LpsLrs();
    }

    @Test
    void itReturnsAnEmptyStringWhenSubstringsDoNotRepeat() {
        assertTrue(lpsLrs.lrs("").isEmpty());
        assertTrue(lpsLrs.lrs("a").isEmpty());
        assertTrue(lpsLrs.lrs("abc").isEmpty());
    }

    @Test
    void itReturnsAStringWithOneCharacter() {
        assertEquals("a", lpsLrs.lrs("aa"));
    }

    @Test
    void itReturnsAStringWithManyCharacters() {
        assertEquals("aa", lpsLrs.lrs("aaa"));
        assertEquals("ana", lpsLrs.lrs("banana"));
        assertEquals("abra", lpsLrs.lrs("abracadabra"));
    }

    @Test
    void itReturnsTheFirstLrs() {
        assertEquals("aba", lpsLrs.lrs("ababbaabaa"));
    }

    @Test
    void itReturnsTheLongestPalindromicSubstring() {
        assertEquals("", lpsLrs.lps(""));
        assertEquals("aa", lpsLrs.lps("aa"));
        assertEquals("acca", lpsLrs.lps("accaba"));
        assertEquals("anana", lpsLrs.lps ("banana"));
        assertEquals("tattarrattat", lpsLrs.lps ("tattarrattat"));
    }
}
