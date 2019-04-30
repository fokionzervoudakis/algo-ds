package datastructure;

import datastructure.BinTree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinTreeTest_size {
    private BinTree tree;

    @BeforeEach
    void beforeEach() {
        tree = new BinTree();
    }

    @Nested
    class WhenTheTreeIsEmpty {
        @Test
        void itCalculatesTheTreeSize() {
            assertEquals(0, tree.size());
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
        void itCalculatesTheTreeSizeWithOneNode() {
            assertEquals(1, tree.size());
        }

        @Test
        void itCalculatesTheTreeSizeWithManyBalancedNodes() {
            root.l = new Stub();
            root.r = new Stub();
            assertEquals(3, tree.size());
        }

        @Test
        void itCalculatesTheTreeSizeWithALeftHeavyTree_1() {
            root.l = new Stub();
            root.l.l = new Stub();
            assertEquals(3, tree.size());
        }

        @Test
        void itCalculatesTheTreeSizeWithALeftHeavyTree_2() {
            root.l = new Stub();
            root.l.r = new Stub();
            assertEquals(3, tree.size());
        }

        @Test
        void itCalculatesTheTreeSizeWithARightHeavyTree_1() {
            root.r = new Stub();
            root.r.l = new Stub();
            assertEquals(3, tree.size());
        }

        @Test
        void itCalculatesTheTreeSizeWithARightHeavyTree_2() {
            root.r = new Stub();
            root.r.r = new Stub();
            assertEquals(3, tree.size());
        }

        //<editor-fold desc="stubs">
        class Stub extends Node {
            Stub() {
                super(Integer.MAX_VALUE);
            }
        }
        //</editor-fold>
    }
}
