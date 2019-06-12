package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BfsTest_AdjMatrix_3 {
    @Test
    void itSearchesManyVerticesWithManyNeighbors() {
        var v0 = new Bfs.Vertex(0);
        var v1 = new Bfs.Vertex(1);
        var v2 = new Bfs.Vertex(2);
        var v3 = new Bfs.Vertex(3);
        var v4 = new Bfs.Vertex(4);
        var v5 = new Bfs.Vertex(5);
        var v6 = new Bfs.Vertex(6);

        var G = new AdjMatrix<Bfs.Vertex>(7);

        G.addEdge(v0, v1);
        G.addEdge(v0, v2);
        G.addEdge(v0, v4);

        G.addEdge(v1, v3);
        G.addEdge(v1, v5);

        G.addEdge(v2, v6);

        G.addEdge(v4, v5);

        G.addEdge(v0, v0); // ignored reflexive path: v0 -> v0
        G.addEdge(v1, v0); // ignored symmetric path: v0 -> v1 -> v0
        G.addEdge(v6, v0); // ignored asymmetric path: v0 -> v2 -> v6 -> v0

        new Bfs().bfs(G, v0);

        //@formatter:off
        var expected =
                "[0:0, 1:1, 2:1, null, 4:1, null, null], " +
                "[0:0, 1:1, null, 3:2, null, 5:2, null], " +
                "[null, null, 2:1, null, null, null, 6:2], " +
                "[null, null, null, 3:2, null, null, null], " +
                "[null, null, null, null, 4:1, 5:2, null], " +
                "[null, null, null, null, null, 5:2, null], " +
                "[0:0, null, null, null, null, null, 6:2]";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
