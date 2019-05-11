package datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 Asymptotic analysis:
 <ul>
 <li>space_worst=O(nk), where {@code n} is the number of nodes in the tree and
 {@code k} is the number of characters in a string
 <li>insert_worst=O(k)
 <li>lookup_worst=O(k)
 </ul>
 <p>
 The total number of nodes in a tree with {@code l} layers and {@code n} nodes
 per layer is O(n^l).
 <p>
 https://www.interviewcake.com/question/java/compress-url-list
 */
class Trie {
    Node root = new Node();

    void insert(String str) {
        Node N = root;
        for (char c : str.toCharArray()) {
            if (!N.contains(c)) {
                N.put(c, new Node());
            }
            N = N.get(c);
        }
        N.val = str;
    }

    Node lookup(String str) {
        Node N = root;
        for (char c : str.toCharArray()) {
            if (N.contains(c)) {
                N = N.get(c);
            } else {
                return null;
            }
        }
        return N;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    static class Node {
        Map<Character, Node> children = new LinkedHashMap<>(); // Order for test determinism.

        String val;

        boolean contains(char c) {
            return children.containsKey(c);
        }

        void put(char c, Node N) {
            children.put(c, N);
        }

        Node get(char c) {
            return children.get(c);
        }

        @Override
        public String toString() {
            return val + ":" + children;
        }
    }
}
