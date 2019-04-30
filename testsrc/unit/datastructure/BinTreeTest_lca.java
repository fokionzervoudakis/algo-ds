package datastructure;

import datastructure.BinTree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinTreeTest_lca {
    private BinTree tree;
    private Node root;

    @BeforeEach
    void beforeEach() {
        tree = new BinTree();
        root = new Stub(1);
        root.l = new Stub(3);
        root.r = new Stub(2);
        root.l.l = new Stub(4);
        root.l.r = new Stub(6);
        root.l.r.l = new Stub(5);
        tree.root = root;
    }

    @Test
    void itReturnsTheLowestCommonAncestor() {
        assertEquals("3", tree.lca(root.l.l, root.l.r.l).toString());
        assertEquals("3", tree.lca(root.l, root.l.r.l).toString());
        assertEquals("1", tree.lca(root.l.l, root.r).toString());
        assertEquals("6", tree.lca(root.l.r, root.l.r).toString());
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
