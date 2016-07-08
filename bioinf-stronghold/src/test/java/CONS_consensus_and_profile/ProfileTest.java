package CONS_consensus_and_profile;

import org.junit.Test;
import reader.TextReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Oleg Grigoryev on 07.07.2016.
 */
public class ProfileTest {
    @Test
    public void test() throws FileNotFoundException {
        String text = ">Rosalind_1\n" +
                "ATCCAGCT\n" +
                ">Rosalind_2\n" +
                "GGGCAACT\n" +
                ">Rosalind_3\n" +
                "ATGGATCT\n" +
                ">Rosalind_4\n" +
                "AAGCAACC\n" +
                ">Rosalind_5\n" +
                "TTGGAACT\n" +
                ">Rosalind_6\n" +
                "ATGCCATT\n" +
                ">Rosalind_7\n" +
                "ATGGCACT";
        Profile profile = new Profile();
        profile.setStrings(TextReader.readFastaFile(new StringReader(text)).values());
        profile.evaluate();
        assertThat(profile.getConsensus(), is("ATGCAACT"));
        assertThat(profile.getMatrix(), is("A: 5 1 0 0 5 5 0 0\n" +
                "C: 0 0 1 4 2 0 6 1\n" +
                "G: 1 1 6 3 0 1 0 0\n" +
                "T: 1 5 0 0 0 1 1 6"));
    }
}