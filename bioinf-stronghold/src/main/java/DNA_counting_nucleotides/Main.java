package DNA_counting_nucleotides;

import java.util.Scanner;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NucleotidesCounter counter = new NucleotidesCounter(scanner.next());
        System.out.println(counter.getResult());
        scanner.close();
    }
}
