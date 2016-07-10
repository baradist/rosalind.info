package GRPH_overlap_graphs;

import org.junit.Test;
import common.Text;

import java.io.StringReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Oleg Grigoryev on 09.07.2016.
 */
public class OverlapGraphTest {

    @Test
    public void testGetEdgesString() throws Exception {
        String text = ">Rosalind_0498\n" +
                "AAATAAA\n" +
                ">Rosalind_2391\n" +
                "AAATTTT\n" +
                ">Rosalind_2323\n" +
                "TTTTCCC\n" +
                ">Rosalind_0442\n" +
                "AAATCCC\n" +
                ">Rosalind_5013\n" +
                "GGGTGGG";
        OverlapGraph graph = new OverlapGraph();
        graph.setMap(Text.readFastaFile(new StringReader(text)));
        graph.findEdges();
        assertTrue(graph.getEdgesString().contains("Rosalind_0498 Rosalind_2391"));
        assertTrue(graph.getEdgesString().contains("Rosalind_0498 Rosalind_0442"));
        assertTrue(graph.getEdgesString().contains("Rosalind_2391 Rosalind_2323"));
    }
}