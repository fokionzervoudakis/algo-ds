package sort.external;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WriteBufferTest {
    private WriteBuffer buffer;

    @BeforeEach
    void beforeEach() throws Exception {
        var dir = new File("testdata/tmp");
        FileUtils.deleteDirectory(dir);
        dir.mkdirs();
        buffer = new WriteBuffer("testdata/tmp/test");
    }

    @Test
    void itAddsElementsToTheBuffer() throws Exception {
        buffer.add("a");
        buffer.add("b");
        buffer.add("c");

        var expected = "[a, b, c]";
        var actual = buffer.toString();

        assertEquals(expected, actual);
    }

    @Nested
    class WhenTheBufferIsFull {
        @BeforeEach
        void beforeEach() throws Exception {
            buffer.add("1");
            buffer.add("2");
            buffer.add("3");
            buffer.add("4");
            buffer.add("5");
        }

        @Test
        void itWritesElementsToDisk() throws Exception {
            var expected = "1\n2\n3\n4\n5\n";
            var actual = readFileToString();
            assertEquals(expected, actual);
        }

        @Test
        void itClearsTheBuffer() {
            var expected = "[]";
            var actual = buffer.toString();
            assertEquals(expected, actual);
        }

        @Test
        void itAppendsElementsWhenItWritesToDisk() throws Exception {
            buffer.add("6");
            buffer.add("7");
            buffer.add("8");
            buffer.add("9");
            buffer.add("10");
            var expected = "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n";
            var actual = readFileToString();
            assertEquals(expected, actual);
        }

        private String readFileToString() throws Exception {
            return FileUtils.readFileToString(new File("testdata/tmp/test"), "UTF-8");
        }
    }
}
