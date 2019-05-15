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
    void itTraversesASmallSquareMatrixClockwise() {
        var M = new int[][] {
                { 1, 2 },
                { 3, 4 }
        };
        var expected = "[1, 2, 4, 3]";
        var actual = spiral.clockwise(M).toString();
        assertEquals(expected, actual);
    }

    @Test
    void itTraversesALargeSquareMatrixClockwise() {
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
    void itTraversesASmallRectangularMatrixClockwise() {
        var M = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };
        var expected = "[1, 2, 3, 6, 5, 4]";
        var actual = spiral.clockwise(M).toString();
        assertEquals(expected, actual);
    }

    @Test
    void itTraversesALargeRectangularMatrixClockwise() {
        var M = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        var expected = "[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]";
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
