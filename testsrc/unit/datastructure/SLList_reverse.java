package datastructure;

import datastructure.SLList.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SLList_reverse {
    @Test
    void itReversesOneNode() {
        var expected = "[1] -> null";
        var actual = SLList.reverse(new Node<>(1)).toString();
        assertEquals(expected, actual);
    }

    @Test
    void itReversesTwoNodes() {
        var N = new Node<>(1);
        append(N, 2);
        var expected = "[2] -> [1] -> null";
        var actual = SLList.reverse(N).toString();
        assertEquals(expected, actual);
    }

    @Test
    void itReversesManyNodes() {
        var N = new Node<>(1);
        append(N, 2);
        append(N, 3);
        append(N, 4);
        append(N, 5);
        append(N, 6);
        var expected = "[6] -> [5] -> [4] -> [3] -> [2] -> [1] -> null";
        var actual = SLList.reverse(N).toString();
        assertEquals(expected, actual);
    }

    private void append(Node<Integer> N, int val) {
        while (N.next != null) {
            N = N.next;
        }
        N.next = new Node<>(val);
    }
}
