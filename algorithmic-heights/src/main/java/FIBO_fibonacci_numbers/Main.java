package FIBO_fibonacci_numbers;

import java.util.Scanner;

/**
 * Created by 1 on 26.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fibonacci fibonacci = new Fibonacci();
        if (scanner.hasNextInt()) {
            System.out.println(fibonacci.getValue(scanner.nextInt()));
        }
    }
}
