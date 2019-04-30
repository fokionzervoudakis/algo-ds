package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PathTest {
    @Test
    void itReturnsNullWhenTheDestinationDoesNotHaveAParent() {
        assertNull(Path.print(null, new Stub()));
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
        v2.p = v1;
        v3.p = v2;
        assertEquals("1 -> 2 -> 3", Path.print(v1, v3));
    }

    //<editor-fold desc="stubs">
    class Stub extends Vertex {
        Stub() {
            super(Integer.MAX_VALUE);
        }
    }
    //</editor-fold>
}
