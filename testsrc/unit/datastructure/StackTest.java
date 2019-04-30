package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {
    private Stack<Integer> S;

    @BeforeEach
    void beforeEach() {
        S = new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);
    }

    @Nested
    class WhenItPushesElementsOntoTheStack {
        @Test
        void itIncreasesTheSizeOfTheBackingArrayIfItsCapacityIsExceeded() {
            S.push(5);
            S.push(6);

            var expected = "[1, 2, 3, 4, 5, 6, null, null, null, null]";
            var actual = S.toString();

            assertEquals(expected, actual);
        }

        @Test
        void itDoesNotResizeTheBackingArrayIfItsCapacityIsNotExceeded() {
            S.push(5);
            assertEquals("[1, 2, 3, 4, 5]", S.toString());
        }
    }

    @Nested
    class WhenItPopsElementsFromTheStack {
        @Test
        void itReturnsTheTopElement() {
            assertEquals(4, S.pop().intValue());
            assertEquals(3, S.pop().intValue());
        }

        @Test
        void itReplacesPoppedElements() {
            S.pop();
            S.pop();
            S.push(5);
            S.push(6);
            assertEquals("[1, 2, 5, 6, null]", S.toString());
        }

        @Test
        void itReducesTheSizeOfTheBackingArrayIfItsCapacityIsExcessive() {
            S.pop();
            S.pop();
            S.pop();
            assertEquals("[1, null]", S.toString());
        }

        @Test
        void itDoesNotResizeTheBackingArrayIfItsCapacityIsNotExcessive() {
            S.pop();
            S.pop();
            assertEquals("[1, 2, 3, 4, null]", S.toString());
        }

        @Test
        void itPushesElementsToTheTopOfTheStackAfterEachResize() {
            S.pop();
            S.pop();
            S.pop();
            S.push(5);
            S.push(6);
            assertEquals("[1, 5, 6, null]", S.toString());
        }
    }
}
