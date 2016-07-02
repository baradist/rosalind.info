package HAMM_counting_point_mutations;

import java.util.Scanner;

/**
 * Created by 1 on 02.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        PointMutationsCounter counter = new PointMutationsCounter();
        Scanner scanner = new Scanner(System.in);
        counter.setString1(scanner.nextLine());
        counter.setString2(scanner.nextLine());
        scanner.close();
        System.out.println(counter.getHammingDistance());
    }
}
