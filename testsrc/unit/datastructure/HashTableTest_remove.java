package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HashTableTest_remove {
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
        void itRemovesTheEntryIfItExists() {
            assertEquals("A", table.remove(stub1));
            var expected = "[null, null, null, null, null, null, null, null]";
            var actual = table.toString();
            assertEquals(expected, actual);
        }

        @Nested
        class IfTheTableHasCollidingEntries {
            private StubB stub2 = new StubB(1, 1);

            @BeforeEach
            void beforeEach() {
                table.put(stub2, "B");
            }

            @Test
            void itRemovesTheFirstChainedEntry() {
                assertEquals("A", table.remove(stub1));
                var expected = "[null, 11: B, null, null, null, null, null, null]";
                var actual = table.toString();
                assertEquals(expected, actual);
            }

            @Test
            void itRemovesTheSecondChainedEntry() {
                assertEquals("B", table.remove(stub2));
                var expected = "[null, 01: A, null, null, null, null, null, null]";
                var actual = table.toString();
                assertEquals(expected, actual);
            }
        }

        @Test
        void itReturnsNullIfTheValueDoesNotExist() {
            assertNull(table.remove(new StubA()));
        }
    }

    @Test
    void itReturnsNullIfTheTableIsEmpty() {
        assertNull(table.remove(new StubA()));
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

        @Override
        public String toString() {
            return key + "" + val;
        }
    }
    //</editor-fold>
}
