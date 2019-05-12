package search;

import annotation.Bit;

/**
 {@link java.util.Arrays#binarySearch(int[], int)}
 */
class BinSearch {
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
    @Bit
    int it(int[] A, int n) {
        int l = 0, r = A.length - 1;
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
        return -l;
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
        return rec(A, n, 0, A.length - 1);
    }

    @Bit
    private int rec(int[] A, int n, int l, int r) {
        if (l > r) {
            return -l;
        }
        int m = (l + r) >>> 1;
        if (A[m] < n) {
            return rec(A, n, m + 1, r);
        } else if (A[m] > n) {
            return rec(A, n, l, m - 1);
        } else {
            return m;
        }
    }
}
