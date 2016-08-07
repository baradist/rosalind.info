package DNA_counting_nucleotides;

import common.Text;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class NucleotidesCounter {
    private Map<Character, Integer> nucleotides;

    public NucleotidesCounter() {
        this.nucleotides = new TreeMap<>();
    }

    public NucleotidesCounter(String dataset) {
        this();
        countSymbols(dataset);
    }

    public String getResult() {
        return Text.join(nucleotides.values(), " ");
    }

    private void countSymbols(String dataset) {
        for (int i = 0; i < dataset.length(); i++) {
            char charAt = dataset.charAt(i);
            if (nucleotides.containsKey(charAt)) {
                nucleotides.put(charAt, nucleotides.get(charAt) + 1);
            } else {
                nucleotides.put(charAt, 1);
            }
        }
    }
}
