package REVC_reverse_complementing;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class ReverseComplementerTest {
    @Test
    public void getResult() throws Exception {
        ReverseComplementer complementer = new ReverseComplementer("AAAACCCGGT");
        assertThat(complementer.getResult(), is("ACCGGGTTTT"));
    }

}