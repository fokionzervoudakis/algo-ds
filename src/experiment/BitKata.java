package experiment;

import annotation.Bit;

@Bit
class BitKata {
    /**
     Uses left shifts to check if {@code n}'s {@code k}th bit is set.

     @param n an integer
     @param k a bit position
     @return true if {@code n}'s {@code k}th bit is set, else false
     */
    static boolean isKthBitSetL(int n, int k) {
        var x = 1 << (k - 1);
        return (n & x) != 0;
    }

    /**
     Uses right shifts to check if {@code n}'s {@code k}th bit is set.

     @param n an integer
     @param k a bit position
     @return true if {@code n}'s {@code k}th bit is set, else false
     */
    static boolean isKthBitSetR(int n, int k) {
        var x = n >> (k - 1);
        return (x & 1) != 0;
    }

    /**
     Uses left shifts to check if the high-order bit of a 128-bit (signed) byte
     is set.

     @param n an integer representation of a 128-bit (signed) byte
     @return true if {@code n}'s high-order bit is set, else false
     */
    static boolean isHighestBitSetL(int n) {
        return isKthBitSetL(n, 8);
    }

    /**
     Uses right shifts to count the number of bits in {@code n}.

     @param n an integer
     @return the number of bits in {@code n}
     */
    static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            n >>= 1;
            count++;
        }
        return count;
    }

    /**
     Uses left shifts to count the number of set bits (also known as the Hamming
     weight) in an unsigned integer.

     @param n an unsigned integer
     @return the number of set bits (i.e. the Hamming weight) in {@code n}
     */
    static int countSetBits(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            var x = 1 << i;
            if ((n & x) == x) {
                count++;
            }
        }
        return count;
    }

    /**
     Uses left shifts to count the number of corresponding bits that are
     different (also known as the Hamming distance) between two unsigned
     integers.

     @param a an unsigned integer
     @param b another unsigned integer
     @return the number of corresponding bits that are different (i.e. the
     Hamming distance) between {@code a} and {@code b}
     */
    static int countDiffBits(int a, int b) {
        int c = a ^ b;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int x = 1 << i;
            if ((c & x) == x) {
                count++;
            }
        }
        return count;
    }
}
