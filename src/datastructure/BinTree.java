package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Asymptotic analysis:
 <ul>

 <li>depth_time_avg=O(log n)
 <li>depth_time_worst=O(n)

 <li>height_time_worst=O(n)

 <li>size_time_worst=O(n)

 <li>preOrder_time_worst=O(n)
 <li>inorder_time_worst=O(n)
 <li>postOrder_time_worst=O(n)

 <li>itPreOrder_time_worst=O(n)

 <li>invert_time_worst=O(n)

 <li>lca_time_worst=O(n)

 <li>space_avg=O(log n)
 <li>space_worst=O(n)s

 </ul>
 */
class BinTree {
    Node root;

    /**
     Asymptotic analysis:
     <ul>
     <li>time_avg=O(log n)
     <li>time_worst=O(n)
     <li>space_worst=O(1)
     </ul>
     */
    int depth(Node N) {
        int d = 0;
        while (N != root) {
            N = N.p;
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

    int height(Node N) {
        // height = O(log n) + 1
        if (N == null) {
            return -1;
        }
        return 1 + Math.max(height(N.l), height(N.r));
    }

    int size(Node N) {
        if (N == null) {
            return 0;
        }
        return 1 + size(N.l) + size(N.r);
    }

    List<Node> preOrder(Node N, List<Node> L) {
        if (N != null) {
            L.add(N);
            preOrder(N.l, L);
            preOrder(N.r, L);
        }
        return L;
    }

    List<Node> inorder(Node N, List<Node> L) {
        if (N != null) {
            inorder(N.l, L);
            L.add(N);
            inorder(N.r, L);
        }
        return L;
    }

    List<Node> postOrder(Node N, List<Node> L) {
        if (N != null) {
            postOrder(N.l, L);
            postOrder(N.r, L);
            L.add(N);
        }
        return L;
    }

    List<Node> itPreOrder(Node N1) {
        List<Node> L = new ArrayList<>();
        if (N1 != null) {
            Stack<Node> S = new Stack<>();
            S.push(N1);
            while (!S.isEmpty()) {
                Node N2 = S.pop();
                L.add(N2);
                if (N2.r != null) {
                    S.push(N2.r);
                }
                if (N2.l != null) {
                    S.push(N2.l);
                }
            }
        }
        return L;
    }

    Node invert(Node N) {
        if (N == null) {
            return null;
        }
        Node l = invert(N.l);
        Node r = invert(N.r);
        N.r = l;
        N.l = r;
        return N;
    }

    Node lca(Node N1, Node N2) {
        Stack<Node> S1 = getPath(root, N1), S2 = getPath(root, N2);
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

    private Stack<Node> getPath(Node N1, Node N2) {
        Stack<Node> S = new Stack<>();
        if (N1 != null) {
            if (N1.val == N2.val) {
                S.push(N1);
            } else if (!(S = getPath(N1.l, N2)).isEmpty()) {
                S.push(N1);
            } else if (!(S = getPath(N1.r, N2)).isEmpty()) {
                S.push(N1);
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
