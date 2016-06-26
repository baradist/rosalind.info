package FIB_recurrence_relations;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class RabbitsCounterTest {
    RabbitsCounter counter;
    
    @Before
    public void before() {
        counter = new RabbitsCounter();
    }

    @Test
    public void count() throws Exception {
        assertThat(counter.count(5, 3), is(19L));
        assertThat(counter.count(6, 1), is(8L));
    }

}