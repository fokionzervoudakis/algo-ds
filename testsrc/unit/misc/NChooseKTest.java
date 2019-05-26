package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NChooseKTest {
    private NChooseK<Integer> nChooseK;
    private Integer[] A;

    @BeforeEach
    void beforeEach() {
        nChooseK = new NChooseK<>();
        A = new Integer[] { 1, 2, 3, 4 };
    }

    @Test
    void itGeneratesOneCombinationWithZeroElements() {
        var expected = "[[]]";
        var actual = toS(nChooseK.generate(A, 0));
        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesFourCombinationsWithOneElement() {
        var expected = "[[1], [2], [3], [4]]";
        var actual = toS(nChooseK.generate(A, 1));
        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesSixCombinationsWithTwoElements() {
        var expected = "[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]";
        var actual = toS(nChooseK.generate(A, 2));
        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesFourCombinationsWithThreeElements() {
        var expected = "[[1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4]]";
        var actual = toS(nChooseK.generate(A, 3));
        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesOneCombinationWithFourElements() {
        var expected = "[[1, 2, 3, 4]]";
        var actual = toS(nChooseK.generate(A, 4));
        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesZeroCombinationsWithFiveElements() {
        assertTrue(nChooseK.generate(A, 5).isEmpty());
    }

    private String toS(List<Integer[]> L) {
        return L.stream().map(Arrays::toString).collect(Collectors.joining(", ", "[", "]"));
    }
}
