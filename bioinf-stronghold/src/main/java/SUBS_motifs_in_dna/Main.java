package SUBS_motifs_in_dna;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Oleg Grigoryev on 06.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("bioinf-stronghold/in/rosalind_subs.txt")))) {
            MotifsFinder finder = new MotifsFinder();
            finder.setString(scanner.next());
            finder.setSubString(scanner.next());
            System.out.println(finder.getLocations());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
