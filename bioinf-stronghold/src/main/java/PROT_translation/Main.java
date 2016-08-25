package PROT_translation;

import common.Text;
import java.io.IOException;

/**
 * Created by Oleg Grigorjev on 06.07.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Translator translator = new Translator();
        System.out.println(translator.getProtein((Text.read("bioinf-stronghold/in/rosalind_prot.txt"))));
    }
}
