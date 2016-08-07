package LCSM_FindingASharedMotif;

import common.Text;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleg Grigorjev on 07.08.2016.
 */
public class LongestCommonSubstringFinderTest {
    @Test
    public void test() throws FileNotFoundException {
        String text = ">Rosalind_1\n" +
                "GATTACA\n" +
                ">Rosalind_2\n" +
                "TAGACCA\n" +
                ">Rosalind_3\n" +
                "ATACA";
        LongestCommonSubstringFinder finder = new LongestCommonSubstringFinder();
        finder.setItems(Text.readFastaFile(new StringReader(text)).values());
        finder.evaluate();
        // http://rosalind.info/problems/lcsm/
        // here we have an example with the "AC" output
        // and they said: "If multiple solutions exist, you may return any single solution."
        // our implementation returns another possible result - "TA"
        // so, we will consider it, in order to pass the test
//        assertEquals("AC", finder.getResult());
        assertEquals("TA", finder.getResult());
    }
}