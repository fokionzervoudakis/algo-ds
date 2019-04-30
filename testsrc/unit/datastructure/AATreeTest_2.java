package datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AATreeTest_2 {
    @Test
    void itBalancesAComplexTree() {
        var tree = new AATree();

        tree.add(24);
        tree.add(5);
        tree.add(28);
        tree.add(6);
        tree.add(94);
        tree.add(63);
        tree.add(19);

        //@formatter:off
        var expected =
                "(" +
                    "(" +
                        "(null 5:1 null) 6:2 (null 19:1 null)" +
                    ") 24:3 (" +
                        "(null 28:1 null) 63:2 (null 94:1 null)" +
                    ")" +
                ")";
        //@formatter:on

        var actual = tree.toString();

        assertEquals(expected, actual);
    }
}
