package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SLList_stack {
    private SLList<Integer>.Stack stack;

    @BeforeEach
    void beforeEach() {
        stack = new SLList<Integer>().new Stack();
    }

    @Test
    void itPushesElements() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        var expected = "[3] -> [2] -> [1] -> null";
        var actual = stack.toString();

        assertEquals(expected, actual);
    }

    @Test
    void itPopsElements() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop().intValue());
        assertEquals(2, stack.pop().intValue());

        stack.push(4);

        var expected = "[4] -> [1] -> null";
        var actual = stack.toString();

        assertEquals(expected, actual);
    }
}
