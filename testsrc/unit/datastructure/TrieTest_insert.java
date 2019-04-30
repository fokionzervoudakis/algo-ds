package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrieTest_insert {
    private Trie trie;

    @BeforeEach
    void beforeEach() {
        trie = new Trie();
    }

    @Test
    void itInsertsAnEmptyString() {
        trie.insert("");
        var expected = ":{}";
        var actual = trie.toString();
        assertEquals(expected, actual);
    }

    @Test
    void itInsertsOneStringWithOneCharacter() {
        trie.insert("a");
        var expected = "null:{a=a:{}}";
        var actual = trie.toString();
        assertEquals(expected, actual);
    }

    @Test
    void itInsertsOneStringWithManyCharacters() {
        trie.insert("abc");
        var expected = "null:{a=null:{b=null:{c=abc:{}}}}";
        var actual = trie.toString();
        assertEquals(expected, actual);
    }

    @Test
    void itInsertsManyOverlappingStringsWithManyCharacters() {
        trie.insert("abc");
        trie.insert("def");
        trie.insert("dfg");

        //@formatter:off
        var expected =
                "null:{" +
                    "a=null:{" +
                        "b=null:{" +
                            "c=abc:{}" +
                        "}" +
                    "}, " +
                    "d=null:{" +
                        "e=null:{" +
                            "f=def:{}" +
                        "}, " +
                        "f=null:{" +
                            "g=dfg:{}" +
                        "}" +
                    "}" +
                "}";
        //@formatter:on

        var actual = trie.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itInsertsManyNonOverlappingStringsWithManyCharacters() {
        trie.insert("abc");
        trie.insert("def");
        trie.insert("ghi");

        //@formatter:off
        var expected =
                "null:{" +
                    "a=null:{" +
                        "b=null:{" +
                            "c=abc:{}" +
                        "}" +
                    "}, " +
                    "d=null:{" +
                        "e=null:{" +
                            "f=def:{}" +
                        "}" +
                    "}, " +
                    "g=null:{" +
                        "h=null:{" +
                            "i=ghi:{}" +
                        "}" +
                    "}" +
                "}";
        //@formatter:on

        var actual = trie.toString();

        assertEquals(expected, actual);
    }
}
