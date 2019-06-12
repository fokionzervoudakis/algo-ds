package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class Dfs2Test_It_3 {
    @Test
    void itSearchesManyVerticesWithManyNeighbors() {
        var v0 = new Dfs2.Vertex(0);
        var v1 = new Dfs2.Vertex(1);
        var v2 = new Dfs2.Vertex(2);
        var v3 = new Dfs2.Vertex(3);
        var v4 = new Dfs2.Vertex(4);
        var v5 = new Dfs2.Vertex(5);
        var v6 = new Dfs2.Vertex(6);

        var G = new AdjList<Dfs2.Vertex>();

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

        try {
            new Dfs2().dfs(G, v0);
            fail(new Throwable());
        } catch (RuntimeException ignored) {
        }
    }
}
