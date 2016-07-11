package IEV_calculating_expected_offspring;

/**
 * Created by Oleg Grigorjev on 11.07.2016.
 */
public class Offspring {
    public double calculate(int AA_AA,
                            int AA_Aa,
                            int AA_aa,
                            int Aa_Aa,
                            int Aa_aa,
                            int aa_aa) {
        
        return (double) AA_AA * 2.0
                + (double) AA_Aa * 2.0
                + (double) AA_aa * 2.0
                + (double) Aa_Aa * 2.0 * 3 / 4
                + (double) Aa_aa * 2.0 / 2
                + (double) aa_aa * 2.0 * 0;
    }
}
