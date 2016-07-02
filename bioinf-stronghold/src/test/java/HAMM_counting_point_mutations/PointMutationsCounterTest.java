package HAMM_counting_point_mutations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by 1 on 02.07.2016.
 */
public class PointMutationsCounterTest {

    @Test
    public void testGetHammingDistance() throws Exception {
        PointMutationsCounter counter = new PointMutationsCounter();
        counter.setString1("GAGCCTACTAACGGGAT");
        counter.setString2("CATCGTAATGACGGCCT");
        assertThat(counter.getHammingDistance(), is(7));
    }
}