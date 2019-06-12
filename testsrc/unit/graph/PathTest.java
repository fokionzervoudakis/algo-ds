package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PathTest {
    @Test
    void itReturnsNullWhenTheDestinationDoesNotHaveAParent() {
        assertNull(Path.print(null, new Vertex()));
    }

    @Test
    void itPrintsTheDestinationWhenItIsTheSource() {
        var v = new Vertex(1);
        assertEquals("1", Path.print(v, v));
    }

    @Test
    void itPrintsTheShortestPathOfManyVertices() {
        var v1 = new Vertex(1);
        var v2 = new Vertex(2);
        var v3 = new Vertex(3);
        v2.setParent(v1);
        v3.setParent(v2);
        assertEquals("1 -> 2 -> 3", Path.print(v1, v3));
    }
}
