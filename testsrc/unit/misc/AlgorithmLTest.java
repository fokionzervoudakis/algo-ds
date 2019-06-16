package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmLTest {
    private AlgorithmL L;

    @BeforeEach
    void beforeEach() {
        L = new AlgorithmL();
    }

    @Test
    void itFindsTheNextPermutationWithZeroElements() {
        var A = new int[0];
        L.next(A);
        var expected = "[]";
        var actual = Arrays.toString(A);
        assertEquals(expected, actual);
    }

    @Test
    void itFindsTheNextPermutationWithOneElement() {
        var A = new int[] { 1 };
        L.next(A);
        var expected = "[1]";
        var actual = Arrays.toString(A);
        assertEquals(expected, actual);
    }

    @Test
    void itFindsTheNextPermutationWithThreeAscendingElements() {
        var A = new int[] { 1, 2, 3 };
        L.next(A);
        var expected = "[1, 3, 2]";
        var actual = Arrays.toString(A);
        assertEquals(expected, actual);
    }

    @Test
    void itFindsTheNextPermutationWithThreeDescendingElements() {
        var A = new int[] { 3, 2, 1 };
        L.next(A);
        var expected = "[3, 2, 1]";
        var actual = Arrays.toString(A);
        assertEquals(expected, actual);
    }

    @Test
    void itFindsTheNextPermutationWithThreeUnorderedElements() {
        var A = new int[] { 1, 3, 2 };
        L.next(A);
        var expected = "[2, 1, 3]";
        var actual = Arrays.toString(A);
        assertEquals(expected, actual);
    }

    @Test
    void itFindsTheNextPermutationWithManyAscendingElements() {
        var A = new int[] { 1, 2, 3, 4, 5 };
        L.next(A);
        var expected = "[1, 2, 3, 5, 4]";
        var actual = Arrays.toString(A);
        assertEquals(expected, actual);
    }

    @Test
    void itFindsTheNextPermutationWithManyUnorderedElements1() {
        var A = new int[] { 1, 2, 3, 5, 4 };
        L.next(A);
        var expected = "[1, 2, 4, 3, 5]";
        var actual = Arrays.toString(A);
        assertEquals(expected, actual);
    }

    @Test
    void itFindsTheNextPermutationWithManyUnorderedElements2() {
        var A = new int[] { 1, 2, 4, 5, 3 };
        L.next(A);
        var expected = "[1, 2, 5, 3, 4]";
        var actual = Arrays.toString(A);
        assertEquals(expected, actual);
    }
}
