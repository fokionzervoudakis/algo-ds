package interview;

import interview.KNearest.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class KNearestTest {
    private KNearest nearest;
    private List<Point> L;
    private Point origin;

    @BeforeEach
    void beforeEach() {
        nearest = new KNearest();
        L = new ArrayList<>() {{
            add(new Point(5, 5));
            add(new Point(4, 4));
            add(new Point(3, 3));
            add(new Point(2, 2));
        }};
        origin = new Point(1, 1);
    }

    @Test
    void itReturnsOneElement() {
        var expected = "[2,2]";
        var actual = nearest.getNearest(L, origin, 1).toString();
        assertEquals(expected, actual);
    }

    @Test
    void itReturnsManyElements() {
        var expected = "[3,3, 2,2]";
        var actual = nearest.getNearest(L, origin, 2).toString();
        assertEquals(expected, actual);
    }

    @Test
    void itFailsWhenKIsZero() {
        try {
            nearest.getNearest(L, origin, 0);
            fail(new Throwable());
        } catch (AssertionError ignored) {
        }
    }
}
