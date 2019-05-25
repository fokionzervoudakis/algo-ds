package misc;

import search.BinSearch;

class DpLis {
    /**
     Asymptotic analysis:
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
