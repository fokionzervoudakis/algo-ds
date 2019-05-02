package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ColoringTest_AdjList_3 {
    @Test
    void itSearchesManyVerticesWithManyNeighbors() {
        var v0 = new Stub(0);
        var v1 = new Stub(1);
        var v2 = new Stub(2);
        var v3 = new Stub(3);
        var v4 = new Stub(4);
        var v5 = new Stub(5);
        var v6 = new Stub(6);

        var G = new AdjList<Coloring.Vertex>();

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

        assertFalse(new Coloring().new Bfs().isBipartite(G, v0));

        //@formatter:off
        var expected =
                "{" +
                    "0:WH:0=[1:BK:1, 2:BK:1, 4:BK:1, 0:WH:0], " +
                    "1:BK:1=[3:null:0, 5:null:0, 0:WH:0], " +
                    "2:BK:1=[6:null:0], " +
                    "4:BK:1=[5:null:0], " +
                    "3:null:0=[], " +
                    "5:null:0=[], " +
                    "6:null:0=[0:WH:0]" +
                "}";
        //@formatter:on

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
