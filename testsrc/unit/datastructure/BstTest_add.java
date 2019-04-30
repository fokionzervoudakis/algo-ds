package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BstTest_add {
    private Bst bst;

    @BeforeEach
    void beforeEach() {
        bst = new Bst();
    }

    @Test
    void itAddsARootNode() {
        bst.add(3);
        assertEquals("(null 3 null)", bst.toString());
    }

    @Test
    void itAddsALeftNode() {
        bst.add(3);
        bst.add(1);
        assertEquals("((null 1 null) 3 null)", bst.toString());
    }

    @Test
    void itAddsARightNode() {
        bst.add(3);
        bst.add(5);
        assertEquals("(null 3 (null 5 null))", bst.toString());
    }

    @Nested
    class WhenItHasALeftNode {
        @BeforeEach
        void beforeEach() {
            bst.add(3);
            bst.add(1);
        }

        @Test
        void itAddsALeftLeftNode() {
            bst.add(0);
            assertEquals("(((null 0 null) 1 null) 3 null)", bst.toString());
        }

        @Test
        void itAddsALeftRightNode() {
            bst.add(2);
            assertEquals("((null 1 (null 2 null)) 3 null)", bst.toString());
        }
    }

    @Nested
    class WhenItHasARightNode {
        @BeforeEach
        void beforeEach() {
            bst.add(3);
            bst.add(5);
        }

        @Test
        void itAddsARightLeftNode() {
            bst.add(4);
            assertEquals("(null 3 ((null 4 null) 5 null))", bst.toString());
        }

        @Test
        void itAddsARightRightNode() {
            bst.add(6);
            assertEquals("(null 3 (null 5 (null 6 null)))", bst.toString());
        }
    }

    @Test
    void itAddsANodeWhenTheValueIsNotInTheTree() {
        assertTrue(bst.add(0));
    }

    @Test
    void itDoesNotAddANodeWhenTheValueIsInTheTree() {
        bst.add(0);
        assertFalse(bst.add(0));
    }
}
