package common;

import lombok.Data;

/**
 * Created by Oleg Grigoryev on 29.06.2016.
 */
@Data
public class FastaItem {
    private String label;
    private String value;
    private double gc;

    public FastaItem(String label, String value) {
        this.label = label;
        this.value = value;
    }
}
