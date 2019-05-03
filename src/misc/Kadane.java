package misc;

import annotation.dp.Tabulation;

import java.util.Arrays;

class Kadane {
    /**
     Uses Kadane's algorithm to calculate the largest sum of items in a
     contiguous sub-array of {@code A}.

     @param A an array of numbers
     @return the largest sum of items in a contiguous sub-array of {@code A}
     */
    @Tabulation
    int max(int[] A) {
        int lMax = A[0], gMax = lMax;
        for (int i = 1; i < A.length; i++) {
            lMax = Math.max(A[i], A[i] + lMax);
            gMax = Math.max(gMax, lMax);
        }
        return gMax;
    }

    int[] sub(int[] A) {
        int lMax = A[0], gMax = lMax;
        int lStart = 0, gStart = 0, end = 0;
        for (int i = 1; i < A.length; i++) {
            lMax = Math.max(A[i], A[i] + lMax);
            gMax = Math.max(gMax, lMax);
            if (lMax < 0) {
                lStart = i + 1;
            } else if (gMax == lMax) {
                gStart = lStart;
                end = i;
            }
        }
        return Arrays.copyOfRange(A, gStart, end + 1);
    }
}
