package interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathSearchTest {
    private PathSearch finder;

    @BeforeEach
    void beforeEach() {
        finder = new PathSearch();
    }

    @Test
    void itPerformsTrivialSearches() {
        assertEquals(0, finder.search(new char[][] { { 'X' } }, 0, 0));
        assertEquals(-1, finder.search(new char[][] { { '0' } }, 0, 0));
        assertEquals(-1, finder.search(new char[][] { { '1' } }, 0, 0));
    }

    @Test
    void itReturnsTheDistanceToTheTarget() {
        char[][] M = {
                { '1', '0', '1', '1' },
                { '1', '1', '1', '1' },
                { '1', '1', '1', '1' },
                { '1', '1', '1', 'X' }
        };
        assertEquals(6, finder.search(M, 0, 0));
    }

    @Test
    void itReturnsANegativeValueWhenATargetDoesNotExist() {
        char[][] M = {
                { '1', '0', '1', '1' },
                { '1', '1', '1', '1' },
                { '1', '1', '1', '1' },
                { '1', '1', '1', '0' }
        };
        assertEquals(-1, finder.search(M, 0, 0));
    }
}
