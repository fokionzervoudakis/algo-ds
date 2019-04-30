package datastructure;

import annotation.Pattern;
import annotation.Pattern.Type;

/**
 Asymptotic analysis:
 <ul>
 <li>space_avg=O(n)
 <li>insert_agv=O(log n)
 <li>lookup_agv=O(log n)
 <li>delete_avg=O(log n)
 <li>space_worst=O(n)
 <li>insert_worst=O(n)
 <li>lookup_worst=O(n)
 <li>delete_worst=O(n)
 </ul>
 */
class Bst extends BinTree {
    boolean add(int val) {
        return addChild(getLast(val), new Node(val));
    }

    private Node getLast(int val) {
        Node curr = root, prev = null;
        while (curr != null) {
            prev = curr;
            if (val < curr.val) {
                curr = curr.l;
            } else if (val > curr.val) {
                curr = curr.r;
            } else {
                return curr;
            }
        }
        return prev;
    }

    private boolean addChild(Node p, Node n) {
        if (p == null) {
            root = n;
        } else {
            if (n.val < p.val) {
                p.l = n;
            } else if (n.val > p.val) {
                p.r = n;
            } else {
                return false;
            }
            n.p = p;
        }
        return true;
    }

    // TODO node removal

    @Pattern({ Type.GREEDY, Type.DIVIDE_AND_CONQUER })
    boolean isBst() {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBst(Node n, int min, int max) {
        if (n == null) {
            return true;
        } else if (n.val <= min || n.val >= max) {
            return false;
        } else {
            return isBst(n.l, min, n.val) && isBst(n.r, n.val, max);
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
