package graph;

import graph.ObjGraph.ObjVertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObjGraphTest {
    private ObjGraph G;
    private ObjVertex v0;

    @BeforeEach
    void beforeEach() {
        G = new ObjGraph(3);
        v0 = new ObjVertex(0);
    }

    @Test
    void itAddsANewVertex() {
        G.addVertex(v0);

        var expected = "[0=[], null, null]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itDoesNotAddAnExistingVertex() {
        G.addVertex(v0);
        G.addVertex(v0);

        var expected = "[0=[], null, null]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itAddsAnEdgeToANewVertex() {
        G.addEdge(v0, new ObjVertex(1));

        var expected = "[0=[1], 1=[], null]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itAddsAnEdgeToAnExistingVertex() {
        G.addEdge(v0, new ObjVertex(1));
        G.addEdge(v0, new ObjVertex(2));

        var expected = "[0=[1, 2], 1=[], 2=[]]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itRemovesAnEdge() {
        var v1 = new ObjVertex(1);
        G.addEdge(v0, v1);
        G.removeEdge(v0, v1);

        var expected = "[0=[], 1=[], null]";
        var actual = G.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itReturnsTrueIfTheVertexHasTheEdge() {
        var v1 = new ObjVertex(1);
        G.addEdge(v0, v1);
        assertTrue(G.hasEdge(v0, v1));
    }

    @Test
    void itReturnsFalseIfTheVertexDoesNotHaveTheEdge() {
        G.addEdge(v0, new ObjVertex(1));
        assertFalse(G.hasEdge(v0, new ObjVertex(2)));
    }

    @Test
    void itReturnsIncomingEdges() {
        var v1 = new ObjVertex(1);
        var v2 = new ObjVertex(2);

        G.addEdge(v1, v0);
        G.addEdge(v2, v0);

        var expected = "[1=[0], 2=[0]]";
        var actual = G.inEdges(v0).toString();

        assertEquals(expected, actual);
    }

    @Test
    void itReturnsOutgoingEdges() {
        G.addEdge(v0, new ObjVertex(1));
        G.addEdge(v0, new ObjVertex(2));

        var expected = "[1=[], 2=[]]";
        var actual = G.outEdges(v0).toString();

        assertEquals(expected, actual);
    }
}
