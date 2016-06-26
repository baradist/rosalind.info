package BINS_binary_search;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class BinarySearchTest {

    @Test
    public void testReadData() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        String exampleString = "5\n" +
                "6\n" +
                "10 20 30 40 50\n" +
                "40 10 35 15 40 20";
        InputStream systemIn = System.in;
        System.setIn(new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8)));
        binarySearch.readData();
        System.setIn(systemIn);
        assertThat(binarySearch.getResult(), is("4 1 -1 -1 4 2"));
    }
}