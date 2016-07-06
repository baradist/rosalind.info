package IPRB_mendels_first_law;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by 1 on 05.07.2016.
 */
public class ProbabilityTest {

    @Test
    public void getStringDominantProbability() throws Exception {
        Probability probability = new Probability();
        probability.setDominant(2);
        probability.setHybrid(2);
        probability.setRecessive(2);
        assertThat(probability.getStringDominantPhenotypePProbability(), is("0.78333"));

        probability.setDominant(21);
        probability.setHybrid(16);
        probability.setRecessive(26);
        assertThat(probability.getStringDominantPhenotypePProbability(), is("0.71173"));
    }
}