package HAMM_counting_point_mutations;

/**
 * Created by 1 on 02.07.2016.
 */
public class PointMutationsCounter {
    private String string1;
    private String string2;
    private int hammingDistance;

    public void setString1(String string1) {
        this.string1 = string1;
        countHammingDistance();
    }

    public void setString2(String string2) {
        this.string2 = string2;
        countHammingDistance();
    }

    public int getHammingDistance() {
        return hammingDistance;
    }

    private void countHammingDistance() {
        if (string1 == null || string2 == null) {
            return;
        }
        if (!(string1.length() > 0 && string2.length() > 0
                && string1.length() == string2.length())) { // in this task strings have the same length
            return;
        }
        hammingDistance = 0;
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                hammingDistance++;
            }
        }
    }
}
