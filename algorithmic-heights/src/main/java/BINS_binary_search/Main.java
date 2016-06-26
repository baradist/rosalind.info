package BINS_binary_search;

import java.time.Instant;

/**
 * Created by Oleg Grigorjev on 26.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.readData();
        Instant start = Instant.now();
        System.out.println(binarySearch.getResult());
        System.out.println(Instant.now().compareTo(start));
    }
}
