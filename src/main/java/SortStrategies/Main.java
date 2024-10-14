package SortStrategies;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 4, 7, 9, 12, 8, 6, 20));
        SortManager sortManager = new SortManager();

        sortManager.addSortStrategy(new BubbleSortStrategy(5));
        sortManager.addSortStrategy(new MergeSortStrategy(10));

        try {
            SortResult result = sortManager.sort(list);
            System.out.println("Sorted list: " + result.getSortedList());
            System.out.println("Sorting strategy used: " + result.getStrategyName());
        } catch (IllegalStateException e) {
            System.err.println("Failed to sort the list: " + e.getMessage());
        }
    }
}
