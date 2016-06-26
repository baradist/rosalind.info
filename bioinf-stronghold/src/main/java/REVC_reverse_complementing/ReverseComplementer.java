package REVC_reverse_complementing;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class ReverseComplementer {
    private String dataset;

    public ReverseComplementer(String dataset) {
        this.dataset = dataset;
    }

    public String getResult() {
        reverse();
        return dataset;
    }

    private void reverse() {
        StringBuilder result = new StringBuilder(dataset).reverse();
        for (int i = 0; i < result.length(); i++) {
            switch (result.charAt(i)) {
                case 'A':
                    result.setCharAt(i, 'T');
                    break;
                case 'T':
                    result.setCharAt(i, 'A');
                    break;
                case 'C':
                    result.setCharAt(i, 'G');
                    break;
                case 'G':
                    result.setCharAt(i, 'C');
                    break;
            }
        }
        dataset = result.toString();
    }
}
