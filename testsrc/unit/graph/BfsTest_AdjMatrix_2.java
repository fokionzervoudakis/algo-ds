package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BfsTest_AdjMatrix_2 {
    private Graph<Bfs.Vertex> G;
    private Bfs.Vertex v0;
    private Bfs bfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Bfs.Vertex(0);
        G = new AdjMatrix<>(3);
        bfs = new Bfs();
    }

    @Test
    void itIgnoresCyclesFromReflexivePaths() {
        // v0 -> v0
        G.addEdge(v0, v0);

        bfs.bfs(G, v0);

        //@formatter:off
        var expected =
                "[0:0, null, null], " +
                "[null, null, null], " +
                "[null, null, null]";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromSymmetricPaths() {
        var v1 = new Bfs.Vertex(1);

        // v0 -> v1 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v0);

        bfs.bfs(G, v0);

        //@formatter:off
        var expected =
                "[0:0, 1:1, null], " +
                "[0:0, 1:1, null], " +
                "[null, null, null]";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromAsymmetricPaths() {
        var v1 = new Bfs.Vertex(1);
        var v2 = new Bfs.Vertex(2);

        // v0 -> v1 -> v2 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v2);
        G.addEdge(v2, v0);

        bfs.bfs(G, v0);

        //@formatter:off
        var expected =
                "[0:0, 1:1, null], " +
                "[null, 1:1, 2:2], " +
                "[0:0, null, 2:2]";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
