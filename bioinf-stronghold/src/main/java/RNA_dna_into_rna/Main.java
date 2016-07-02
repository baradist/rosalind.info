package RNA_dna_into_rna;

import java.util.Scanner;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Transcriber transcriber = new Transcriber(scanner.next());
        System.out.println(transcriber.getValue());
        scanner.close();
    }
}
