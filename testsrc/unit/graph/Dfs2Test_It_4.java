package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Dfs2Test_It_4 {
    @Test
    void itSearchesManyVerticesWithManyNeighbors() {
        var v0 = new Dfs2.Vertex(0);
        var v1 = new Dfs2.Vertex(1);
        var v2 = new Dfs2.Vertex(2);
        var v3 = new Dfs2.Vertex(3);

        var G = new AdjList<Dfs2.Vertex>();

        G.addEdge(v0, v1);
        G.addEdge(v1, v2);
        G.addEdge(v3, v1);
        G.addEdge(v3, v2);

        new Dfs2().dfs(G, v0);

        var expected = "{0=[1], 1=[2], 2=[], 3=[1, 2]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
