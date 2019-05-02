package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BfsTest_AdjList_1 {
    private Graph<Vertex> G;
    private Vertex v0;
    private Bfs bfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Stub(0);

        G = new AdjList<>();
        G.addVertex(v0);

        bfs = new Bfs();
    }

    @Test
    void itSearchesOneVertexWithZeroNeighbors() {
        bfs.bfs(G, v0);

        var expected = "{0:0=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithOneNeighbor() {
        G.addEdge(v0, new Stub(1));

        bfs.bfs(G, v0);

        var expected = "{0:0=[1:1], 1:1=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itSearchesOneVertexWithManyNeighbors() {
        G.addEdge(v0, new Stub(1));
        G.addEdge(v0, new Stub(2));

        bfs.bfs(G, v0);

        var expected = "{0:0=[1:1, 2:1], 1:1=[], 2:1=[]}";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    //<editor-fold desc="stubs">
    class Stub extends Vertex {
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
