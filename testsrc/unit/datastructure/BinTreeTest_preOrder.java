package datastructure;

import datastructure.BinTree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinTreeTest_preOrder {
    private BinTree tree;

    @BeforeEach
    void beforeEach() {
        tree = new BinTree();
    }

    @Test
    void itTraversesABalancedTree() {
        var root = new Stub(1);
        root.l = new Stub(0);
        root.r = new Stub(2);

        tree.root = root;

        var expected = "[1, 0, 2]";
        var actual = tree.preOrder().toString();

        assertEquals(expected, actual);
    }

    @Test
    void itTraversesALeftHeavyTree() {
        var root = new Stub(2);
        root.l = new Stub(1);
        root.l.l = new Stub(0);

        tree.root = root;

        var expected = "[2, 1, 0]";
        var actual = tree.preOrder().toString();

        assertEquals(expected, actual);
    }

    @Test
    void itTraversesARightHeavyTree() {
        var root = new Stub(0);
        root.r = new Stub(1);
        root.r.r = new Stub(2);

        tree.root = root;

        var expected = "[0, 1, 2]";
        var actual = tree.preOrder().toString();

        assertEquals(expected, actual);
    }

    //<editor-fold desc="stubs">
    class Stub extends Node {
        Stub(int val) {
            super(val);
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
    //</editor-fold>
}
