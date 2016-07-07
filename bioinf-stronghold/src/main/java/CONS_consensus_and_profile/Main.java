package CONS_consensus_and_profile;

/**
 * Created by Oleg Grigoryev on 07.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Profile profile = new Profile();
        profile.readFastaFile("bioinf-stronghold/in/rosalind_cons.txt");
        profile.evaluate();
        System.out.println(profile.getConsensus());
        System.out.println(profile.getMatrix());
    }
}
