package REVC_reverse_complementing;

import common.Text;

import java.io.IOException;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ReverseComplementer complementer = new ReverseComplementer(Text.read("bioinf-stronghold/in/rosalind_revc.txt"));
        System.out.println(complementer.getResult());
    }
}
