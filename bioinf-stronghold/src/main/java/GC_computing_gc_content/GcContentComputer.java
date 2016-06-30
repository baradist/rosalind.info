package GC_computing_gc_content;

import java.util.*;

/**
 * Created by 1 on 29.06.2016.
 */
public class GcContentComputer {
    private String dataset;
    private List<FastaItem> items;

    public GcContentComputer(String dataset) {
        this.dataset = dataset;
        items = new ArrayList<>();
        readItems();
        computeGcs();
        sortByGc();
    }

    private void computeGcs() {
        for (FastaItem item : items) {
            computeGc(item);
        }
    }

    private static void computeGc(FastaItem item) {
        String value = item.getValue();
        int gcCount = 0;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == 'G' || c == 'C') {
                gcCount++;
            }
        }
        item.setGc((double) gcCount * 100 / (double) value.length());
    }

    private void sortByGc() {
        Collections.sort(items, new Comparator<FastaItem>() {
            @Override
            public int compare(FastaItem o1, FastaItem o2) {
                return (int) (1000 * (o1.getGc() - o2.getGc()));
            }
        });
    }

    private void readItems() {
        int labelLength = "Rosalind_1312".length();
        for (String s : dataset.split(">")) {
            if (s.length() > 0) {
                String label = s.substring(0, labelLength);
                String value = s.substring(labelLength, s.length()).replace("\n", "").replace("\r", "");
                items.add(new FastaItem(label, value));
            }
        }
    }

    public String getOutput() {
        FastaItem item = items.get(items.size() - 1);
        return item.getLabel() + "\n"
                + String.format(Locale.ENGLISH, "%1$.6f", item.getGc());
    }

}
