package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BoyerMTest {
    private BoyerM boyerM;

    @BeforeEach
    void beforeEach() {
        boyerM = new BoyerM();
    }

    @Test
    void itReturnsNullWithZeroElements() {
        assertNull(boyerM.majorityVote(new int[0]));
    }

    @Test
    void itReturnsTheMajorityElementWithOneElement() {
        assertEquals(1, boyerM.majorityVote(new int[] { 1 }).intValue());
    }

    @Test
    void itReturnsTheMajorityElementWithManyDuplicateElements() {
        assertEquals(1, boyerM.majorityVote(new int[] { 1, 1 }).intValue());
    }

    @Test
    void itReturnsTheMajorityElementWithManyUniqueAndDuplicateElements() {
        assertEquals(1, boyerM.majorityVote(new int[] { 1, 1, 2 }).intValue());
        assertEquals(2, boyerM.majorityVote(new int[] { 1, 2, 2 }).intValue());
    }

    @Test
    void itReturnsTheLastElementWhenAMajorityElementDoesNotExist() {
        assertEquals(3, boyerM.majorityVote(new int[] { 1, 2, 3 }).intValue());
    }
}
