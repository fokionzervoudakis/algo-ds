package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Dfs2Test_It_1 {
    private Graph<Dfs2.Vertex> G;
    private Dfs2.Vertex v0;
    private Dfs2 dfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Dfs2.Vertex(0);

        G = new AdjList<>();
        G.addVertex(v0);

        dfs = new Dfs2();
    }

    @Test
    void itSearchesOneVertexWithZeroNeighbors() {
        dfs.dfs(G, v0);

        var expected = "{0=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithOneNeighbor() {
        G.addEdge(v0, new Dfs2.Vertex(1));

        dfs.dfs(G, v0);

        var expected = "{0=[1], 1=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithManyNeighbors() {
        G.addEdge(v0, new Dfs2.Vertex(1));
        G.addEdge(v0, new Dfs2.Vertex(2));

        dfs.dfs(G, v0);

        var expected = "{0=[1, 2], 1=[], 2=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
