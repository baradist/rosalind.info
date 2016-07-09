package CONS_consensus_and_profile;

import common.FastaItem;
import common.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Oleg Grigoryev on 07.07.2016.
 */
public class Profile {
    private List<FastaItem> items;
    private String consensus;
    private List<MatrixColumn> matrix;

    public Profile() {
        this.items = new ArrayList<>();
    }

    public String getConsensus() {
        return consensus;
    }

    public String getMatrix() {
        StringBuilder sb = new StringBuilder();
        sb.append("A:");
        for (MatrixColumn column : matrix) {
            sb.append(" ").append(column.countA);
        }
        sb.append("\nC:");
        for (MatrixColumn column : matrix) {
            sb.append(" ").append(column.countC);
        }
        sb.append("\nG:");
        for (MatrixColumn column : matrix) {
            sb.append(" ").append(column.countG);
        }
        sb.append("\nT:");
        for (MatrixColumn column : matrix) {
            sb.append(" ").append(column.countT);
        }
        return sb.toString();
    }

    public void readFastaFile(String fileName) {
        try {
            setItems(Text.readFastaFile(new FileReader(fileName)).values());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setItems(Collection<FastaItem> items) {
        this.items = new ArrayList<>(items);
    }

    public void evaluate() {
        if (items.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = items.get(0).getValue().length();
        matrix = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            MatrixColumn column = new MatrixColumn();
            for (FastaItem item : items) {
                switch (item.getValue().charAt(i)) {
                    case 'A':
                        column.countA++;
                        break;
                    case 'C':
                        column.countC++;
                        break;
                    case 'G':
                        column.countG++;
                        break;
                    case 'T':
                        column.countT++;
                }
            }
            matrix.add(column);
            sb.append(column.getMax());
        }
        consensus = sb.toString();
    }

    private class MatrixColumn {
        int countA;
        int countC;
        int countG;
        int countT;

        char getMax() {
            int max = Math.max(Math.max(countA, countC), Math.max(countG, countT));
            if (countA >= max) {
                return 'A';
            }
            if (countC >= max) {
                return 'C';
            }
            if (countG >= max) {
                return 'G';
            }
            return 'T';
        }
    }
}
