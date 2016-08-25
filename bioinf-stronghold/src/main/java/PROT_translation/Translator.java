package PROT_translation;

import common.Text;

import java.util.Map;

/**
 * Created by Oleg Grigorjev on 06.07.2016.
 */
public class Translator {
    private Map<String, String> dictionary;

    public Translator() {
        readDictionary();
    }

    public String getProtein(String rna) {
        StringBuilder proteinSb = new StringBuilder();
        for (int i = 0; i < rna.length(); i += 3) {
            String codon = dictionary.get(rna.substring(i, i + 3));
            if (codon.equalsIgnoreCase("Stop")) {
                break;
            }
            proteinSb.append(codon);
        }
        return proteinSb.toString();
    }

    private void readDictionary() {
        dictionary = Text.readRnaToCodonTable();
    }
}
