package LCSM_FindingASharedMotif;

/**
 * Created by Oleg Grigorjev on 07.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        LongestCommonSubstringFinder finder = new LongestCommonSubstringFinder();
        finder.readFastaFile("bioinf-stronghold/in/rosalind_lcsm.txt");
        finder.evaluate();
        System.out.println(finder.getResult());
    }
}
