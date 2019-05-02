package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ColoringTest_AdjList_2 {
    private Graph<Coloring.Vertex> G;
    private Coloring.Vertex v0;
    private Coloring.Bfs bfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Stub(0);
        G = new AdjList<>();
        bfs = new Coloring().new Bfs();
    }

    @Test
    void itIgnoresCyclesFromReflexivePaths() {
        // v0 -> v0
        G.addEdge(v0, v0);

        assertFalse(bfs.isBipartite(G, v0));

        var expected = "{0:WH:0=[0:WH:0]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromSymmetricPaths() {
        var v1 = new Stub(1);

        // v0 -> v1 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v0);

        assertFalse(bfs.isBipartite(G, v0));

        var expected = "{0:WH:0=[1:BK:1], 1:BK:1=[0:WH:0]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromAsymmetricPaths() {
        var v1 = new Stub(1);
        var v2 = new Stub(2);

        // v0 -> v1 -> v2 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v2);
        G.addEdge(v2, v0);

        assertFalse(bfs.isBipartite(G, v0));

        var expected = "{0:WH:0=[1:BK:1], 1:BK:1=[2:WH:2], 2:WH:2=[0:WH:0]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    //<editor-fold desc="stubs">
    class Stub extends Coloring.Vertex {
        Stub(int key) {
            super(key);
        }

        @Override
        public String toString() {
            return super.toString() + ":" + d;
        }
    }
    //</editor-fold>
}
