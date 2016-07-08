package reader;

import common.FastaItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class TextReader {
    public static String read(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get("bioinf-stronghold/in/" + fileName)));
    }

    public static Map<String, FastaItem> readFastaFile(Reader reader) {
        Map<String, FastaItem> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new BufferedReader(reader))) {
            StringBuilder sb = new StringBuilder();
            String key = "";
            while (scanner.hasNext()) {
                String next = scanner.next();
                if (next.charAt(0) == '>') {
                    if (sb.length() > 0) {
                        map.put(key, new FastaItem(key, sb.toString()));
                        sb = new StringBuilder();
                    }
                    key = next.substring(1);
                } else {
                    sb.append(next);
                }
            }
            map.put(key, new FastaItem(key, sb.toString()));
        }
        return map;
    }
}
