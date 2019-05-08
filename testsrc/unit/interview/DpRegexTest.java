package interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DpRegexTest {
    private DpRegex.Mem M;

    @BeforeEach
    void beforeEach() {
        M = new DpRegex().new Mem();
    }

    @Test
    void itReturnsTrueIfTheStringMatchesThePattern() {
        assertTrue(M.match("", ""));

        assertTrue(M.match("a", "a"));
        assertTrue(M.match("abc", "abc"));

        assertTrue(M.match("abc", "ab."));

        assertTrue(M.match("abc", "a*b*c*"));
        assertTrue(M.match("abc", ".*"));
        assertTrue(M.match("abc", "d*a*b*c*"));
    }

    @Test
    void itReturnsFalseIfTheStringDoesNotMatchThePattern() {
        assertFalse(M.match("a", ""));

        assertFalse(M.match("a", "b"));
        assertFalse(M.match("abc", "ab"));
    }
}
