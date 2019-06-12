package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Bfs2Test_AdjList_2 {
    private Graph<Bfs2.Vertex> G;
    private Bfs2.Vertex v0;
    private Bfs2 bfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Bfs2.Vertex(0);
        G = new AdjList<>();
        bfs = new Bfs2();
    }

    @Test
    void itIgnoresCyclesFromReflexivePaths() {
        // v0 -> v0
        G.addEdge(v0, v0);

        assertFalse(bfs.isBipartite(G, v0));

        var expected = "{0:WHITE:0=[0:WHITE:0]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromSymmetricPaths() {
        var v1 = new Bfs2.Vertex(1);

        // v0 -> v1 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v0);

        assertFalse(bfs.isBipartite(G, v0));

        var expected = "{0:WHITE:0=[1:BLACK:1], 1:BLACK:1=[0:WHITE:0]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromAsymmetricPaths() {
        var v1 = new Bfs2.Vertex(1);
        var v2 = new Bfs2.Vertex(2);

        // v0 -> v1 -> v2 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v2);
        G.addEdge(v2, v0);

        assertFalse(bfs.isBipartite(G, v0));

        var expected = "{0:WHITE:0=[1:BLACK:1], 1:BLACK:1=[2:WHITE:2], 2:WHITE:2=[0:WHITE:0]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
