package misc;

import search.BinSearch;

class DpLis {
    /**
     Uses binary search to find a longest increasing sub-sequence for a given
     array. The sub-sequence does not have to be contiguous or unique.
     <p>For the first 16 terms of the binary van der Corput sequence: 0, 8, 4,
     12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15
     <p>one longest increasing sub-sequence is: 0, 2, 6, 9, 11, 15
     <p>Other increasing sub-sequences with length six are also available.
     <p>Asymptotic analysis:
     <ul>
     <li>time_worst=O(n log n)
     <li>space_worst=O(n)
     </ul>

     @param A an array of integers
     @return the length of the longest increasing sub-sequence in {@code A}
     */
    int len(int[] A) {
        int[] B = new int[A.length];
        int len = 0;
        for (int n : A) {
            int i = BinSearch.it(B, 0, len - 1, n);
            if (i < 0) {
                i = -(i + 1);
            }
            B[i] = n;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
