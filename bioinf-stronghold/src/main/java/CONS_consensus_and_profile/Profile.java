package CONS_consensus_and_profile;

import reader.TextReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Oleg Grigoryev on 07.07.2016.
 */
public class Profile {
    private List<String> strings;
    private String consensus;
    private List<MatrixColumn> matrix;

    public Profile() {
        this.strings = new ArrayList<>();
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
            setStrings(TextReader.readFastaFile(new FileReader(fileName)).values());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setStrings(Collection<String> strings) {
        this.strings = new ArrayList<>(strings);
    }

    public void evaluate() {
        if (strings.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = strings.get(0).length();
        matrix = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            MatrixColumn column = new MatrixColumn();
            for (String string : strings) {
                switch (string.charAt(i)) {
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
