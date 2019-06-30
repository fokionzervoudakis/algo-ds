package misc;

import datastructure.SuffixArr;

class Lrs {
    /**
     Uses a suffix array to find the longest repeated substring of a given
     string.
     <p>Asymptotic analysis:
     <ul>
     <li>time_worst=O(n^2 log n)
     <li>space_worst=O(n)
     </ul>

     @param str the target string
     @return the longest repeated substring in {@code str}
     */
    String max(String str) {
        // O(n^2 log n)
        SuffixArr arr = new SuffixArr(str);
        String lrs = "";
        for (int i = 1; i < str.length(); i++) {
            int n = arr.lcpLength(i);
            if (n > lrs.length()) {
                int j = arr.index(i);
                lrs = str.substring(j, j + n);
            }
        }
        return lrs;
    }
}
