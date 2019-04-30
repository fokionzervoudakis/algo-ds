package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import search.Dijkstra.Edge;
import search.Dijkstra.Vertex;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraTest {
    private Dijkstra dijkstra;
    private List<Vertex> G;

    @BeforeEach
    void beforeEach() {
        dijkstra = new Dijkstra();
        G = new ArrayList<>();
    }

    @Test
    void itReturnsZeroShortestPaths() {
        var v1 = new Vertex();

        G.add(v1);

        var expected = "[(0: null)]";
        var actual = dijkstra.shortestPaths(G, v1).toString();

        assertEquals(expected, actual);
    }

    @Test
    void itReturnsOneShortestPath() {
        var v1 = new Vertex();
        var v2 = new Vertex();

        v1.edges.add(new Edge(v2, 10));

        G.add(v1);
        G.add(v2);

        var expected = "[(0: null), (10: (0: null))]";
        var actual = dijkstra.shortestPaths(G, v1).toString();

        assertEquals(expected, actual);
    }

    @Test
    void itReturnsManyShortestPaths() {
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

        G.add(v1);
        G.add(v2);
        G.add(v3);
        G.add(v4);
        G.add(v5);

        //@formatter:off
        var expected =
                "[" +
                    "(0: null), " +
                    "(5: (0: null)), " +
                    "(8: (5: (0: null))), " +
                    "(9: (8: (5: (0: null)))), " +
                    "(13: (9: (8: (5: (0: null)))))" +
                "]";
        //@formatter:on

        var actual = dijkstra.shortestPaths(G, v1).toString();

        assertEquals(expected, actual);
    }
}
