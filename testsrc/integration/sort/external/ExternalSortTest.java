package sort.external;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExternalSortTest {
    private ExternalSort externalSort;

    @BeforeEach
    void beforeEach() throws Exception {
        var dir = new File("testdata/tmp");
        FileUtils.deleteDirectory(dir);
        FileUtils.forceMkdir(dir);
        externalSort = new ExternalSort();
    }

    @Test
    void itSortsZeroElements() throws Exception {
        externalSort.sort("testdata/sort/external/in-1", "testdata/tmp/");
        var expected = "";
        var actual = readFileToString("testdata/tmp/1");
        assertEquals(expected, actual);
    }

    @Test
    void itSortsManyElements() throws Exception {
        externalSort.sort("testdata/sort/external/in-2", "testdata/tmp/");
        var expected = readFileToString("testdata/sort/external/out");
        var actual = readFileToString("testdata/tmp/11");
        assertEquals(expected, actual);
    }

    private String readFileToString(String path) throws Exception {
        return FileUtils.readFileToString(new File(path), "UTF-8");
    }
}
