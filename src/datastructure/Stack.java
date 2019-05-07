package datastructure;

import java.util.Arrays;

/**
 A <em>last in, first out</em> (LIFO) data structure.
 <ul>
 <li>space_worst=O(n)
 <li>push_worst=O(1)
 <li>pop_worst=O(1)
 <li>peek_worst=O(1)
 </ul>
 */
class Stack<T> {
    // Set the default initial capacity to five (for no particular reason).
    T[] A = (T[]) new Object[5];

    int top = 0;

    void push(T t) {
        if (top + 1 > A.length) {
            resize();
        }
        A[top++] = t;
    }

    T pop() {
        T t = A[--top];
        if (A.length >= top * 3) {
            resize();
        }
        return t;
    }

    private void resize() {
        T[] B = (T[]) new Object[Math.max(top * 2, 1)];
        System.arraycopy(A, 0, B, 0, top);
        A = B;
    }

    @Override
    public String toString() {
        return Arrays.toString(A);
    }
}
