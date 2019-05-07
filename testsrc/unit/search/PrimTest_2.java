package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimTest_2 {
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
    void itIgnoresCyclesFromReflexivePaths() {
        // v0 -> v0
        v0.edges.add(new Edge(v0, 10));

        G.add(v0);

        prim.minSpanTree(G, v0);

        var expected = "[(0: null)]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromSymmetricPaths() {
        var v1 = new Vertex();

        // v0 -> v1 -> v0
        v0.edges.add(new Edge(v1, 10));
        v1.edges.add(new Edge(v0, 20));

        G.add(v0);
        G.add(v1);

        prim.minSpanTree(G, v0);

        var expected = "[(0: null), (10: (0: null))]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresCyclesFromAsymmetricPaths() {
        var v1 = new Vertex();
        var v2 = new Vertex();

        // v0 -> v1 -> v2 -> v0
        v0.edges.add(new Edge(v1, 10));
        v1.edges.add(new Edge(v2, 20));
        v2.edges.add(new Edge(v0, 30));

        G.add(v0);
        G.add(v1);
        G.add(v2);

        prim.minSpanTree(G, v0);

        var expected = "[(0: null), (10: (0: null)), (20: (10: (0: null)))]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }
}
