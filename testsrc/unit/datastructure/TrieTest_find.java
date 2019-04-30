package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TrieTest_find {
    private Trie trie;

    @BeforeEach
    void beforeEach() {
        trie = new Trie();
    }

    @Test
    void itFindsAnEmptyRootNode() {
        var expected = "null:{}";
        var actual = trie.lookup("").toString();
        assertEquals(expected, actual);
    }

    @Test
    void itReturnsNullWhenTheCharacterDoesNotExist() {
        trie.insert("a");
        assertNull(trie.lookup("b"));
    }

    @Test
    void itFindsANodeWithoutChildren() {
        trie.insert("a");
        var expected = "a:{}";
        var actual = trie.lookup("a").toString();
        assertEquals(expected, actual);
    }

    @Nested
    class WhenItHasManyChildren {
        @BeforeEach
        void beforeEach() {
            trie.insert("abc");
        }

        @Test
        void itFindsANodeWithOneChild() {
            var expected = "null:{c=abc:{}}";
            var actual = trie.lookup("ab").toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsANodeWithNestedChildren() {
            var expected = "null:{b=null:{c=abc:{}}}";
            var actual = trie.lookup("a").toString();
            assertEquals(expected, actual);
        }

        @Test
        void itFindsANodeWithManyChildren() {
            trie.insert("def");
            trie.insert("dfg");
            var expected = "null:{e=null:{f=def:{}}, f=null:{g=dfg:{}}}";
            var actual = trie.lookup("d").toString();
            assertEquals(expected, actual);
        }
    }
}
