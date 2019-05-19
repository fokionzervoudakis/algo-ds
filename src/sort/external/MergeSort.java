package sort.external;

import java.util.Arrays;

class MergeSort {
    static String[] sort(String[] A) {
        var n = A.length;
        if (n < 2) {
            return A;
        }
        var m = n / 2;
        var B = Arrays.copyOfRange(A, 0, m);
        var C = Arrays.copyOfRange(A, m, n);
        return merge(sort(B), sort(C));
    }

    private static String[] merge(String[] B, String[] C) {
        int m = B.length, n = C.length;
        var A = new String[m + n];
        int i = 0, j = 0, k = 0;
        while (j < m && k < n) {
            A[i++] = (B[j].compareTo(C[k]) < 0) ? B[j++] : C[k++];
        }
        while (j < m) {
            A[i++] = B[j++];
        }
        while (k < n) {
            A[i++] = C[k++];
        }
        return A;
    }
}
