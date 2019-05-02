package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdjMatrixTest {
    private AdjMatrix<Vertex> M;
    private Vertex v0;

    @BeforeEach
    void beforeEach() {
        M = new AdjMatrix<>(3);
        v0 = new Vertex(0);
    }

    @Test
    void itAddsANewVertex() {
        M.addVertex(v0);

        //@formatter:off
        var expected =
                "[0, null, null], " +
                "[null, null, null], " +
                "[null, null, null]";
        //@formatter:on

        var actual = M.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itDoesNotAddAnExistingVertex() {
        M.addVertex(v0);
        M.addVertex(v0);

        //@formatter:off
        var expected =
                "[0, null, null], " +
                "[null, null, null], " +
                "[null, null, null]";
        //@formatter:on

        var actual = M.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itAddsAnEdgeToANewVertex() {
        M.addEdge(v0, new Vertex(1));

        //@formatter:off
        var expected =
                "[0, 1, null], " +
                "[null, 1, null], " +
                "[null, null, null]";
        //@formatter:on

        var actual = M.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itAddsAnEdgeToAnExistingVertex() {
        M.addEdge(v0, new Vertex(1));
        M.addEdge(v0, new Vertex(2));

        //@formatter:off
        var expected =
                "[0, 1, 2], " +
                "[null, 1, null], " +
                "[null, null, 2]";
        //@formatter:on

        var actual = M.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itRemovesAnEdge() {
        var v1 = new Vertex(1);
        M.addEdge(v0, v1);
        M.removeEdge(v0, v1);

        //@formatter:off
        var expected =
                "[0, null, null], " +
                "[null, 1, null], " +
                "[null, null, null]";
        //@formatter:on

        var actual = M.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itReturnsTrueIfTheVertexHasTheEdge() {
        var v1 = new Vertex(1);
        M.addEdge(v0, v1);
        assertTrue(M.hasEdge(v0, v1));
    }

    @Test
    void itReturnsFalseIfTheVertexDoesNotHaveTheEdge() {
        M.addEdge(v0, new Vertex(1));
        assertFalse(M.hasEdge(v0, new Vertex(2)));
    }

    @Test
    void itReturnsIncomingEdges() {
        var v1 = new Vertex(1);
        var v2 = new Vertex(2);

        M.addEdge(v1, v0);
        M.addEdge(v2, v0);

        var expected = "[1, 2]";
        var actual = M.inEdges(v0).toString();

        assertEquals(expected, actual);
    }

    @Test
    void itReturnsOutgoingEdges() {
        M.addEdge(v0, new Vertex(1));
        M.addEdge(v0, new Vertex(2));

        var expected = "[1, 2]";
        var actual = M.outEdges(v0).toString();

        assertEquals(expected, actual);
    }
}
