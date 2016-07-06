package PROT_translation;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Oleg Grigorjev on 06.07.2016.
 */
public class TranslatorTest {

    @Test
    public void testGetProtein() throws Exception {
        Translator translator = new Translator("src/main/resources/PROT_translation/rna_to_protein.txt");
        assertThat(translator.getProtein("AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA"), is("MAMAPRTEINSTRING"));
    }
}