package graph;

import graph.ObjGraph.ObjVertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BfsTest_ObjGraph_2 {
    private Graph G;
    private Vertex v0;
    private Bfs bfs;

    @BeforeEach
    void beforeEach() {
        v0 = new Stub(0);
        G = new ObjGraph(3);
        bfs = new Bfs();
    }

    @Test
    void itIgnoresCyclesFromReflexivePaths() {
        // v0 -> v0
        G.addEdge(v0, v0);

        bfs.bfs(G, v0);

        var expected = "[0:0=[0:0], null, null]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromSymmetricPaths() {
        var v1 = new Stub(1);

        // v0 -> v1 -> v0
        G.addEdge(v0, v1);
        G.addEdge(v1, v0);

        bfs.bfs(G, v0);

        var expected = "[0:0=[1:1], 1:1=[0:0], null]";
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

        bfs.bfs(G, v0);

        var expected = "[0:0=[1:1], 1:1=[2:2], 2:2=[0:0]]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    //<editor-fold desc="stubs">
    class Stub extends ObjVertex {
        Stub(int key) {
            super(key);
        }

        @Override
        public String toString() {
            return key + ":" + d + "=" + toS(L);
        }

        @Override
        String toS(List<Vertex> L) {
            return L.stream().map(v -> v.key + ":" + v.d).collect(Collectors.joining(", ", "[", "]"));
        }
    }
    //</editor-fold>
}
