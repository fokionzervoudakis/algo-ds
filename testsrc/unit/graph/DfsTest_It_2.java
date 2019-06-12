package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DfsTest_It_2 {
    private Graph<Dfs.Vertex> G;
    private Dfs.Vertex v0;
    private Dfs.It dfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Dfs.Vertex(0);

        G = new AdjList<>();
        G.addVertex(v0);

        dfs = new Dfs().new It();
    }

    @Test
    void itIgnoresCyclesFromReflexivePaths() {
        // v0 -> v0
        G.addEdge(v0, v0);

        dfs.dfs(G);

        var expected = "{0=[0]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromSymmetricPaths() {
        var v1 = new Dfs.Vertex(1);

        // v0 -> v1 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v0);

        dfs.dfs(G);

        var expected = "{0=[1], 1=[0]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromAsymmetricPaths() {
        var v1 = new Dfs.Vertex(1);
        var v2 = new Dfs.Vertex(2);

        // v0 -> v1 -> v2 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v2);
        G.addEdge(v2, v0);

        dfs.dfs(G);

        var expected = "{0=[1], 1=[2], 2=[0]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
