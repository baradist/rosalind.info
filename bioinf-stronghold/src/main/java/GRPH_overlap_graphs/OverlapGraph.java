package GRPH_overlap_graphs;

import common.FastaItem;
import common.Text;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleg Grigoryev on 08.07.2016.
 */
public class OverlapGraph {
    private Map<String, FastaItem> map;
    private List<FastaPair> edges;

    public OverlapGraph() {
        map = new HashMap<>();
        edges = new ArrayList<>();
    }

    public List<FastaPair> getEdges() {
        return edges;
    }

    public void setMap(Map<String, FastaItem> map) {
        this.map = map;
    }

    public void readFastaFile(String fileName) {
        try {
            setMap(Text.readFastaFile(new FileReader(fileName)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void findEdges() {
        for (Map.Entry<String, FastaItem> entry : map.entrySet()) {
            for (Map.Entry<String, FastaItem> entry1 : map.entrySet()) {
                if (entry == entry1) {
                    continue;
                }
                String value1 = entry1.getValue().getValue();
                if (entry.getValue().getValue().substring(0, 3).equals(
                        value1.substring(value1.length() - 3, value1.length()))) {
                    edges.add(new FastaPair(entry1.getValue(), entry.getValue()));
                }
            }
        }
    }

    public String getEdgesString() {
        StringBuilder sb = new StringBuilder();
        for (FastaPair edge : edges) {
            sb.append(edge.getLabels()).append("\n");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private class FastaPair {
        FastaItem tail;
        FastaItem head;

        public FastaPair(FastaItem tail, FastaItem head) {
            this.tail = tail;
            this.head = head;
        }

        public String getLabels() {
            return tail.getLabel() + " " + head.getLabel();
        }
    }
}
