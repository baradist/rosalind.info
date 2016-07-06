package IPRB_mendels_first_law;

import java.util.Scanner;

/**
 * Created by 1 on 06.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Probability probability = new Probability();
        probability.setDominant(scanner.nextInt());
        probability.setHybrid(scanner.nextInt());
        probability.setRecessive(scanner.nextInt());
        scanner.close();
        System.out.println(probability.getStringDominantPhenotypePProbability());
    }
}
