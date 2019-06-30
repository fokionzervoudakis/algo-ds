package interview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class SlidingWin {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_avg=O(n) with uniformly distributed data
     <li>time_worst=O(nk) with pathologically distributed data
     <li>space_worst=O(k)
     </ul>

     @param A an array of integers
     @param k a number where {@code 1 <= k <= A.length}
     @return the min value in each {@code k}-length sub-array of {@code A}
     */
    List<Integer> min(int[] A, int k) {
        Deque<Integer> D = new LinkedList<>();
        List<Integer> L = new ArrayList<>();
        // Handle the first window.
        for (int i = 0; i < k; i++) {
            // Remove from the end of the dequeue indexes of elements larger than the current element...
            while (!D.isEmpty() && A[D.peekLast()] > A[i]) {
                D.removeLast();
            }
            // and add the index of the current element.
            D.addLast(i);
        }
        // The first element is the min element of the first window.
        L.add(A[D.peekFirst()]);
        // Handle all remaining windows.
        for (int i = k; i < A.length; i++) {
            // Remove from the start of the dequeue indexes that are outside the current window.
            while (!D.isEmpty() && D.peekFirst() <= i - k) {
                D.removeFirst();
            }
            // Remove from the end of the dequeue indexes of elements larger than the current element...
            while (!D.isEmpty() && A[D.peekLast()] > A[i]) {
                D.removeLast();
            }
            // and add the index of the current element.
            D.addLast(i);
            // The first element is the min element of the current window.
            L.add(A[D.peekFirst()]);
        }
        return L;
    }

    /**
     Asymptotic analysis:
     <ul>
     <li>time_avg=O(n) with uniformly distributed data
     <li>time_worst=O(nk) with pathologically distributed data
     <li>space_worst=O(k)
     </ul>

     @param A an array of integers
     @param k a number where {@code 1 <= k <= A.length}
     @return the max value in each {@code k}-length sub-array of {@code A}
     */
    List<Integer> max(int[] A, int k) {
        Deque<Integer> D = new LinkedList<>();
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            while (!D.isEmpty() && A[i] > A[D.peekLast()]) {
                D.removeLast();
            }
            D.addLast(i);
        }
        L.add(A[D.peekFirst()]);
        for (int i = k; i < A.length; i++) {
            while (!D.isEmpty() && D.peekFirst() <= i - k) {
                D.removeFirst();
            }
            while (!D.isEmpty() && A[i] > A[D.peekLast()]) {
                D.removeLast();
            }
            D.addLast(i);
            L.add(A[D.peekFirst()]);
        }
        return L;
    }
}
