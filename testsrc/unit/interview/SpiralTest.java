package interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralTest {
    private Spiral spiral;

    @BeforeEach
    void beforeEach() {
        spiral = new Spiral();
    }

    @Test
    void itTraversesASquareMatrixClockwise() {
        var M = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 0, 1, 2 },
                { 3, 4, 5, 6 }
        };
        var expected = "[1, 2, 3, 4, 8, 2, 6, 5, 4, 3, 9, 5, 6, 7, 1, 0]";
        var actual = spiral.clockwise(M).toString();
        assertEquals(expected, actual);
    }

    @Test
    void itTraversesARectangularMatrixClockwise() {
        var M = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 }
        };
        var expected = "[1, 2, 3, 4, 8, 7, 6, 5]";
        var actual = spiral.clockwise(M).toString();
        assertEquals(expected, actual);
    }

    @Test
    void itTraversesAnEmptyMatrix() {
        var expected = "[]";
        var actual = spiral.clockwise(new int[0][]).toString();
        assertEquals(expected, actual);
    }
}
