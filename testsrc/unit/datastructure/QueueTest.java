package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueTest {
    private Queue<Integer> Q;

    @BeforeEach
    void beforeEach() {
        Q = new Queue<>();
        Q.enqueue(1);
        Q.enqueue(2);
        Q.enqueue(3);
        Q.enqueue(4);
    }

    @Nested
    class WhenItAddsElementsOntoTheQueue {
        @Test
        void itIncreasesTheSizeOfTheBackingArrayIfItsCapacityIsExceeded() {
            Q.enqueue(5);
            Q.enqueue(6);

            var expected = "[1, 2, 3, 4, 5, 6, null, null, null, null]";
            var actual = Q.toString();

            assertEquals(expected, actual);
        }

        @Test
        void itDoesNotResizeTheBackingArrayIfItsCapacityIsNotExceeded() {
            Q.enqueue(5);
            assertEquals("[1, 2, 3, 4, 5]", Q.toString());
        }
    }

    @Nested
    class WhenItRemovesElementsFromTheQueue {
        @Test
        void itReturnsTheElementAtTheHeadOfTheQueue() {
            assertEquals(1, Q.dequeue().intValue());
            assertEquals(2, Q.dequeue().intValue());
        }

        @Test
        void itReplacesRemovedElements() {
            Q.dequeue();
            Q.dequeue();
            Q.enqueue(5);
            Q.enqueue(6);
            assertEquals("[6, 2, 3, 4, 5]", Q.toString());
        }

        @Test
        void itReducesTheSizeOfTheBackingArrayIfItsCapacityIsExcessive() {
            Q.dequeue();
            Q.dequeue();
            Q.dequeue();
            assertEquals("[4, null]", Q.toString());
        }

        @Test
        void itDoesNotResizeTheBackingArrayIfItsCapacityIsNotExcessive() {
            Q.dequeue();
            Q.dequeue();
            assertEquals("[1, 2, 3, 4, null]", Q.toString());
        }

        @Test
        void itAddsElementsToTheHeadOfTheQueueAfterEachResize() {
            Q.dequeue();
            Q.dequeue();
            Q.dequeue();
            Q.enqueue(5);
            Q.enqueue(6);
            assertEquals("[4, 5, 6, null]", Q.toString());
        }
    }
}
