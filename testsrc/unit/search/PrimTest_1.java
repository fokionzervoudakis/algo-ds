package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimTest_1 {
    private Prim prim;
    private List<Vertex> G;
    private Vertex v0;

    @BeforeEach
    void beforeEach() {
        prim = new Prim();
        G = new ArrayList<>();
        v0 = new Vertex();
    }

    @Test
    void itGeneratesAMinSpanningTreeWithZeroVertices() {
        var v0 = new Vertex();

        G.add(v0);

        prim.minSpanTree(G, v0);

        var expected = "[(0: null)]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesAMinSpanningTreeWithOneVertex() {
        var v1 = new Vertex();

        v0.edges.add(new Edge(v1, 10));

        G.add(v0);
        G.add(v1);

        prim.minSpanTree(G, v0);

        var expected = "[(0: null), (10: (0: null))]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesAMinSpanningTreeWithManyVertices() {
        var v1 = new Vertex();
        var v2 = new Vertex();

        v0.edges.add(new Edge(v1, 10));
        v0.edges.add(new Edge(v2, 20));

        G.add(v0);
        G.add(v1);
        G.add(v2);

        prim.minSpanTree(G, v0);

        var expected = "[(0: null), (10: (0: null)), (20: (0: null))]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
