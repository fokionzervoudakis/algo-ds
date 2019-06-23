package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LrsTest {
    private Lrs lrs;

    @BeforeEach
    void beforeEach() {
        lrs = new Lrs();
    }

    @Test
    void itReturnsAnEmptyStringWhenSubstringsDoNotRepeat() {
        assertTrue(lrs.getLrs("").isEmpty());
        assertTrue(lrs.getLrs("a").isEmpty());
        assertTrue(lrs.getLrs("abc").isEmpty());
    }

    @Test
    void itReturnsAStringWithOneCharacter() {
        assertEquals("a", lrs.getLrs("aa"));
    }

    @Test
    void itReturnsAStringWithManyCharacters() {
        assertEquals("aa", lrs.getLrs("aaa"));
        assertEquals("ana", lrs.getLrs("banana"));
        assertEquals("abra", lrs.getLrs("abracadabra"));
    }

    @Test
    void itReturnsTheFirstLrs() {
        assertEquals("aba", lrs.getLrs("ababbaabaa"));
    }
}
