package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Bfs2Test_AdjList_3 {
    @Test
    void itSearchesManyVerticesWithManyNeighbors() {
        var v0 = new Bfs2.Vertex(0);
        var v1 = new Bfs2.Vertex(1);
        var v2 = new Bfs2.Vertex(2);
        var v3 = new Bfs2.Vertex(3);
        var v4 = new Bfs2.Vertex(4);
        var v5 = new Bfs2.Vertex(5);
        var v6 = new Bfs2.Vertex(6);

        var G = new AdjList<Bfs2.Vertex>();

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

        assertFalse(new Bfs2().isBipartite(G, v0));

        //@formatter:off
        var expected =
                "{" +
                    "0:WHITE:0=[1:BLACK:1, 2:BLACK:1, 4:BLACK:1, 0:WHITE:0], " +
                    "1:BLACK:1=[3:null:0, 5:null:0, 0:WHITE:0], " +
                    "2:BLACK:1=[6:null:0], " +
                    "4:BLACK:1=[5:null:0], " +
                    "3:null:0=[], " +
                    "5:null:0=[], " +
                    "6:null:0=[0:WHITE:0]" +
                "}";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }

}
