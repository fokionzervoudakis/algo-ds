package datastructure;

import datastructure.BinTree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BstTest_isBst_2 {
    private Bst bst;

    @BeforeEach
    void beforeEach() {
        bst = new Bst();
    }

    @Test
    void itReturnsTrueWhenTheTreeHasOneNodeWithASmallValue() {
        bst.root = new Node(Integer.MIN_VALUE);
        assertTrue(bst.isBst());
    }

    @Test
    void itReturnsTrueWhenTheTreeHasOneNodeWithALargeValue() {
        bst.root = new Node(Integer.MAX_VALUE);
        assertTrue(bst.isBst());
    }
}
