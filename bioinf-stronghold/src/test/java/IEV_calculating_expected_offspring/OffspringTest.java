package IEV_calculating_expected_offspring;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * Created by Oleg Grigorjev on 11.07.2016.
 */
public class OffspringTest {
    Offspring offspring;
    @Before
    public void setUp() throws Exception {
        offspring = new Offspring();
    }

    @Test
    public void calculate() throws Exception {

        assertThat(
                offspring.calculate(1, 0, 0, 1, 0, 1)
                , is(3.5));
        assertThat(
                offspring.calculate(18198, 18275, 17577, 18451, 16264, 16186)
                , is(152040.5));
    }

}