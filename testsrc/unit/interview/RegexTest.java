package interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexTest {
    private Regex R;

    @BeforeEach
    void beforeEach() {
        R = new Regex();
    }

    @Test
    void itReturnsTrueIfTheStringMatchesThePattern() {
        assertTrue(R.match("", ""));

        assertTrue(R.match("a", "a"));
        assertTrue(R.match("abc", "abc"));

        assertTrue(R.match("abc", "ab."));

        assertTrue(R.match("abc", "a*b*c*"));
        assertTrue(R.match("abc", ".*"));
        assertTrue(R.match("abc", "d*a*b*c*"));
    }

    @Test
    void itReturnsFalseIfTheStringDoesNotMatchThePattern() {
        assertFalse(R.match("a", ""));

        assertFalse(R.match("a", "b"));
        assertFalse(R.match("abc", "ab"));
    }
}
