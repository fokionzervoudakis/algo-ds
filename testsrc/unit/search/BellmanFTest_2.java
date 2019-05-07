package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BellmanFTest_2 {
    private BellmanF bellmanF;
    private List<Vertex> G;
    private Vertex v0;

    @BeforeEach
    void beforeEach() {
        bellmanF = new BellmanF();
        G = new ArrayList<>();
        v0 = new Vertex();
    }

    @Test
    void itIgnoresNonNegativeCyclesFromReflexivePaths() {
        // v0 -> v0
        v0.edges.add(new Edge(v0, 10));

        G.add(v0);

        assertFalse(bellmanF.shortestPaths(G, v0));

        var expected = "[(0: null)]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresNonNegativeCyclesFromSymmetricPaths() {
        var v1 = new Vertex();

        // v0 -> v1 -> v0
        v0.edges.add(new Edge(v1, 10));
        v1.edges.add(new Edge(v0, 20));

        G.add(v0);
        G.add(v1);

        assertFalse(bellmanF.shortestPaths(G, v0));

        var expected = "[(0: null), (10: (0: null))]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itIgnoresNonNegativeCyclesFromAsymmetricPaths() {
        var v1 = new Vertex();
        var v2 = new Vertex();

        // v0 -> v1 -> v2 -> v0
        v0.edges.add(new Edge(v1, 10));
        v1.edges.add(new Edge(v2, 20));
        v2.edges.add(new Edge(v0, 30));

        G.add(v0);
        G.add(v1);
        G.add(v2);

        assertFalse(bellmanF.shortestPaths(G, v0));

        var expected = "[(0: null), (10: (0: null)), (30: (10: (0: null)))]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itReportsNegativeCyclesFromReflexivePaths() {
        // v0 -> v0
        v0.edges.add(new Edge(v0, -10));

        G.add(v0);

        assertTrue(bellmanF.shortestPaths(G, v0));
    }

    @Test
    void itReportsNegativeCyclesFromSymmetricPaths() {
        var v1 = new Vertex();

        // v0 -> v1 -> v0
        v0.edges.add(new Edge(v1, 10));
        v1.edges.add(new Edge(v0, -20));

        G.add(v0);
        G.add(v1);

        assertTrue(bellmanF.shortestPaths(G, v0));
    }

    @Test
    void itReportsNegativeCyclesFromAsymmetricPaths() {
        var v1 = new Vertex();
        var v2 = new Vertex();

        // v0 -> v1 -> v2 -> v0
        v0.edges.add(new Edge(v1, 10));
        v1.edges.add(new Edge(v2, -20));
        v2.edges.add(new Edge(v0, -30));

        G.add(v0);
        G.add(v1);
        G.add(v2);

        assertTrue(bellmanF.shortestPaths(G, v0));
    }
}
