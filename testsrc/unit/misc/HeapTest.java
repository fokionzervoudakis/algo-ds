package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapTest {
    private Heap<Integer> heap;

    @BeforeEach
    void beforeEach() {
        heap = new Heap<>();
    }

    @Test
    void itGeneratesZeroPermutations() {
        var expected = "[[]]";
        var actual = toS(heap.generate(new Integer[0]));
        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesOnePermutation() {
        var expected = "[[1]]";
        var actual = toS(heap.generate(new Integer[] { 1 }));
        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesManyPermutations() {
        var A = new Integer[] { 1, 2, 3 };
        var expected = "[[1, 2, 3], [2, 1, 3], [3, 1, 2], [1, 3, 2], [2, 3, 1], [3, 2, 1]]";
        var actual = toS(heap.generate(A));
        assertEquals(expected, actual);
    }

    private String toS(List<Integer[]> L) {
        return L.stream().map(Arrays::toString).collect(Collectors.joining(", ", "[", "]"));
    }
}
