package GC_computing_gc_content;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by 1 on 29.06.2016.
 */
public class GcContentComputerTest {
    @Test
    public void gcComputingTest() {
        GcContentComputer computer = new GcContentComputer(">Rosalind_6404\n" +
                "CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCC" +
                "TCCCACTAATAATTCTGAGG\n" +
                ">Rosalind_5959\n" +
                "CCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAGGCGCTCCGCCGAAGGTCT" +
                "ATATCCATTTGTCAGCAGACACGC\n" +
                ">Rosalind_0808\n" +
                "CCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGAC" +
                "TGGGAACCTGCGGGCAGTAGGTGGAAT");
        assertThat(computer.getOutput(), is("Rosalind_0808\n" +
                "60.919540"));
    }

}