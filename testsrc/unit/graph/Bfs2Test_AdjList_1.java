package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Bfs2Test_AdjList_1 {
    private Graph<Bfs2.Vertex> G;
    private Bfs2.Vertex v0;
    private Bfs2 bfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Bfs2.Vertex(0);

        G = new AdjList<>();
        G.addVertex(v0);

        bfs = new Bfs2();
    }

    @Test
    void itSearchesOneVertexWithZeroNeighbors() {
        assertTrue(bfs.isBipartite(G, v0));

        var expected = "{0:WHITE:0=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithOneNeighbor() {
        G.addEdge(v0, new Bfs2.Vertex(1));

        assertTrue(bfs.isBipartite(G, v0));

        var expected = "{0:WHITE:0=[1:BLACK:1], 1:BLACK:1=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithManyNeighbors() {
        G.addEdge(v0, new Bfs2.Vertex(1));
        G.addEdge(v0, new Bfs2.Vertex(2));

        assertTrue(bfs.isBipartite(G, v0));

        var expected = "{0:WHITE:0=[1:BLACK:1, 2:BLACK:1], 1:BLACK:1=[], 2:BLACK:1=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
