package datastructure;

/**
 Asymptotic analysis:
 <ul>
 <li>space_worst=O(n)
 <li>prepend_worst=O(1)
 <li>append_worst=O(1)
 <li>lookup_worst=O(n)
 <li>insert_worst=O(n)
 <li>delete_worst=O(n)
 </ul>
 */
class SLList<T> {
    Node<T> head;
    Node<T> tail;

    int len = 0;

    class Stack {
        void push(T t) {
            Node<T> n = new Node<>(t);
            n.next = head;
            head = n;
            if (len == 0) {
                tail = n;
            }
            len++;
        }

        T pop() {
            if (len == 0) {
                return null;
            }
            T t = head.t;
            head = head.next;
            if (--len == 0) {
                tail = null;
            }
            return t;
        }

        @Override
        public String toString() {
            return head.toString();
        }
    }

    class Queue {
        void add(T t) {
            Node<T> n = new Node<>(t);
            if (len == 0) {
                head = n;
            } else {
                tail.next = n;
            }
            tail = n;
            len++;
        }

        T remove() {
            if (len == 0) {
                return null;
            }
            T t = head.t;
            head = head.next;
            if (--len == 0) {
                tail = null;
            }
            return t;
        }

        @Override
        public String toString() {
            return head.toString();
        }
    }

    static Node floyd(Node N) {
        Node T, H;
        try {
            T = N.next;
            H = N.next.next;
            while (T != H) {
                T = T.next;
                H = H.next.next;
            }
        } catch (Exception e) {
            return null;
        }
        T = N;
        while (T != H) {
            T = T.next;
            H = H.next;
        }
        return T;
    }

    static class Node<T> {
        T t;
        Node<T> next;

        Node(T t) {
            this.t = t;
        }

        @Override
        public String toString() {
            return "[" + t + "] -> " + next;
        }
    }
}
