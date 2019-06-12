package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class Dfs2Test_It_2 {
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
    void itDetectsCyclesFromReflexivePaths() {
        // v0 -> v0
        G.addEdge(v0, v0);

        try {
            dfs.dfs(G, v0);
            fail(new Throwable());
        } catch (RuntimeException ignored) {
        }
    }

    @Test
    void itDetectsCyclesFromSymmetricPaths() {
        var v1 = new Dfs2.Vertex(1);

        // v0 -> v1 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v0);

        try {
            dfs.dfs(G, v0);
            fail(new Throwable());
        } catch (RuntimeException ignored) {
        }
    }

    @Test
    void itDetectsCyclesFromAsymmetricPaths() {
        var v1 = new Dfs2.Vertex(1);
        var v2 = new Dfs2.Vertex(2);

        // v0 -> v1 -> v2 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v2);
        G.addEdge(v2, v0);

        try {
            dfs.dfs(G, v0);
            fail(new Throwable());
        } catch (RuntimeException ignored) {
        }
    }
}
