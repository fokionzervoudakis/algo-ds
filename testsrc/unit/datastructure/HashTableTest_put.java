package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTableTest_put {
    private HashTable<Stub, String> table;

    @BeforeEach
    void beforeEach() {
        table = new HashTable<>();
        table.put(new Stub(0, 1), "A");
    }

    @Test
    void itMapsKeyValuePairs() {
        table.put(new Stub(0, 2), "B");
        var expected = "[null, 01: A, 02: B, null, null, null, null, null]";
        var actual = table.toString();
        assertEquals(expected, actual);
    }

    @Test
    void itChainsCollidingEntries() {
        table.put(new Stub(1, 1), "B");
        var expected = "[null, 11: B -> 01: A, null, null, null, null, null, null]";
        var actual = table.toString();
        assertEquals(expected, actual);
    }

    //<editor-fold desc="stubs">
    class Stub {
        int key;
        int val;

        Stub(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public int hashCode() {
            return val;
        }

        @Override
        public boolean equals(Object obj) {
            var other = (HashTableTest_get.StubB) obj;
            return this.key == other.key && this.val == other.val;
        }

        @Override
        public String toString() {
            return key + "" + val;
        }
    }
    //</editor-fold>
}
