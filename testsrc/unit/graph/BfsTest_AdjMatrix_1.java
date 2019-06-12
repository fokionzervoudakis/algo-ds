package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BfsTest_AdjMatrix_1 {
    private Graph<Bfs.Vertex> G;
    private Bfs.Vertex v0;
    private Bfs bfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Bfs.Vertex(0);

        G = new AdjMatrix<>(3);
        G.addVertex(v0);

        bfs = new Bfs();
    }

    @Test
    void itSearchesOneVertexWithZeroNeighbors() {
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
    void itSearchesOneVertexWithOneNeighbor() {
        G.addEdge(v0, new Bfs.Vertex(1));

        bfs.bfs(G, v0);

        //@formatter:off
        var expected =
                "[0:0, 1:1, null], " +
                "[null, 1:1, null], " +
                "[null, null, null]";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithManyNeighbors() {
        G.addEdge(v0, new Bfs.Vertex(1));
        G.addEdge(v0, new Bfs.Vertex(2));

        bfs.bfs(G, v0);

        //@formatter:off
        var expected =
                "[0:0, 1:1, 2:1], " +
                "[null, 1:1, null], " +
                "[null, null, 2:1]";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
