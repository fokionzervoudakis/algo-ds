package datastructure;

import java.util.Arrays;

/**
 https://algs4.cs.princeton.edu/63suffix/SuffixArray.java.html
 <p>https://algs4.cs.princeton.edu/63suffix/SuffixArrayX.java.html
 */
public class SuffixArr {
    String str;

    Suffix[] A, B;

    public SuffixArr(String str) {
        this.str = str;
        A = new Suffix[str.length()];
        for (int i = 0; i < str.length(); i++) {
            A[i] = new Suffix(i);
        }
        B = A.clone();
        Arrays.sort(B);
    }

    public int lcpLength(int i) {
        return lcpLength(B[i], B[i - 1]);
    }

    public int lcpLength(Suffix S1, Suffix S2) {
        int n = Math.min(S1.length(), S2.length());
        for (int i = 0; i < n; i++) {
            if (S1.charAt(i) != S2.charAt(i)) {
                return i;
            }
        }
        return n;
    }

    public int indexAt(int i) {
        return B[i].index;
    }

    public Suffix suffixAt(int i) {
        return A[i];
    }

    @Override
    public String toString() {
        return Arrays.toString(A) + ',' + Arrays.toString(B);
    }

    public class Suffix implements Comparable<Suffix> {
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
            return str.substring(index) + ":" + index;
        }
    }
}
