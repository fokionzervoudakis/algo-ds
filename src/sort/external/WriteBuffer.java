package sort.external;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class WriteBuffer {
    private static final int CHUNK_SIZE = 5;

    private final List<String> buffer = new ArrayList<>();

    private final BufferedWriter writer;

    WriteBuffer(String path) throws IOException {
        writer = Files.newBufferedWriter(Paths.get(path));
    }

    void add(String s) throws IOException {
        buffer.add(s);
        if (buffer.size() == CHUNK_SIZE) {
            write();
        }
    }

    void write() throws IOException {
        for (var s : buffer) {
            writer.write(s + '\n');
        }
        writer.flush();
        buffer.clear();
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
