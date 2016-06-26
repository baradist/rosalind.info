package BINS_binary_search;

import java.util.*;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class BinarySearch {
    private int mapSize; // not used
    private int listLength; // not used
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public void readData() {
        map = new HashMap<>();
        list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            mapSize = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            listLength = scanner.nextInt();
        }
        scanner.nextLine();
        if (scanner.hasNextLine()) {
            String[] values = scanner.nextLine().split(" ");
            for (int i = 0; i < values.length; ) {
                map.put(Integer.parseInt(values[i]), ++i);
            }
        }
        if (scanner.hasNext()) {
            String[] values = scanner.nextLine().split(" ");
            for (String s : values) {
                list.add(Integer.parseInt(s));
            }
        }
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        for (Integer integer : list) {
            if (map.containsKey(integer)) {
                result.append(map.get(integer) + " ");
            } else {
                result.append("-1 ");
            }
        }
        result.deleteCharAt(result.length() - 1);
        return  result.toString();
    }
}
