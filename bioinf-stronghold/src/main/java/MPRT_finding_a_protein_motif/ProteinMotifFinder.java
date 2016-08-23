package MPRT_finding_a_protein_motif;

import common.FastaItem;
import common.Text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Oleg_Grigoryev on 8/22/2016.
 */
public class ProteinMotifFinder {
    public static Map<String, List<Integer>> find(String protein, FastaItem item, Pattern pattern) {
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        Matcher matcher = pattern.matcher(item.getValue());
        int start = 0;
        while (matcher.find(start + 1)) {
            start = matcher.start();
            list.add(start + 1);
        }
        result.put(protein, list);
        return result;
    }

    public static Map<String, List<Integer>> find(List<String> proteins, Pattern pattern) {
        Map<String, List<Integer>> result = new TreeMap<>();
        try {
            for (String protein : proteins) {

                Map<String, FastaItem> map = Text.readFastaFile(new URL("http://www.uniprot.org/uniprot/" + protein + ".fasta"));
                Optional<Map.Entry<String, FastaItem>> first = map.entrySet().stream().findFirst();
                FastaItem item = null;
                if (first.isPresent()) {
                    Map.Entry<String, FastaItem> entry = first.get();
                    item = entry.getValue();
                    result.putAll(find(protein, item, pattern));
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void print(Map<String, List<Integer>> map) {
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                continue;
            }
            System.out.println(entry.getKey());
            System.out.println(Text.join(entry.getValue(), " "));
        }
    }
}
