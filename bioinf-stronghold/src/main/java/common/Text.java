package common;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

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

    public static Map<String, FastaItem> readFastaFile(URL url) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            return readFastaFile(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public static Map<String, FastaItem> readFastaFile(Reader reader) {
        Map<String, FastaItem> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new BufferedReader(reader))) {
            StringBuilder sb = new StringBuilder();
            String key = "";
            while (scanner.hasNext()) {
                String next = scanner.nextLine();
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

    public static List<String> getStrings(String text) {
        return Arrays.asList(text.split("\n"));
    }

    /**
     * making list of strings
     * to exit type empty string
     * @return
     * @throws IOException
     */
    public static List<String> readLinesList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> proteins = new ArrayList<>();

        String line = null;
        while (!(line = reader.readLine()).equals("")) {
            proteins.add(line);
        }
        return proteins;
    }

    public static Map<String, String> readRnaToCodonTable() {
        Properties prop = new Properties();
        String propFileName = "rna_to_codon.properties";
        InputStream inputStream;
        inputStream = Text.class.getClassLoader().getResourceAsStream(propFileName);
        try {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> dictionary = prop.entrySet().stream().
                collect(Collectors.toMap(e -> (String) e.getKey(), e -> (String) e.getValue()));
        return dictionary;
    }
}
