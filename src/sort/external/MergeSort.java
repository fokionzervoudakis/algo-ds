package sort.external;

import java.util.Arrays;

class MergeSort<T extends Comparable<T>> {
    T[] sort(T[] A) {
        int n = A.length;
        if (n < 2) {
            return A;
        }
        int mid = n / 2;
        T[] B = Arrays.copyOfRange(A, 0, mid);
        T[] C = Arrays.copyOfRange(A, mid, n);
        return merge(sort(B), sort(C));
    }

    private T[] merge(T[] B, T[] C) {
        int m = B.length, n = C.length;
        T[] A = (T[]) new Comparable[m + n];
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
