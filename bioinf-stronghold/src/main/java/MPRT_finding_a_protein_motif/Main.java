package MPRT_finding_a_protein_motif;

import common.Text;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Oleg Grigoryev on 23.08.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<String> proteins = Text.readLinesList();
        Map<String, List<Integer>> stringListMap = ProteinMotifFinder.find(proteins, Pattern.compile("N[^P][ST][^P]"));

        ProteinMotifFinder.print(stringListMap);
    }
}
