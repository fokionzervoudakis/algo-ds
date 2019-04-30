package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DfsTest_Rec_3 {
    @Test
    void itSearchesManyVerticesWithManyNeighbors() {
        var v0 = new Vertex(0);
        var v1 = new Vertex(1);
        var v2 = new Vertex(2);
        var v3 = new Vertex(3);
        var v4 = new Vertex(4);
        var v5 = new Vertex(5);
        var v6 = new Vertex(6);

        var G = new AdjList();

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

        new Dfs().new Rec().dfs(G);

        //@formatter:off
        var expected =
                "{" +
                    "0=[1, 2, 4, 0], " +
                    "1=[3, 5, 0], " +
                    "2=[6], " +
                    "4=[5], " +
                    "3=[], " +
                    "5=[], " +
                    "6=[0]" +
                "}";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
