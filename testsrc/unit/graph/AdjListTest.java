package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdjListTest {
    private AdjList<Vertex> L;
    private Vertex v0;

    @BeforeEach
    void beforeEach() {
        L = new AdjList<>();
        v0 = new Vertex(0);
    }

    @Test
    void itAddsANewVertex() {
        L.addVertex(v0);

        var expected = "{0=[]}";
        var actual = L.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itDoesNotAddAnExistingVertex() {
        L.addVertex(v0);
        L.addVertex(v0);

        var expected = "{0=[]}";
        var actual = L.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itAddsAnEdgeToANewVertex() {
        L.addEdge(v0, new Vertex(1));

        var expected = "{0=[1], 1=[]}";
        var actual = L.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itAddsAnEdgeToAnExistingVertex() {
        L.addEdge(v0, new Vertex(1));
        L.addEdge(v0, new Vertex(2));

        var expected = "{0=[1, 2], 1=[], 2=[]}";
        var actual = L.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itRemovesAnEdge() {
        var v1 = new Vertex(1);
        L.addEdge(v0, v1);
        L.removeEdge(v0, v1);

        var expected = "{0=[], 1=[]}";
        var actual = L.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itReturnsTrueIfTheVertexHasTheEdge() {
        var v1 = new Vertex(2);
        L.addEdge(v0, v1);
        assertTrue(L.hasEdge(v0, v1));
    }

    @Test
    void itReturnsFalseIfTheVertexDoesNotHaveTheEdge() {
        L.addEdge(v0, new Vertex(2));
        assertFalse(L.hasEdge(v0, new Vertex(3)));
    }

    @Test
    void itReturnsIncomingEdges() {
        var v1 = new Vertex(1);
        var v2 = new Vertex(2);

        L.addEdge(v1, v0);
        L.addEdge(v2, v0);

        var expected = "[1, 2]";
        var actual = L.inEdges(v0).toString();

        assertEquals(expected, actual);
    }

    @Test
    void itReturnsOutgoingEdges() {
        L.addEdge(v0, new Vertex(1));
        L.addEdge(v0, new Vertex(2));

        var expected = "[1, 2]";
        var actual = L.outEdges(v0).toString();

        assertEquals(expected, actual);
    }
}
