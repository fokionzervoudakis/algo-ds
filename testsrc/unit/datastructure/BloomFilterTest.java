package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BloomFilterTest {
    private BloomFilter<String> filter;

    @BeforeEach
    void beforeEach() {
        filter = new BloomFilter<>(8);
    }

    @Test
    void itInsertsUniqueValues() {
        filter.insert("A");
        filter.insert("B");
        filter.insert("C");
        assertEquals("[0, 1, 1, 1, 0, 0, 0, 0]", filter.toString());
    }

    @Test
    void itInsertsDuplicateValues() {
        filter.insert("A");
        filter.insert("I");
        assertEquals("[0, 1, 0, 0, 0, 0, 0, 0]", filter.toString());
    }

    @Nested
    class WhenItDoesLookups {
        @BeforeEach
        void beforeEach() {
            filter.insert("A");
            filter.insert("B");
            filter.insert("C");
        }

        @Test
        void itReturnsTrueIfTheValueMightBeInTheSet() {
            assertTrue(filter.lookup("A"));
            assertTrue(filter.lookup("I"));
        }

        @Test
        void itReturnsFalseIfTheValueIsDefinitelyNotInTheSet() {
            assertFalse(filter.lookup("D"));
        }
    }
}
