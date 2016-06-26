package FIBO_fibonacci_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 26.06.2016.
 */
public class Fibonacci {
    private List<Long> numbers;

    public Fibonacci() {
        numbers = new ArrayList<>();
        numbers.add(0L);
        numbers.add(1L);
    }

    public long getValue(int n) {
        for (int i = numbers.size(); i <= n; i++) {
            numbers.add(numbers.get(i -1) + numbers.get(i - 2));
        }
//        if (numbers.size() > n) {
            return numbers.get(n);
//        }
    }
}
