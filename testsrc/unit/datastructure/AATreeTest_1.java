package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AATreeTest_1 {
    private AATree tree;

    @BeforeEach
    void beforeEach() {
        tree = new AATree();
    }

    @Test
    void itAddsARootNode() {
        tree.add(3);
        assertEquals("(null 3:1 null)", tree.toString());
    }

    @Test
    void itAddsALeftNodeAndBalancesTheTree() {
        tree.add(3);
        tree.add(1);
        assertEquals("(null 1:1 (null 3:1 null))", tree.toString());
    }

    @Test
    void itAddsARightNode() {
        tree.add(3);
        tree.add(5);
        assertEquals("(null 3:1 (null 5:1 null))", tree.toString());
    }

    @Nested
    class WhenItHasALeftNode {
        @BeforeEach
        void beforeEach() {
            tree.add(3);
            tree.add(1);
        }

        @Test
        void itAddsALeftLeftNodeAndBalancesTheTree() {
            tree.add(0);
            assertEquals("((null 0:1 null) 1:2 (null 3:1 null))", tree.toString());
        }

        @Test
        void itAddsALeftRightNodeAndBalancesTheTree() {
            tree.add(2);
            assertEquals("((null 1:1 null) 2:2 (null 3:1 null))", tree.toString());
        }
    }

    @Nested
    class WhenItHasARightNode {
        @BeforeEach
        void beforeEach() {
            tree.add(3);
            tree.add(5);
        }

        @Test
        void itAddsARightLeftNodeAndBalancesTheTree() {
            tree.add(4);
            assertEquals("((null 3:1 null) 4:2 (null 5:1 null))", tree.toString());
        }

        @Test
        void itAddsARightRightNodeAndBalancesTheTree() {
            tree.add(6);
            assertEquals("((null 3:1 null) 5:2 (null 6:1 null))", tree.toString());
        }
    }

    @Test
    void itAddsANodeWhenTheValueIsNotInTheTree() {
        tree.add(0);
        assertEquals("(null 0:1 null)", tree.toString());
    }

    @Test
    void itDoesNotAddANodeWhenTheValueIsInTheTree() {
        tree.add(0);
        tree.add(0);
        assertEquals("(null 0:1 null)", tree.toString());
    }
}
