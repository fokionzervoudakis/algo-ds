package experiment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BitKataTest {
    @Test
    void itReturnsTrueIfTheKthBitIsSet() {
        // 5 => 0101
        assertTrue(BitKata.isKthBitSetL(5, 1));
        assertTrue(BitKata.isKthBitSetL(5, 3));
        assertTrue(BitKata.isKthBitSetR(5, 1));
        assertTrue(BitKata.isKthBitSetR(5, 3));
    }

    @Test
    void itReturnsFalseIfTheKthBitIsNotSet() {
        // 5 => 0101
        assertFalse(BitKata.isKthBitSetL(5, 2));
        assertFalse(BitKata.isKthBitSetL(5, 4));
        assertFalse(BitKata.isKthBitSetR(5, 2));
        assertFalse(BitKata.isKthBitSetR(5, 4));
    }

    @Test
    void itReturnsTrueIfTheHighestBitInASignedByteIsSet() {
        assertTrue(BitKata.isHighestBitSetL(128)); // 1000 0000
    }

    @Test
    void itReturnsFalseIfTheHighestBitInASignedByteIsNotSet() {
        assertFalse(BitKata.isHighestBitSetL(127)); // 0111 1111
    }

    @Test
    void itCountsTheNumberOfBits() {
        assertEquals(0, BitKata.countBits(0)); // 0000
        assertEquals(1, BitKata.countBits(1)); // 0001
        assertEquals(2, BitKata.countBits(3)); // 0011
        assertEquals(3, BitKata.countBits(7)); // 0111
        assertEquals(4, BitKata.countBits(11)); // 1011
        assertEquals(8, BitKata.countBits(128)); // 1000 0000
    }

    @Test
    void itCountsTheNumberOfSetBits() {
        assertEquals(0, BitKata.countSetBits(0)); // 0000
        assertEquals(1, BitKata.countSetBits(1)); // 0001
        assertEquals(2, BitKata.countSetBits(3)); // 0011
        assertEquals(3, BitKata.countSetBits(7)); // 0111
        assertEquals(3, BitKata.countSetBits(11)); // 1011
        assertEquals(1, BitKata.countSetBits(128)); // 1000 0000
    }

    @Test
    void itCountsTheNumberOfDifferentBits() {
        assertEquals(0, BitKata.countDiffBits(0, 0)); // 0000 ^ 0000
        assertEquals(1, BitKata.countDiffBits(0, 1)); // 0000 ^ 0001
        assertEquals(1, BitKata.countDiffBits(1, 3)); // 0001 ^ 0011
        assertEquals(2, BitKata.countDiffBits(1, 7)); // 0001 ^ 0111
        assertEquals(2, BitKata.countDiffBits(1, 11)); // 0001 ^ 1011
        assertEquals(2, BitKata.countDiffBits(1, 128)); // 0001 ^ 1000 0000
    }
}
