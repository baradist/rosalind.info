package GC_computing_gc_content;

import REVC_reverse_complementing.ReverseComplementer;
import reader.TextReader;

import java.io.IOException;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        GcContentComputer computer = new GcContentComputer(TextReader.read("rosalind_gc.txt"));
        System.out.println(computer.getOutput());
    }
}
