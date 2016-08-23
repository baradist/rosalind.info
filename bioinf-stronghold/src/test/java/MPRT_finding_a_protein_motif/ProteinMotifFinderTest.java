package MPRT_finding_a_protein_motif;

import common.Text;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleg Grigoryev on 22.08.2016.
 */
public class ProteinMotifFinderTest {
    Pattern pattern = Pattern.compile("N[^P][ST][^P]");

    @Test
    public void testFind() throws Exception {
        List<String> proteins = Text.getStrings("A0QQ98\n" +
                "P01044_KNH1_BOVIN\n" +
                "B3CNE0\n" +
                "O82484\n" +
                "P00743_FA10_BOVIN\n");
        Map<String, List<Integer>> stringListMap = ProteinMotifFinder.find(proteins, pattern);

        Map<String, List<Integer>> stringListMap1 = new TreeMap<>();
        stringListMap1.put("A0QQ98", Arrays.asList(44));
        stringListMap1.put("B3CNE0", Arrays.asList(107));
        stringListMap1.put("O82484", Arrays.asList(104, 108, 546, 742, 765));
        stringListMap1.put("P00743_FA10_BOVIN", Arrays.asList(218));
        stringListMap1.put("P01044_KNH1_BOVIN", Arrays.asList(47, 87, 168, 169, 197, 204));

        assertEquals(stringListMap, stringListMap1);
        ProteinMotifFinder.print(stringListMap);
        ProteinMotifFinder.print(stringListMap1);
    }

    @Test
    public void testFind1() throws Exception {
        List<String> proteins = Text.getStrings("A2Z669\n" +
                "B5ZC00\n" +
                "P07204_TRBM_HUMAN\n" +
                "P20840_SAG1_YEAST");
        Map<String, List<Integer>> stringListMap = ProteinMotifFinder.find(proteins, pattern);

        Map<String, List<Integer>> stringListMap1 = new TreeMap<>();
        stringListMap1.put("A2Z669", Arrays.asList());
        stringListMap1.put("B5ZC00", Arrays.asList(85, 118, 142, 306, 395));
        stringListMap1.put("P07204_TRBM_HUMAN", Arrays.asList(47, 115, 116, 382, 409));
        stringListMap1.put("P20840_SAG1_YEAST", Arrays.asList(79, 109, 135, 248, 306, 348, 364, 402, 485, 501, 614));

        assertEquals(stringListMap, stringListMap1);
        ProteinMotifFinder.print(stringListMap);
        ProteinMotifFinder.print(stringListMap1);
    }
}
