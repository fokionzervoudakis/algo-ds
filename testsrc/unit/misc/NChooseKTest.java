package misc;

import misc.NChooseK.Combinator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NChooseKTest {
    private NChooseK chooseK;

    @BeforeEach
    void beforeEach() {
        chooseK = new NChooseK();
    }

    @Test
    void itCalculatesTheBinomialCoefficient() {
        assertEquals(1, chooseK.rec(5, 0));
        assertEquals(5, chooseK.rec(5, 1));
        assertEquals(10, chooseK.rec(5, 2));
        assertEquals(10, chooseK.rec(5, 3));
        assertEquals(5, chooseK.rec(5, 4));
        assertEquals(1, chooseK.rec(5, 5));
    }

    @Test
    void itCalculatesTheBaseCase() {
        assertEquals(1, chooseK.rec(1, 0));
        assertEquals(1, chooseK.rec(1, 1));
    }

    @Nested
    class WhenItGeneratesCombinations {
        private Combinator<Integer> combinator;
        private Integer[] A;

        @BeforeEach
        void beforeEach() {
            combinator = chooseK.new Combinator<>();
            A = new Integer[] { 1, 2, 3, 4 };
        }

        @Test
        void itGeneratesOneCombinationWithZeroElements() {
            var expected = "[[]]";
            var actual = toS(combinator.generate(A, 0));
            assertEquals(expected, actual);
        }

        @Test
        void itGeneratesFourCombinationsWithOneElement() {
            var expected = "[[1], [2], [3], [4]]";
            var actual = toS(combinator.generate(A, 1));
            assertEquals(expected, actual);
        }

        @Test
        void itGeneratesSixCombinationsWithTwoElements() {
            var expected = "[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]";
            var actual = toS(combinator.generate(A, 2));
            assertEquals(expected, actual);
        }

        @Test
        void itGeneratesFourCombinationsWithThreeElements() {
            var expected = "[[1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4]]";
            var actual = toS(combinator.generate(A, 3));
            assertEquals(expected, actual);
        }

        @Test
        void itGeneratesOneCombinationWithFourElements() {
            var expected = "[[1, 2, 3, 4]]";
            var actual = toS(combinator.generate(A, 4));
            assertEquals(expected, actual);
        }

        @Test
        void itGeneratesZeroCombinations() {
            assertTrue(combinator.generate(A, 5).isEmpty());
        }
    }

    private String toS(List<Integer[]> L) {
        return L.stream().map(Arrays::toString).collect(Collectors.joining(", ", "[", "]"));
    }
}
