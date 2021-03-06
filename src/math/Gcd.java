package math;

import annotation.Math;

@Math
class Gcd {
    /**
     Uses an iterative implementation of Euclid's algorithm to calculate the
     greatest common divisor of two integers.

     @param a a number
     @param b another number
     @return the greatest common divisor of {@code a} and {@code b}
     */
    int it(int a, int b) {
        int n;
        while (b != 0) {
            n = b;
            b = a % b;
            a = n;
        }
        return a;
    }

    /**
     Uses a recursive implementation of Euclid's algorithm to calculate the
     greatest common divisor of two integers.

     @param a a number
     @param b another number
     @return the greatest common divisor of {@code a} and {@code b}
     */
    int rec(int a, int b) {
        return (b == 0) ? a : rec(b, a % b);
    }

    int multiRec(int[] A) {
        int n = A[0];
        for (int i = 1; i < A.length; i++) {
            n = rec(A[i], n);
        }
        return n;
    }
}
