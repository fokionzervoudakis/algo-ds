package interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClusterCountTest {
    private ClusterCount count;

    @BeforeEach
    void beforeEach() {
        count = new ClusterCount();
    }

    @Test
    void itCountsZeroClusters() {
        assertEquals(0, count.count(new int[][] { {} }));
    }

    @Test
    void itCountsOneCluster() {
        assertEquals(1, count.count(new int[][] { { 0, 1 } }));
        assertEquals(1, count.count(new int[][] { { 0 }, { 1 } }));
    }

    @Test
    void itCountsManyClusters() {
        int[][] M = {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };
        assertEquals(5, count.count(M));
    }
}
