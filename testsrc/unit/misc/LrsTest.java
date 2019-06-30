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
        assertTrue(lrs.max("").isEmpty());
        assertTrue(lrs.max("a").isEmpty());
        assertTrue(lrs.max("abc").isEmpty());
    }

    @Test
    void itReturnsAStringWithOneCharacter() {
        assertEquals("a", lrs.max("aa"));
    }

    @Test
    void itReturnsAStringWithManyCharacters() {
        assertEquals("aa", lrs.max("aaa"));
        assertEquals("ana", lrs.max("banana"));
        assertEquals("abra", lrs.max("abracadabra"));
    }

    @Test
    void itReturnsTheFirstLrs() {
        assertEquals("aba", lrs.max("ababbaabaa"));
    }
}
