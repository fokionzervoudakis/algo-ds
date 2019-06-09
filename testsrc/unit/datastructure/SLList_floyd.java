package datastructure;

import datastructure.SLList.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SLList_floyd {
    @Test
    void itReturnsNullWhenTheListIsNull() {
        assertNull(SLList.floyd(null));
    }

    @Nested
    class WhenTheListIsNotNull {
        private Node<Integer> N1;

        @BeforeEach
        void beforeEach() {
            N1 = new Node<>(1);
        }

        @Test
        void itReturnsNullWhenTheListHasOneNode() {
            assertNull(SLList.floyd(N1));
        }

        @Test
        void itReturnsNullWhenTheListHasManyNodesWithoutACycle() {
            var N2 = new Node<>(2);
            var N3 = new Node<>(3);
            var N4 = new Node<>(4);

            N1.next = N2;
            N2.next = N3;
            N3.next = N4;

            assertNull(SLList.floyd(N1));
        }

        @Test
        void itReturnsTheStartOfTheCycleWhenTheListHasOneNode() {
            N1.next = N1;
            assertEquals(N1, SLList.floyd(N1));
        }

        @Test
        void itReturnsTheStartOfTheCycleWhenTheListHasTwoNodes() {
            var N2 = new Node<>(2);
            N1.next = N2;
            N2.next = N1;
            assertEquals(N1, SLList.floyd(N1));
        }

        @Test
        void itReturnsTheStartOfTheCycleWhenTheListHasManyNodes() {
            var N2 = new Node<>(2);
            var N3 = new Node<>(3);
            var N4 = new Node<>(4);

            N1.next = N2;
            N2.next = N3;
            N3.next = N4;
            N4.next = N2;

            assertEquals(N2, SLList.floyd(N1));
        }
    }
}
