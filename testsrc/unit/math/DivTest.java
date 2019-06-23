package math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class DivTest {
    private Div div;

    @BeforeEach
    void beforeEach() {
        div = new Div();
    }

    @Test
    void itCalculatesTheQuotient() {
        assertEquals(0, div.quo(0, 1));
        assertEquals(1, div.quo(1, 1));
        assertEquals(4, div.quo(12, 3));
        assertEquals(4, div.quo(13, 3));
        assertEquals(5, div.quo(25, 5));
        assertEquals(5, div.quo(27, 5));
    }

    @Test
    void itCalculatesTheRemainder() {
        assertEquals(0, div.rem(0, 1));
        assertEquals(0, div.rem(1, 1));
        assertEquals(0, div.rem(12, 3));
        assertEquals(1, div.rem(13, 3));
        assertEquals(0, div.rem(25, 5));
        assertEquals(2, div.rem(27, 5));
    }

    @Test
    void itDoesNotDivideByZero_quo() {
        try {
            div.quo(0, 0);
            fail(new Throwable());
        } catch (RuntimeException ignored) {
        }
    }

    @Test
    void itDoesNotDivideByZero_rem() {
        try {
            div.rem(0, 0);
            fail(new Throwable());
        } catch (RuntimeException ignored) {
        }
    }
}
