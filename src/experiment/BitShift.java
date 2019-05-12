package experiment;

import annotation.Bit;

class BitShift {
    @Bit
    public static void main(String[] args) {
        // Left shift:

        // The value of n << s is n left-shifted s bit positions.
        // This is equivalent (even if overflow occurs) to multiplication by two to the power s.
        System.out.println("5 << 1 => 0000 0101 << 1 => 0000 1010 = " + (5 << 1)); // multiply by two
        System.out.println("5 << 2 => 0000 0101 << 2 => 0001 0100 = " + (5 << 2)); // multiply by four

        System.out.println();

        // Arithmetic right shift:

        // The value of n >> s is n right-shifted s bit positions with sign-extension.

        // For non-negative values of n, this is equivalent to truncating integer division by two to the power s.
        System.out.println(" 5  >> 1 => 0101 >> 1 => 0010 = " + (5 >> 1)); // divide by two
        System.out.println(" 5  >> 2 => 0101 >> 2 => 0001 = " + (5 >> 2)); // divide by four

        System.out.println("-5  >> 1 => 1011 >> 1 => 1101 = " + (-5 >> 1));
        System.out.println("-5L >> 1 => 1011 >> 1 => 1101 = " + (-5L >> 1));

        System.out.println();

        // Logical right shift:

        // The value of n >>> s is n right-shifted s bit positions with zero-extension, where:

        // If n is positive, then the result is the same as that of n >> s.
        System.out.println(" 5  >>> 1 => 0101 >>> 1 => 0010 = " + (5 >>> 1)); // divide by two
        System.out.println(" 5  >>> 2 => 0101 >>> 2 => 0001 = " + (5 >>> 2)); // divide by four

        // If n is negative and the type of the left-hand operand is int,
        // then the result is equal to that of the expression (n >> s) + (2 << ~s).
        System.out.println("-5  >>> 1 = " + (-5 >>> 1));

        // If n is negative and the type of the left-hand operand is long,
        // then the result is equal to that of the expression (n >> s) + (2L << ~s).
        System.out.println("-5L >>> 1 = " + (-5L >>> 1));
    }
}
