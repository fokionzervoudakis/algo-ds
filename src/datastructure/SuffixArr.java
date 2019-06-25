package datastructure;

import java.util.Arrays;

/**
 https://algs4.cs.princeton.edu/63suffix/SuffixArray.java.html
 <p>https://algs4.cs.princeton.edu/63suffix/SuffixArrayX.java.html
 */
public class SuffixArr {
    String str;

    Suffix[] A;

    public SuffixArr(String str) {
        this.str = str;
        this.A = new Suffix[str.length()];
        for (int i = 0; i < str.length(); i++) {
            A[i] = new Suffix(i);
        }
        Arrays.sort(A); // O(n^2 log n)
    }

    public int lcp(int i) {
        Suffix s1 = A[i], s2 = A[i - 1];
        int n = Math.min(s1.length(), s2.length());
        for (int j = 0; j < n; j++) {
            if (s1.charAt(j) != s2.charAt(j)) {
                return j;
            }
        }
        return n;
    }

    public int index(int i) {
        return A[i].index;
    }

    @Override
    public String toString() {
        return Arrays.toString(A);
    }

    class Suffix implements Comparable<Suffix> {
        int index;

        Suffix(int index) {
            this.index = index;
        }

        int length() {
            return str.length() - index;
        }

        char charAt(int i) {
            return str.charAt(index + i);
        }

        @Override
        public int compareTo(Suffix o) {
            int n = Math.min(this.length(), o.length());
            for (int i = 0; i < n; i++) {
                if (this.charAt(i) < o.charAt(i)) {
                    return -1;
                } else if (this.charAt(i) > o.charAt(i)) {
                    return 1;
                }
            }
            return this.length() - o.length();
        }

        @Override
        public String toString() {
            return str.substring(index);
        }
    }
}
