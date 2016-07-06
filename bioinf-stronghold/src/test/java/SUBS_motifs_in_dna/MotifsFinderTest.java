package SUBS_motifs_in_dna;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Oleg Grigoryev on 06.07.2016.
 */
public class MotifsFinderTest {
    MotifsFinder finder;
    @Before
    public void before() {
        finder = new MotifsFinder();
    }

    @Test
    public void test() throws Exception {
        finder.setString("GATATATGCATATACTT");
        finder.setSubString("ATAT");
        assertThat(finder.getLocations(), is("2 4 10"));
    }

    @Test
    public void testEndsMatches() throws Exception {
        finder.setString("GATA");
        finder.setSubString("ATA");
        assertThat(finder.getLocations(), is("2"));
    }

    @Test
    public void testSubstringIsOutOfIndex() throws Exception {
        finder.setString("GATA");
        finder.setSubString("ATAA");
        assertThat(finder.getLocations(), is(""));
    }
}