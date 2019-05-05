package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LruTest_get {
    private Lru<String, String> lru;

    @BeforeEach
    void beforeEach() {
        lru = new Lru<>(3);
    }

    @Nested
    class IfTheCacheIsNotEmpty {
        @BeforeEach
        void beforeEach() {
            lru.put("k1", "v1");
        }

        @Test
        void itReturnsTheValueIfItExists() {
            assertEquals("v1", lru.get("k1"));
        }

        @Test
        void itUpdatesTheLruElement() {
            lru.put("k2", "v2");
            lru.put("k3", "v3");

            lru.get("k1");

            var expected = "[null:null] -> [k1:v1] -> [k3:v3] -> [k2:v2] -> [null:null] -> null";
            var actual = lru.toString();

            assertEquals(expected, actual);
        }

        @Test
        void itReturnsNullIfTheValueDoesNotExist() {
            assertNull(lru.get("k2"));
        }
    }

    @Test
    void itReturnsNullIfTheCacheIsEmpty() {
        assertNull(lru.get("k"));
    }
}
