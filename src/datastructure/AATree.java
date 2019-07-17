package datastructure;

/**
 Asymptotic analysis:
 <ul>
 <li>space_worst=O(n)
 <li>insert_worst=O(log n)
 <li>lookup_worst=O(log n)
 <li>delete_worst=O(log n)
 </ul>
 */
class AATree {
    Node root;

    void add(int val) {
        root = add(root, val);
    }

    private Node add(Node n, int val) {
        if (n == null) {
            return new Node(val);
        } else if (val < n.val) {
            n.l = add(n.l, val);
        } else if (val > n.val) {
            n.r = add(n.r, val);
        }
        return split(skew(n));
    }

    private Node skew(Node n) {
        if (n == null) {
            return null;
        } else if (n.l == null) {
            return n;
        } else if (n.level == n.l.level) {
            // https://en.wikipedia.org/wiki/File:AA_Tree_Skew2.svg
            Node l = n.l;
            n.l = l.r;
            l.r = n;
            return l;
        } else {
            return n;
        }
    }

    private Node split(Node n) {
        if (n == null) {
            return null;
        } else if (n.r == null || n.r.r == null) {
            return n;
        } else if (n.level == n.r.r.level) {
            // https://en.wikipedia.org/wiki/File:AA_Tree_Split2.svg
            Node r = n.r;
            n.r = r.l;
            r.l = n;
            r.level++;
            return r;
        } else {
            return n;
        }
    }

    void remove(Node N) {
        // TODO
    }

    @Override
    public String toString() {
        return root.toString();
    }

    static class Node {
        int val, level = 1;
        Node l, r;

        private Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "(" + l + " " + val + ":" + level + " " + r + ")";
        }
    }
}
