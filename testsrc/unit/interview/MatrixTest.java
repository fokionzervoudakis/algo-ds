package interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {
    private Matrix mat;

    @BeforeEach
    void beforeEach() {
        mat = new Matrix();
    }

    @Nested
    class WhenTheMatrixIsASquare {
        private int[][] M;

        @BeforeEach
        void beforeEach() {
            M = new int[][] {
                    { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 },
                    { 9, 0, 1, 2 },
                    { 3, 4, 5, 6 }
            };
        }

        @Test
        void itTransposesAMatrix() {
            var expected = "[[1, 5, 9, 3], [2, 6, 0, 4], [3, 7, 1, 5], [4, 8, 2, 6]]";
            var actual = toS(mat.transpose(M));
            assertEquals(expected, actual);
        }

        @Test
        void itSwapsColumns() {
            var expected = "[[3, 4, 5, 6], [9, 0, 1, 2], [5, 6, 7, 8], [1, 2, 3, 4]]";
            var actual = toS(mat.swapColumns(M));
            assertEquals(expected, actual);
        }

        @Test
        void itSwapsRows() {
            var expected = "[[4, 3, 2, 1], [8, 7, 6, 5], [2, 1, 0, 9], [6, 5, 4, 3]]";
            var actual = toS(mat.swapRows(M));
            assertEquals(expected, actual);
        }

        @Test
        void itRotates90Left() {
            var expected = "[[4, 8, 2, 6], [3, 7, 1, 5], [2, 6, 0, 4], [1, 5, 9, 3]]";
            var actual = toS(mat.rotate90Left(M));
            assertEquals(expected, actual);
        }

        @Test
        void itRotates90Right() {
            var expected = "[[3, 9, 5, 1], [4, 0, 6, 2], [5, 1, 7, 3], [6, 2, 8, 4]]";
            var actual = toS(mat.rotate90Right(M));
            assertEquals(expected, actual);
        }

        @Test
        void itRotates180() {
            var expected = "[[6, 5, 4, 3], [2, 1, 0, 9], [8, 7, 6, 5], [4, 3, 2, 1]]";
            var actual = toS(mat.rotate180(M));
            assertEquals(expected, actual);
        }
    }

    @Nested
    class WhenTheMatrixIsRectangular {
        private int[][] M;

        @BeforeEach
        void beforeEach() {
            M = new int[][] {
                    { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 }
            };
        }

        @Test
        void itTransposesAMatrix() {
            var expected = "[[1, 5], [2, 6], [3, 7], [4, 8]]";
            var actual = toS(mat.transpose(M));
            assertEquals(expected, actual);
        }

        @Test
        void itSwapsColumns() {
            var expected = "[[5, 6, 7, 8], [1, 2, 3, 4]]";
            var actual = toS(mat.swapColumns(M));
            assertEquals(expected, actual);
        }

        @Test
        void itSwapsRows() {
            var expected = "[[4, 3, 2, 1], [8, 7, 6, 5]]";
            var actual = toS(mat.swapRows(M));
            assertEquals(expected, actual);
        }

        @Test
        void itRotates90Left() {
            var expected = "[[4, 8], [3, 7], [2, 6], [1, 5]]";
            var actual = toS(mat.rotate90Left(M));
            assertEquals(expected, actual);
        }

        @Test
        void itRotates90Right() {
            var expected = "[[5, 1], [6, 2], [7, 3], [8, 4]]";
            var actual = toS(mat.rotate90Right(M));
            assertEquals(expected, actual);
        }

        @Test
        void itRotates180() {
            var expected = "[[8, 7, 6, 5], [4, 3, 2, 1]]";
            var actual = toS(mat.rotate180(M));
            assertEquals(expected, actual);
        }
    }

    private String toS(int[][] M) {
        return Arrays.deepToString(M);
    }
}
