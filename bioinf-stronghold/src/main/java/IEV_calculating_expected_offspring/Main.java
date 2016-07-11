package IEV_calculating_expected_offspring;

import java.util.Scanner;

/**
 * Created by Oleg Grigorjev on 12.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Offspring offspring = new Offspring();
        double v = offspring.calculate(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
                scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println(v);
        scanner.close();
    }
}
