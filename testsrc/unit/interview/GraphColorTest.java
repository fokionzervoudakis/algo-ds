package interview;

import interview.GraphColor.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class GraphColorTest {
    private GraphColor gc;
    private String[] colors;

    @BeforeEach
    void beforeEach() {
        gc = new GraphColor();
        colors = new String[] { "red", "green", "blue", "orange", "yellow", "white" };
    }

    @Test
    void itColorsALinearGraph() {
        var n1 = new Vertex(1);
        var n2 = new Vertex(2);
        var n3 = new Vertex(3);
        var n4 = new Vertex(4);

        n1.neighbors.add(n2);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n3);

        var graph = new Vertex[] { n1, n2, n3, n4 };

        gc.color(graph, colors);

        //@formatter:off
        var expected =
                "[" +
                    "1:red=[2:green], " +
                    "2:green=[1:red, 3:red], " +
                    "3:red=[2:green, 4:green], " +
                    "4:green=[3:red]" +
                "]";
        //@formatter:on

        var actual = Arrays.toString(graph);

        assertEquals(expected, actual);
    }

    @Test
    void itColorsATwoDisjointGraphs() {
        var n1 = new Vertex(1);
        var n2 = new Vertex(2);
        var n3 = new Vertex(3);
        var n4 = new Vertex(4);

        n1.neighbors.add(n2);
        n2.neighbors.add(n1);

        n3.neighbors.add(n4);
        n4.neighbors.add(n3);

        var graph = new Vertex[] { n1, n2, n3, n4 };

        gc.color(graph, colors);

        //@formatter:off
        var expected =
                "[" +
                    "1:red=[2:green], " +
                    "2:green=[1:red], " +
                    "3:red=[4:green], " +
                    "4:green=[3:red]" +
                "]";
        //@formatter:on

        var actual = Arrays.toString(graph);

        assertEquals(expected, actual);
    }

    @Test
    void itColorsATriangularGraph() {
        var n1 = new Vertex(1);
        var n2 = new Vertex(2);
        var n3 = new Vertex(3);

        n1.neighbors.add(n2);
        n1.neighbors.add(n3);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n1);
        n3.neighbors.add(n2);

        var graph = new Vertex[] { n1, n2, n3 };

        gc.color(graph, colors);

        //@formatter:off
        var expected =
                "[" +
                    "1:red=[2:green, 3:blue], " +
                    "2:green=[1:red, 3:blue], " +
                    "3:blue=[1:red, 2:green]" +
                "]";
        //@formatter:on

        var actual = Arrays.toString(graph);

        assertEquals(expected, actual);
    }

    @Test
    void itColorsAnEnvelopeShapedGraph() {
        var n1 = new Vertex(1);
        var n2 = new Vertex(2);
        var n3 = new Vertex(3);
        var n4 = new Vertex(4);
        var n5 = new Vertex(5);

        n1.neighbors.add(n2);
        n1.neighbors.add(n3);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n2.neighbors.add(n4);
        n2.neighbors.add(n5);

        n3.neighbors.add(n1);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n3.neighbors.add(n5);

        n4.neighbors.add(n2);
        n4.neighbors.add(n3);
        n4.neighbors.add(n5);

        n5.neighbors.add(n2);
        n5.neighbors.add(n3);
        n5.neighbors.add(n4);

        var graph = new Vertex[] { n1, n2, n3, n4, n5 };

        gc.color(graph, colors);

        //@formatter:off
        var expected =
                "[" +
                    "1:red=[2:green, 3:blue], " +
                    "2:green=[1:red, 3:blue, 4:red, 5:orange], " +
                    "3:blue=[1:red, 2:green, 4:red, 5:orange], " +
                    "4:red=[2:green, 3:blue, 5:orange], " +
                    "5:orange=[2:green, 3:blue, 4:red]" +
                "]";
        //@formatter:on

        var actual = Arrays.toString(graph);

        assertEquals(expected, actual);
    }

    @Test
    void itFailsWhenTheGraphHasACycle() {
        var n1 = new Vertex(1);
        n1.neighbors.add(n1);
        try {
            gc.color(new Vertex[] { n1 }, colors);
            fail(new Throwable());
        } catch (RuntimeException ignored) {
        }
    }
}
