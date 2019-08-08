package datastructure;

/**
 Note: randomly built binary search trees tend to be balanced.
 <p>https://opendatastructures.org/ods-java/7_2_Treap_Randomized_Binary.html
 <p>Asymptotic analysis:
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

    private boolean addChild(Node P, Node N) {
        if (P == null) {
            root = N;
        } else {
            if (N.val < P.val) {
                P.l = N;
            } else if (N.val > P.val) {
                P.r = N;
            } else {
                return false;
            }
            N.p = P;
        }
        return true;
    }

    private Node getLast(int val) {
        Node prev = null, curr = root;
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

    boolean isBst() {
        return isBst(root, null, null);
    }

    private boolean isBst(Node N, Integer min, Integer max) {
        if (N == null) {
            return true;
        } else if (min != null && N.val <= min) {
            return false;
        } else if (max != null && N.val >= max) {
            return false;
        } else {
            return isBst(N.l, min, N.val) && isBst(N.r, N.val, max);
        }
    }

    void remove(Node N) {
        // TODO
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
