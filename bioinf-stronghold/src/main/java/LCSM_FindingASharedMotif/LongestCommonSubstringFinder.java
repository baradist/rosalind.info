package LCSM_FindingASharedMotif;

import common.FastaHolderAbstract;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Oleg Grigorjev on 07.08.2016.
 */
public class LongestCommonSubstringFinder extends FastaHolderAbstract {
    private String result;

    /**
     * modyfied method from https://ru.wikipedia.org/wiki/Наибольшая_общая_подстрока
     * @param values list of strings which we are going to process
     * @return a longest common substring
     */
    private static String longestCS(List<String> values) {
        if (values.size() == 0) {
            throw new RuntimeException("Nothing to process - values is empty");
        }
        if (values.size() == 1) {
            return values.get(0);
        }
        for (String s : values) {
            if (s == null || s.length() == 0) {
                return "";
            }
        }

        String a = values.get(0);
        String b = values.get(1);

        Set<String> rest = values.stream()
                .skip(2)
                .collect(Collectors.toSet()); // we don't have to process duplicates

        int[][] matrix = new int[a.length()][];

        int maxLength = 0;
        int maxI = 0;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[b.length()];
            for (int j = 0; j < matrix[i].length; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i != 0 && j != 0) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    } else {
                        matrix[i][j] = 1;
                    }
                    if (matrix[i][j] > maxLength) {
                        String candidate = a.substring(i - matrix[i][j] + 1, i + 1); // TODO: 07.08.2016
                        for (String s : rest) {
                            if (!s.contains(candidate)) {
                                break;
                            }
                            maxLength = matrix[i][j];
                            maxI = i;
                        }
                    }
                }
            }
        }
        return a.substring(maxI - maxLength + 1, maxI + 1);
    }

    public String getResult() {
        return result;
    }
    @Override
    public void evaluate() {
        List<String> values = items.stream()
                .map(i -> i.getValue())
                .collect(Collectors.toList());
        result = longestCS(values);
    }
}
