package search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimTest_3 {
    @Test
    void itGeneratesAMinSpanningTreeWithManyVertices() {
        var v1 = new Vertex();
        var v2 = new Vertex();
        var v3 = new Vertex();
        var v4 = new Vertex();
        var v5 = new Vertex();

        v1.edges.add(new Edge(v2, 10));
        v1.edges.add(new Edge(v4, 5));

        v2.edges.add(new Edge(v3, 1));
        v2.edges.add(new Edge(v4, 2));

        v3.edges.add(new Edge(v5, 4));

        v4.edges.add(new Edge(v2, 3));
        v4.edges.add(new Edge(v3, 9));
        v4.edges.add(new Edge(v4, 2));

        v5.edges.add(new Edge(v2, 7));
        v5.edges.add(new Edge(v3, 6));

        var G = new ArrayList<Vertex>();

        G.add(v1);
        G.add(v2);
        G.add(v3);
        G.add(v4);
        G.add(v5);

        new Prim().minSpanTree(G, v1);

        //@formatter:off
        var expected =
                "[" +
                    "(0: null), " +
                    "(3: (5: (0: null))), " +
                    "(1: (3: (5: (0: null)))), " +
                    "(5: (0: null)), " +
                    "(4: (1: (3: (5: (0: null)))))" +
                "]";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
