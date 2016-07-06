package PROT_translation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Oleg Grigorjev on 06.07.2016.
 */
public class Translator {
    private Map<String, String> dictionary;
    private String dictionaryFile;

    public Translator(String dictionaryFile) {
        this.dictionaryFile = dictionaryFile;
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
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(dictionaryFile)))) {
            dictionary = new HashMap<>(20);
            String key = null;
            while (scanner.hasNext()) {
                String next = scanner.next();
                if (next.length() == 3) {
                    key = next;
                } else {
                    dictionary.put(key, next);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
