package graph;

import graph.ObjGraph.ObjVertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathTest_Bfs {
    @Test
    void itPrintsTheShortestPaths() {
        var v0 = new Stub(0);
        var v1 = new Stub(1);
        var v2 = new Stub(2);
        var v3 = new Stub(3);
        var v4 = new Stub(4);
        var v5 = new Stub(5);
        var v6 = new Stub(6);

        var G = new AdjMatrix(7);

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

        new Bfs().bfs(G, v0);

        assertEquals("0:0", Path.print(v0, v0));
        assertEquals("0:0 -> 1:1", Path.print(v0, v1));
        assertEquals("0:0 -> 2:1", Path.print(v0, v2));
        assertEquals("0:0 -> 1:1 -> 3:2", Path.print(v0, v3));
        assertEquals("0:0 -> 4:1", Path.print(v0, v4));
        assertEquals("0:0 -> 1:1 -> 5:2", Path.print(v0, v5));
        assertEquals("0:0 -> 2:1 -> 6:2", Path.print(v0, v6));
    }

    //<editor-fold desc="stubs">
    class Stub extends ObjVertex {
        Stub(int key) {
            super(key);
        }

        @Override
        public String toString() {
            return key + ":" + d;
        }
    }
    //</editor-fold>
}
