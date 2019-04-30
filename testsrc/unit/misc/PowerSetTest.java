package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerSetTest {
    private PowerSet<Integer> set;

    @BeforeEach
    void beforeEach() {
        set = new PowerSet<>();
    }

    @Test
    void itGeneratesThePowerSetOfZeroElements() {
        var expected = "[[]]";
        var actual = set.generate(new Integer[0]).toString();
        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesThePowerSetOfOneElement() {
        var expected = "[[], [1]]";
        var actual = set.generate(new Integer[] { 1 }).toString();
        assertEquals(expected, actual);
    }

    @Test
    void itGeneratesThePowerSetOfManyElements() {
        var expected = "[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]";
        var actual = set.generate(new Integer[] { 1, 2, 3 }).toString();
        assertEquals(expected, actual);
    }
}
