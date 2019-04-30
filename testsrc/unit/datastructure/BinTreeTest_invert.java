package datastructure;

import datastructure.BinTree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinTreeTest_invert {
    private BinTree tree;

    @BeforeEach
    void beforeEach() {
        tree = new BinTree();
    }

    @Test
    void itInvertsZeroNodes() {
        assertNull(tree.invert());
    }

    @Test
    void itInvertsOneNode() {
        tree.root = new Node(0);

        var expected = "(null 0 null)";
        var actual = tree.invert().toString();

        assertEquals(expected, actual);
    }

    @Test
    void itInvertsManyBalancedNodes() {
        var root = new Node(1);
        root.l = new Node(0);
        root.r = new Node(2);

        tree.root = root;

        var expected = "((null 2 null) 1 (null 0 null))";
        var actual = tree.invert().toString();

        assertEquals(expected, actual);
    }

    @Test
    void itInvertsALeftHeavyTree_1() {
        var root = new Node(2);
        root.l = new Node(1);
        root.l.l = new Node(0);

        tree.root = root;

        var expected = "(null 2 (null 1 (null 0 null)))";
        var actual = tree.invert().toString();

        assertEquals(expected, actual);
    }

    @Test
    void itInvertsALeftHeavyTree_2() {
        var root = new Node(2);
        root.l = new Node(0);
        root.l.r = new Node(1);

        tree.root = root;

        var expected = "(null 2 ((null 1 null) 0 null))";
        var actual = tree.invert().toString();

        assertEquals(expected, actual);
    }

    @Test
    void itInvertsARightHeavyTree_1() {
        var root = new Node(0);
        root.r = new Node(2);
        root.r.l = new Node(1);

        tree.root = root;

        var expected = "((null 2 (null 1 null)) 0 null)";
        var actual = tree.invert().toString();

        assertEquals(expected, actual);
    }

    @Test
    void itInvertsARightHeavyTree_2() {
        var root = new Node(0);
        root.r = new Node(1);
        root.r.r = new Node(2);

        tree.root = root;

        var expected = "(((null 2 null) 1 null) 0 null)";
        var actual = tree.invert().toString();

        assertEquals(expected, actual);
    }
}
