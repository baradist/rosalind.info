package GC_computing_gc_content;

import common.Text;

import java.io.IOException;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        GcContentComputer computer = new GcContentComputer(Text.read("bioinf-stronghold/in/rosalind_gc.txt"));
        System.out.println(computer.getOutput());
    }
}
