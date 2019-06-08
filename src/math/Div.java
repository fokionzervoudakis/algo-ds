package math;

import annotation.Math;

class Div {
    /**
     Uses repeated subtraction to calculate the quotient of Euclidean division.

     @param a the dividend
     @param b the divisor
     @return the quotient of {@code a / b}
     */
    @Math
    int quo(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        int q = 0;
        while (a >= b) {
            a -= b;
            q++;
        }
        return q;
    }

    /**
     Uses repeated subtraction to calculate the remainder of Euclidean division.

     @param a the dividend
     @param b the divisor
     @return the remainder of {@code a / b}
     */
    @Math
    int rem(int a, int b) {
        if (b == 0) throw new ArithmeticException();
        while (a >= b) {
            a -= b;
        }
        return a;
    }
}
