package datastructure;

import datastructure.BinTree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinTreeTest_height {
    private BinTree tree;

    @BeforeEach
    void beforeEach() {
        tree = new BinTree();
    }

    @Nested
    class WhenTheTreeIsEmpty {
        @Test
        void itCalculatesANegativeTreeHeight() {
            assertEquals(-1, tree.height());
        }
    }

    @Nested
    class WhenTheTreeIsNotEmpty {
        private Stub root;

        @BeforeEach
        void beforeEach() {
            root = new Stub();
            tree.root = root;
        }

        @Test
        void itCalculatesTheTreeHeightWithOneNode() {
            assertEquals(0, tree.height());
        }

        @Test
        void itCalculatesTheTreeHeightWithManyBalancedNodes() {
            root.l = new Stub();
            root.r = new Stub();
            assertEquals(1, tree.height());
        }

        @Test
        void itCalculatesTheTreeHeightWithALeftHeavyTree_1() {
            root.l = new Stub();
            root.l.l = new Stub();
            assertEquals(2, tree.height());
        }

        @Test
        void itCalculatesTheTreeHeightWithALeftHeavyTree_2() {
            root.l = new Stub();
            root.l.r = new Stub();
            assertEquals(2, tree.height());
        }

        @Test
        void itCalculatesTheTreeHeightWithARightHeavyTree_1() {
            root.r = new Stub();
            root.r.l = new Stub();
            assertEquals(2, tree.height());
        }

        @Test
        void itCalculatesTheTreeHeightWithARightHeavyTree_2() {
            root.r = new Stub();
            root.r.r = new Stub();
            assertEquals(2, tree.height());
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
