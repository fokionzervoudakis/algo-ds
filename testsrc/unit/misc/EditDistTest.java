package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditDistTest {
    private EditDist dist;

    @BeforeEach
    void beforeEach() {
        dist = new EditDist();
    }

    @Test
    void itCalculatesTheEditDistanceWhenTheFirstCharacterStringIsEmpty() {
        assertEquals(0, dist.editDist(new char[0], new char[0]));
    }

    @Test
    void itCalculatesTheEditDistanceWhenTheSecondCharacterStringIsEmpty() {
        assertEquals(1, dist.editDist(new char[] { 'a' }, new char[0]));
    }

    @Test
    void itCalculatesTheEditDistanceWithEquivalentCharacterStrings() {
        //       a
        //    0, 1
        // a: 1, 0
        assertEquals(0, dist.editDist(new char[] { 'a' }, new char[] { 'a' }));
    }

    @Test
    void itCalculatesTheEditDistanceWithOneDifference() {
        //       a, b
        //    0, 1, 2
        // a: 1, 0, 1
        assertEquals(1, dist.editDist(new char[] { 'a' }, new char[] { 'a', 'b' }));
    }

    @Test
    void itCalculatesTheEditDistanceWithTwoDifferences() {
        //       a, b
        //    0, 1, 2
        // c: 1, 1, 2
        // d: 2, 2, 2
        assertEquals(2, dist.editDist(new char[] { 'a', 'b' }, new char[] { 'c', 'd' }));
    }

    @Test
    void itCalculatesTheEditDistanceWithManyDifferences() {
        //       s, u, n, d, a, y
        //    0, 1, 2, 3, 4, 5, 6
        // s: 1, 0, 1, 2, 3, 4, 5
        // a: 2, 1, 1, 2, 3, 3, 4
        // t: 3, 2, 2, 2, 3, 4, 4
        // u: 4, 3, 2, 3, 3, 4, 5
        // r: 5, 4, 3, 3, 4, 4, 5
        // d: 6, 5, 4, 4, 3, 4, 5
        // a: 7, 6, 5, 5, 4, 3, 4
        // y: 8, 7, 6, 6, 5, 4, 3
        assertEquals(3, dist.editDist("saturday".toCharArray(), "sunday".toCharArray()));
    }
}
