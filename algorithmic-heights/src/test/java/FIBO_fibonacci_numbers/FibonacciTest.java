package FIBO_fibonacci_numbers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by 1 on 26.06.2016.
 */
public class FibonacciTest {

    @Test
    public void testGetValue() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        assertThat(fibonacci.getValue(6), is(8L));
        assertThat(fibonacci.getValue(10), is(55L));
        assertThat(fibonacci.getValue(7), is(13L));
    }
}