package datastructure;

import datastructure.BinTree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BstTest_isBst_1 {
    private Bst bst;

    @BeforeEach
    void beforeEach() {
        bst = new Bst();
        bst.root = new Node(50);
    }

    @Test
    void itReturnsTrueWhenTheTreeHasOneNode() {
        assertTrue(bst.isBst());
    }

    @Test
    void itReturnsFalseWhenTheLeftNodeIsEqualToTheParentNode() {
        bst.root.l = new Node(50);
        assertFalse(bst.isBst());
    }

    @Test
    void itReturnsFalseWhenTheRightNodeIsEqualToTheParentNode() {
        bst.root.r = new Node(50);
        assertFalse(bst.isBst());
    }

    @Test
    void itReturnsTrueWhenTheTreeIsABst() {
        bst.root.l = new Node(30);
        bst.root.l.l = new Node(10);
        bst.root.l.r = new Node(40);

        bst.root.r = new Node(70);
        bst.root.r.l = new Node(60);
        bst.root.r.r = new Node(80);

        assertTrue(bst.isBst());
    }

    @Test
    void itReturnsFalseWhenTheSubtreesAreBinarySearchTreesButTheRootIsNotABst() {
        bst.root.l = new Node(30);
        bst.root.l.l = new Node(20);
        bst.root.l.r = new Node(60);

        bst.root.r = new Node(80);
        bst.root.r.l = new Node(70);
        bst.root.r.r = new Node(90);

        assertFalse(bst.isBst());
    }

    @Test
    void itReturnsTrueWhenALeftHeavyTreeIsABst() {
        bst.root.l = new Node(40);
        bst.root.l.l = new Node(30);
        bst.root.l.l.l = new Node(20);
        bst.root.l.l.l.l = new Node(10);
        assertTrue(bst.isBst());
    }

    @Test
    void itReturnsFalseWhenARightHeavyTreeIsNotABst() {
        bst.root.r = new Node(70);
        bst.root.r.r = new Node(60);
        bst.root.r.r.r = new Node(80);
        assertFalse(bst.isBst());
    }
}
