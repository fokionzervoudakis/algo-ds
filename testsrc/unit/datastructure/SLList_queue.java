package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SLList_queue {
    private SLList<Integer>.Queue queue;

    @BeforeEach
    void beforeEach() {
        queue = new SLList<Integer>().new Queue();
    }

    @Test
    void itAddsElements() {
        queue.add(1);
        queue.add(2);
        queue.add(3);

        var expected = "[1] -> [2] -> [3] -> null";
        var actual = queue.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itRemovesElements() {
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertEquals(1, queue.remove().intValue());
        assertEquals(2, queue.remove().intValue());

        queue.add(4);

        var expected = "[3] -> [4] -> null";
        var actual = queue.toString();

        assertEquals(expected, actual);
    }
}
