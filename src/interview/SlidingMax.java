package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SlidingMax {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_avg=O(n) with uniformly distributed data
     <li>time_worst=O(nk) with pathologically distributed data
     <li>space_worst=O(k)
     </ul>

     @param A an array of integers
     @param k a number where where {@code 1 <= k <= A.length}
     @return the maximum values of each sub-array of length {@code k}
     */
    List<Integer> getMax(int[] A, int k) {
        var L = new ArrayList<Integer>();
        var Q = new LinkedList<Integer>();
        for (var i = 0; i < A.length; i++) {
            if ((!Q.isEmpty()) && Q.peekFirst() <= i - k) {
                Q.removeFirst();
            }
            while (!Q.isEmpty() && A[i] >= A[Q.peekLast()]) {
                Q.removeLast();
            }
            Q.addLast(i);
            if (i >= k - 1) {
                L.add(A[Q.getFirst()]);
            }
        }
        return L;
    }
}
