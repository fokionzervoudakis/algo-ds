package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimTest {
    private Prim prim;
    private List<Vertex> G;

    @BeforeEach
    void beforeEach() {
        prim = new Prim();
        G = new ArrayList<>();
    }

    @Test
    void itFindsAMinimumSpanningTreeWithOneVertex() {
        var v1 = new Vertex();

        G.add(v1);

        prim.minSpanTree(G, v1);

        var expected = "[(0: null)]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itFindsAMinimumSpanningTreeWithTwoVertices() {
        var v1 = new Vertex();
        var v2 = new Vertex();

        v1.edges.add(new Edge(v2, 10));

        G.add(v1);
        G.add(v2);

        prim.minSpanTree(G, v1);

        var expected = "[(0: null), (10: (0: null))]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itFindsAMinimumSpanningTreeWithManyVertices() {
        var v1 = new Vertex();
        var v2 = new Vertex();
        var v3 = new Vertex();
        var v4 = new Vertex();
        var v5 = new Vertex();
        var v6 = new Vertex();
        var v7 = new Vertex();
        var v8 = new Vertex();
        var v9 = new Vertex();

        add(v1, v2, 4);
        add(v1, v8, 8);

        add(v2, v3, 8);
        add(v2, v8, 11);

        add(v3, v4, 7);
        add(v3, v6, 4);
        add(v3, v9, 2);

        add(v4, v5, 9);
        add(v4, v6, 14);

        add(v5, v6, 10);

        add(v6, v7, 2);

        add(v7, v8, 1);
        add(v7, v9, 6);

        G.add(v1);
        G.add(v2);
        G.add(v3);
        G.add(v4);
        G.add(v5);
        G.add(v6);
        G.add(v7);
        G.add(v8);
        G.add(v9);

        prim.minSpanTree(G, v1);

        //@formatter:off
        var expected =
                "[" +
                    "(0: null), " +
                    "(4: (0: null)), " +
                    "(8: (4: (0: null))), " +
                    "(7: (8: (4: (0: null)))), " +
                    "(9: (7: (8: (4: (0: null))))), " +
                    "(4: (8: (4: (0: null)))), " +
                    "(2: (4: (8: (4: (0: null))))), " +
                    "(1: (2: (4: (8: (4: (0: null)))))), " +
                    "(2: (8: (4: (0: null))))" +
                "]";
        //@formatter:on

        var actual = G.toString();

        assertEquals(expected, actual);
    }

    private void add(Vertex v1, Vertex v2, int w) {
        v1.edges.add(new Edge(v2, w));
        v2.edges.add(new Edge(v1, w));
    }
}
