package RNA_dna_into_rna;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class TranscriberTest {
    @Test
    public void getValue() throws Exception {
        Transcriber transcriber = new Transcriber("GATGGAACTTGACTACGTAAATT");
        assertThat(transcriber.getValue(), is("GAUGGAACUUGACUACGUAAAUU"));
    }

}