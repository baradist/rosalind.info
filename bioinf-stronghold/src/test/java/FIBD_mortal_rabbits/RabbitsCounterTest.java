package FIBD_mortal_rabbits;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Oleg Grigoryev on 08.07.2016.
 */
public class RabbitsCounterTest {

    RabbitsCounter counter;

    @Before
    public void before() {
        counter = new RabbitsCounter();
    }

    @Test
    public void count() throws Exception {
        assertThat(counter.count(6, 3), is(BigInteger.valueOf(4)));
        assertThat(counter.count(95, 16), is(new BigInteger("31420276473714305295")));
    }
}