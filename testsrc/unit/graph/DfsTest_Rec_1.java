package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DfsTest_Rec_1 {
    private Graph<Dfs.Vertex> G;
    private Dfs.Vertex v0;
    private Dfs.Rec dfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Dfs.Vertex(0);

        G = new AdjList<>();
        G.addVertex(v0);

        dfs = new Dfs().new Rec();
    }

    @Test
    void itSearchesOneVertexWithZeroNeighbors() {
        dfs.dfs(G);

        var expected = "{0=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithOneNeighbor() {
        G.addEdge(v0, new Dfs.Vertex(1));

        dfs.dfs(G);

        var expected = "{0=[1], 1=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithManyNeighbors() {
        G.addEdge(v0, new Dfs.Vertex(1));
        G.addEdge(v0, new Dfs.Vertex(2));

        dfs.dfs(G);

        var expected = "{0=[1, 2], 1=[], 2=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
