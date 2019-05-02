package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColoringTest_AdjList_1 {
    private Graph<Coloring.Vertex> G;
    private Coloring.Vertex v0;
    private Coloring.Bfs bfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Stub(0);

        G = new AdjList<>();
        G.addVertex(v0);

        bfs = new Coloring().new Bfs();
    }

    @Test
    void itSearchesOneVertexWithZeroNeighbors() {
        assertTrue(bfs.isBipartite(G, v0));

        var expected = "{0:WH:0=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithOneNeighbor() {
        G.addEdge(v0, new Stub(1));

        assertTrue(bfs.isBipartite(G, v0));

        var expected = "{0:WH:0=[1:BK:1], 1:BK:1=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithManyNeighbors() {
        G.addEdge(v0, new Stub(1));
        G.addEdge(v0, new Stub(2));

        assertTrue(bfs.isBipartite(G, v0));

        var expected = "{0:WH:0=[1:BK:1, 2:BK:1], 1:BK:1=[], 2:BK:1=[]}";
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
