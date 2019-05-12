package experiment;

import annotation.Bit;

class Bitwise {
    @Bit
    public static void main(String[] args) {
        // Bitwise AND:

        System.out.println("5 & 6 => 0101 & 0111 => " + (5 & 6));

        // Bitwise OR:

        System.out.println("5 | 6 => 0101 | 0111 => " + (5 | 6));

        // Bitwise XOR:

        System.out.println("5 ^ 6 => 0101 ^ 0111 => " + (5 ^ 6));

        // Bitwise NOT:

        // In all cases, ~x equals (-x)-1 (a.k.a. two's complement).
        System.out.println("~5 => ~0101 => " + ~5);
    }
}
