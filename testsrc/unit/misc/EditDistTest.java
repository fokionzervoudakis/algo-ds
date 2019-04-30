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
        assertEquals(0, dist.editDist(new char[] { 'a' }, new char[] { 'a' }));
    }

    @Test
    void itCalculatesTheEditDistanceWithOneDifference() {
        assertEquals(1, dist.editDist(new char[] { 'a' }, new char[] { 'a', 'b' }));
    }

    @Test
    void itCalculatesTheEditDistanceWithTwoDifferences() {
        assertEquals(2, dist.editDist(new char[] { 'a', 'b' }, new char[] { 'c', 'd' }));
    }

    @Test
    void itCalculatesTheEditDistanceWithManyDifferences() {
        assertEquals(3, dist.editDist("saturday".toCharArray(), "sunday".toCharArray()));
    }
}
