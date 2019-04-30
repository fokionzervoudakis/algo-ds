package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// TODO asymptotic analysis
class BinTree {
    Node root;

    int depth(Node n) {
        int d = 0;
        while (n != root) {
            n = n.p;
            d++;
        }
        return d;
    }

    //<editor-fold desc="api">
    int height() {
        return height(root);
    }

    int size() {
        return size(root);
    }

    List<Node> preOrder() {
        return preOrder(root, new ArrayList<>());
    }

    List<Node> inorder() {
        return inorder(root, new ArrayList<>());
    }

    List<Node> postOrder() {
        return postOrder(root, new ArrayList<>());
    }

    List<Node> itPreOrder() {
        return itPreOrder(root);
    }

    Node invert() {
        return invert(root);
    }
    //</editor-fold>

    int height(Node n) {
        // height = O(log n) + 1
        if (n == null) {
            return -1;
        }
        return 1 + Math.max(height(n.l), height(n.r));
    }

    int size(Node n) {
        if (n == null) {
            return 0;
        }
        return 1 + size(n.l) + size(n.r);
    }

    /**
     Asymptotic analysis:
     <ul>
     <li>time_worst=O(n)
     <li>space_avg=O(log n)
     <li>space_worst=O(n)
     </ul>
     */
    List<Node> preOrder(Node n, List<Node> L) {
        if (n != null) {
            L.add(n);
            preOrder(n.l, L);
            preOrder(n.r, L);
        }
        return L;
    }

    List<Node> inorder(Node n, List<Node> L) {
        if (n != null) {
            inorder(n.l, L);
            L.add(n);
            inorder(n.r, L);
        }
        return L;
    }

    List<Node> postOrder(Node n, List<Node> L) {
        if (n != null) {
            postOrder(n.l, L);
            postOrder(n.r, L);
            L.add(n);
        }
        return L;
    }

    List<Node> itPreOrder(Node n1) {
        List<Node> L = new ArrayList<>();
        if (n1 != null) {
            Stack<Node> S = new Stack<>();
            S.push(n1);
            while (!S.isEmpty()) {
                Node n2 = S.pop();
                L.add(n2);
                if (n2.r != null) {
                    S.push(n2.r);
                }
                if (n2.l != null) {
                    S.push(n2.l);
                }
            }
        }
        return L;
    }

    Node invert(Node n) {
        if (n == null) {
            return null;
        }
        Node l = invert(n.l);
        Node r = invert(n.r);
        n.r = l;
        n.l = r;
        return n;
    }

    Node lca(Node n1, Node n2) {
        Stack<Node> S1 = getPath(root, n1), S2 = getPath(root, n2);
        Node lca = null, tmp;
        while (!S1.isEmpty() && !S2.isEmpty()) {
            if ((tmp = S1.pop()).val == S2.pop().val) {
                lca = tmp;
            } else {
                break;
            }
        }
        return lca;
    }

    private Stack<Node> getPath(Node n1, Node n2) {
        Stack<Node> S = new Stack<>();
        if (n1 != null) {
            if (n1.val == n2.val) {
                S.push(n1);
            } else if (!(S = getPath(n1.l, n2)).isEmpty()) {
                S.push(n1);
            } else if (!(S = getPath(n1.r, n2)).isEmpty()) {
                S.push(n1);
            }
        }
        return S;
    }

    static class Node {
        int val;
        Node p, l, r;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "(" + l + " " + val + " " + r + ")";
        }
    }
}
