package common;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class Text {
    public static String read(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void write(String fileName, String value) {
        try {
            write(fileName, value, StandardCharsets.UTF_16);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String fileName, String value, Charset charset) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), charset))) {
            writer.write(value);
        }
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

    public static String join(Iterable iterable, String separator) {
        StringJoiner sj = new StringJoiner(separator);
        iterable.forEach(e -> sj.add(e.toString()));
        return sj.toString();
    }
}
