package sort.external;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.LinkedList;

class ReadBuffer {
    private static final int CHUNK_SIZE = 5;

    private final Deque<String> buffer = new LinkedList<>();

    private final BufferedReader reader;

    ReadBuffer(String path) throws IOException {
        reader = Files.newBufferedReader(Paths.get(path));
        read();
    }

    void read() throws IOException {
        var i = 0;
        String line;
        while (i++ < CHUNK_SIZE && (line = reader.readLine()) != null) {
            buffer.addLast(line);
        }
    }

    String next() {
        return (buffer.isEmpty()) ? null : buffer.getFirst();
    }

    String remove() throws IOException {
        if (buffer.isEmpty()) {
            read();
        }
        return (buffer.isEmpty()) ? null : buffer.removeFirst();
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
