package math;

import annotation.Math;

class Pow {
    /**
     Uses exponentiation by squaring to calculate the value of {@code a} raised
     to the power of {@code b}.
     <p>Asymptotic analysis:
     <ul>
     <li>time_worst=O(log n)
     <li>space_worst=O(1)
     </ul>

     @param a the base
     @param b the exponent
     @return the value of {@code a} raised to the power of {@code b}
     */
    @Math
    // TODO test
    static int rec(int a, int b) {
        if (b < 0) return rec(1 / a, -b);
        else if (b == 0) return 1;
        else if (b == 1) return a;
        else if (b % 2 == 0) return rec(a * a, b / 2);
        else return a * rec(a * a, (b - 1) / 2);
    }
}
