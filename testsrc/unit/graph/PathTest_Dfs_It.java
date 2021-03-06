package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathTest_Dfs_It {
    @Test
    void itPrintsTheShortestPaths() {
        var v0 = new Stub(0);
        var v1 = new Stub(1);
        var v2 = new Stub(2);
        var v3 = new Stub(3);
        var v4 = new Stub(4);
        var v5 = new Stub(5);
        var v6 = new Stub(6);

        var G = new AdjMatrix<Dfs.Vertex>(7);

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

        new Dfs().new It().dfs(G);

        assertEquals("0", Path.print(v0, v0));
        assertEquals("0 -> 1", Path.print(v0, v1));
        assertEquals("0 -> 2", Path.print(v0, v2));
        assertEquals("0 -> 1 -> 3", Path.print(v0, v3));
        assertEquals("0 -> 4", Path.print(v0, v4));

        // Because iterative DFS uses a stack to store vertices on the current search path,
        // iterative and recursive DFS variations visit vertex neighbors in different order.
        assertEquals("0 -> 4 -> 5", Path.print(v0, v5));

        assertEquals("0 -> 2 -> 6", Path.print(v0, v6));
    }

    //<editor-fold desc="stubs">
    class Stub extends Dfs.Vertex {
        Stub(int key) {
            super(key);
        }

        @Override
        public String toString() {
            return getKey() + "";
        }
    }
    //</editor-fold>
}
