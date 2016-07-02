package FIB_recurrence_relations;

import java.util.Scanner;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RabbitsCounter counter = new RabbitsCounter();
        System.out.println(counter.count(scanner.nextInt(), scanner.nextInt()));
        scanner.close();
    }
}
