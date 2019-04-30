package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HashTableTest_get {
    private HashTable<StubA, String> table;

    @BeforeEach
    void beforeEach() {
        table = new HashTable<>();
    }

    @Nested
    class IfTheTableIsNotEmpty {
        private StubB stub1 = new StubB(0, 1);

        @BeforeEach
        void beforeEach() {
            table.put(stub1, "A");
        }

        @Test
        void itReturnsTheValueIfItExists() {
            assertEquals("A", table.get(stub1));
        }

        @Test
        void itReturnsTheValueWhenItIsChained() {
            var stub2 = new StubB(1, 1);
            table.put(stub2, "B");
            assertEquals("A", table.get(stub1));
            assertEquals("B", table.get(stub2));
        }

        @Test
        void itReturnsNullIfTheValueDoesNotExist() {
            assertNull(table.get(new StubA()));
        }
    }

    @Test
    void itReturnsNullIfTheTableIsEmpty() {
        assertNull(table.get(new StubA()));
    }

    //<editor-fold desc="stubs">
    class StubA {
    }

    class StubB extends StubA {
        int key;
        int val;

        StubB(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public int hashCode() {
            return val;
        }

        @Override
        public boolean equals(Object obj) {
            var other = (StubB) obj;
            return this.key == other.key && this.val == other.val;
        }
    }
    //</editor-fold>
}
