package interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClusterSizeTest {
    private ClusterSize size;

    @BeforeEach
    void beforeEach() {
        size = new ClusterSize();
    }

    @Test
    void itCalculatesTheSizeOfZeroClusters() {
        assertEquals(0, size.max(new char[][] { {} }));
    }

    @Test
    void itCalculatesTheSizesOfClustersWithOneElement() {
        assertEquals(1, size.max(new char[][] { { 'A', 'B' } }));
        assertEquals(1, size.max(new char[][] { { 'A' }, { 'B' } }));
    }

    @Test
    void itCalculatesTheSizesOfClustersWithManyElements() {
        char[][] M = {
                { 'A', 'A', 'B', 'C' },
                { 'A', 'B', 'C', 'B' },
                { 'C', 'B', 'B', 'B' }
        };
        assertEquals(5, size.max(M));
    }
}
