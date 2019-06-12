package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BfsTest_AdjList_3 {
    @Test
    void itSearchesManyVerticesWithManyNeighbors() {
        var v0 = new Bfs.Vertex(0);
        var v1 = new Bfs.Vertex(1);
        var v2 = new Bfs.Vertex(2);
        var v3 = new Bfs.Vertex(3);
        var v4 = new Bfs.Vertex(4);
        var v5 = new Bfs.Vertex(5);
        var v6 = new Bfs.Vertex(6);

        var G = new AdjList<Bfs.Vertex>();

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

        //@formatter:off
        var expected =
                "{" +
                    "0:0=[1:1, 2:1, 4:1, 0:0], " +
                    "1:1=[3:2, 5:2, 0:0], " +
                    "2:1=[6:2], " +
                    "4:1=[5:2], " +
                    "3:2=[], " +
                    "5:2=[], " +
                    "6:2=[0:0]" +
                "}";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
