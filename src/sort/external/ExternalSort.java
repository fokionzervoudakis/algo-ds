package sort.external;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ExternalSort {
    private static final int SIZE = 10;

    void sort(String inPath, String outPath) throws IOException {
        var paths = new ArrayList<String>();
        var lines = new String[SIZE];
        int i = 0, j = 0;
        try (var reader = Files.newBufferedReader(Paths.get(inPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines[i] = line;
                if (++i == SIZE) {
                    var path = outPath + ++j;
                    write(MergeSort.sort(lines), path);
                    paths.add(path);
                    for (var k = 0; k < SIZE; k++) {
                        lines[k] = null;
                    }
                    i = 0;
                }
            }
        }
        if (i > 0) {
            var path = outPath + ++j;
            write(MergeSort.sort(lines), path);
            paths.add(path);
        }
        merge(paths, outPath + ++j);
    }

    private void write(Object[] lines, String path) throws IOException {
        try (var writer = Files.newBufferedWriter(Paths.get(path))) {
            for (var line : lines) {
                writer.write(line + "\n");
            }
        }
    }

    /**
     Implements disk-backed, single-pass, naive <em>k-way merging</em>.
     <p>Worst-case time complexity: O((k−1)(n−k/2))

     @param inPaths a list of file paths to sorted input lists
     @param outPath a file path to the final sorted file
     @throws IOException if an I/O error occurs
     @see <a href="https://en.wikipedia.org/wiki/Merge_algorithm#K-way_merging">K-way
     merging</a>
     @see <a href="https://en.wikipedia.org/wiki/External_sorting#Additional_passes">Additional
     passes</a>
     */
    private void merge(List<String> inPaths, String outPath) throws IOException {
        // Initialize the input...
        // TODO replace single-pass merging with multi-pass merging
        var readBuffers = new ArrayList<ReadBuffer>();
        for (var inPath : inPaths) {
            readBuffers.add(new ReadBuffer(inPath));
        }

        // and output buffers.
        var writeBuffer = new WriteBuffer(outPath);

        while (true) {
            // Find the buffer with the minimum element...
            // TODO use a min-heap to find minimum elements
            ReadBuffer min = null;
            for (var buffer : readBuffers) {
                String s1, s2 = buffer.next();
                if (min == null || (s1 = min.next()) != null && s2 != null && s1.compareTo(s2) > 0) {
                    min = buffer;
                }
            }
            if (min == null || min.next() == null) {
                // and either exit if all input buffers are empty...
                break;
            } else {
                // or output the minimum element and remove it from its buffer.
                writeBuffer.add(min.remove());
            }
        }

        writeBuffer.write();
    }
}
