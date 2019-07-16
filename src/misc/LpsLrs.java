package misc;

import datastructure.SuffixArr;

class LpsLrs {
    /**
     Uses a suffix array to find the longest palindromic substring of a given
     string.
     <ul>
     <li>time_worst=O(n^2 log n)
     <li>space_worst=O(n)
     </ul>

     @param str the target string
     @return the longest palindromic substring in {@code str}
     */
    String lps(String str) {
        String s2 = str + '#' + reverse(str);
        SuffixArr arr = new SuffixArr(s2);
        String lps = "";
        int lcp = 0;
        for (int i = 0; i < s2.length(); i++) {
            int j = arr.indexAt(i);
            int even = s2.length() - j, odd = even + 1;
            if (even < s2.length()) {
                int n = arr.lcpLength(arr.suffixAt(j), arr.suffixAt(even));
                if (n > lcp) {
                    int min = Math.min(j, even);
                    lps = str.substring(min - n, min + n);
                    lcp = n;
                }
            }
            if (odd < s2.length() && j != odd) {
                int n = arr.lcpLength(arr.suffixAt(j), arr.suffixAt(odd));
                if (n > lcp) {
                    int min = Math.min(j, odd);
                    lps = str.substring(min - n - 1, min + n);
                    lcp = n;
                }
            }
        }
        return lps;
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    /**
     Uses a suffix array to find the longest repeated substring of a given
     string.
     <ul>
     <li>time_worst=O(n^2 log n)
     <li>space_worst=O(n)
     </ul>

     @param str the target string
     @return the longest repeated substring in {@code str}
     */
    String lrs(String str) {
        SuffixArr arr = new SuffixArr(str);
        String lrs = "";
        for (int i = 1; i < str.length(); i++) {
            int n = arr.lcpLength(i);
            if (n > lrs.length()) {
                int j = arr.indexAt(i);
                lrs = str.substring(j, j + n);
            }
        }
        return lrs;
    }
}
