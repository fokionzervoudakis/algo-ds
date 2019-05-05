package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LruTest_put {
    private Lru<String, String> lru;

    @BeforeEach
    void beforeEach() {
        lru = new Lru<>(3);
        lru.put("k1", "v1");
    }

    @Test
    void itMapsKeyValuePairs() {
        lru.put("k2", "v2");
        var expected = "[null:null] -> [k2:v2] -> [k1:v1] -> [null:null] -> null";
        var actual = lru.toString();
        assertEquals(expected, actual);
    }

    @Test
    void itEvictsTheLruElement() {
        lru.put("k2", "v2");
        lru.put("k3", "v3");
        lru.put("k4", "v4");
        var expected = "[null:null] -> [k4:v4] -> [k3:v3] -> [k2:v2] -> [null:null] -> null";
        var actual = lru.toString();
        assertEquals(expected, actual);
    }
}
