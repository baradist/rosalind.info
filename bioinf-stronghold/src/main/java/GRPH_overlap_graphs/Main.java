package GRPH_overlap_graphs;

import common.Text;

/**
 * Created by Oleg Grigoryev on 09.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        OverlapGraph graph = new OverlapGraph();
        graph.readFastaFile("bioinf-stronghold/in/rosalind_grph.txt");
        graph.findEdges();
        Text.write("bioinf-stronghold/out/rosalind_grph.txt", graph.getEdgesString());
    }
}
