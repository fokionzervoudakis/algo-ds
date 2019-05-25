package search;

import annotation.Bit;

/**
 {@link java.util.Arrays#binarySearch(int[], int)}
 */
public class BinSearch {
    /**
     Searches the specified array for the specified element using the binary
     search algorithm.
     <p>Signed integer addition can cause an overflow if the array size is
     greater than half the maximum integer value. But the unsigned representation
     of the sum is correct regardless of overflow. The logical right shift is
     therefore used to divide the unsigned number and derive the correct mean.
     <p>Asymptotic analysis:
     <ul>
     <li>time_best=O(1)
     <li>time_avg=O(log n)
     <li>time_worst=O(log n)
     <li>space_worst=O(1)
     </ul>

     @param A the array to be searched
     @param n the element to be searched for
     @return the index of {@code n} in {@code A}, if {@code n} is in {@code A},
     else <code>(-(<i>insertion point</i>) - 1)</code>
     */
    int it(int[] A, int n) {
        return it(A, 0, A.length - 1, n);
    }

    @Bit
    public static int it(int[] A, int l, int r, int n) {
        while (r >= l) {
            int m = (l + r) >>> 1;
            if (A[m] < n) {
                l = m + 1;
            } else if (A[m] > n) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -(l + 1);
    }

    /**
     Searches the specified array for the specified element using the binary
     search algorithm.
     <p>Asymptotic analysis:
     <ul>
     <li>time_best=O(1)
     <li>time_avg=O(log n)
     <li>time_worst=O(log n)
     <li>space_best=O(1)
     <li>space_avg=O(log n)
     <li>space_worst=O(log n)
     </ul>

     @param A the array to be searched
     @param n the element to be searched for
     @return the index of {@code n} in {@code A}, if {@code n} is in {@code A},
     else <code>(-(<i>insertion point</i>) - 1)</code>
     */
    int rec(int[] A, int n) {
        return rec(A, 0, A.length - 1, n);
    }

    @Bit
    private int rec(int[] A, int l, int r, int n) {
        if (l > r) {
            return -(l + 1);
        }
        int m = (l + r) >>> 1;
        if (A[m] < n) {
            return rec(A, m + 1, r, n);
        } else if (A[m] > n) {
            return rec(A, l, m - 1, n);
        } else {
            return m;
        }
    }
}
