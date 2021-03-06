package SUBS_motifs_in_dna;

import common.Text;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg Grigoryev on 06.07.2016.
 */
@Setter
public class MotifsFinder {
    private String string;
    private String subString;

    public String getLocations() {
        List<Integer> locations = new ArrayList<>();

        int stringLength = string.length();
        int subStringLength = subString.length();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == subString.charAt(0)) {
                if (stringLength < subStringLength + i) {
                    break;
                }
                if (string.substring(i, subStringLength + i).equals(subString)) {
                    locations.add(i + 1);
                }
            }
        }
        return Text.join(locations, " ");
    }
}
