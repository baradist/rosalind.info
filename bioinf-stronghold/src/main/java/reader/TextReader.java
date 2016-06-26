package reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class TextReader {
    public static String read(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get("bioinf-stronghold/in/" + fileName)));
    }
}
