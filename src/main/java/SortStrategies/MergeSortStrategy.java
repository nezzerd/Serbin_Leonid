package SortStrategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSortStrategy implements SortStrategy {
    private final int maxSize;

    @Override
    public int getMaxSize() {
        return maxSize;
    }

    public MergeSortStrategy(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public ArrayList<Integer> sort(List<Integer> list) {
        checkListSize(list);
        ArrayList<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        return sortedList;
    }

    @Override
    public String getStrategyName() {
        return "Merge Sort";
    }
}