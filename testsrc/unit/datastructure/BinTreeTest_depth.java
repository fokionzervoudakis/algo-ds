package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import datastructure.BinTree.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinTreeTest_depth {
    private BinTree tree;
    private Stub root;

    @BeforeEach
    void beforeEach() {
        tree = new BinTree();
        root = new Stub();
        tree.root = root;
    }

    @Nested
    class WhenRootAndTargetNodesAreTheSame {
        @Test
        void itCalculatesTheDepthOfOneNode() {
            assertEquals(0, tree.depth(root));
        }
    }

    @Nested
    class WhenRootAndTargetNodesAreDifferent {
        @Test
        void itCalculatesTheDepthOfTwoNodes() {
            var s = new Stub();
            s.p = root;
            assertEquals(1, tree.depth(s));
        }

        @Test
        void itCalculatesTheDepthOfManyNodes() {
            var s1 = new Stub();
            var s2 = new Stub();
            s2.p = s1;
            s1.p = root;
            assertEquals(2, tree.depth(s2));
        }
    }

    //<editor-fold desc="stubs">
    class Stub extends Node {
        Stub() {
            super(Integer.MAX_VALUE);
        }
    }
    //</editor-fold>
}
