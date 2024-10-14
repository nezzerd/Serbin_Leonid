package SortStrategies;

import java.util.ArrayList;
import java.util.List;

public class SortManager {
    private final List<SortStrategy> sortStrategies = new ArrayList<>();

    public void addSortStrategy(SortStrategy sortStrategy) {
        sortStrategies.add(sortStrategy);
    }

    public SortResult sort(List<Integer> list) {
        for (SortStrategy sortStrategy : sortStrategies) {
            try {
                ArrayList<Integer> sortedList = sortStrategy.sort(list);
                return new SortResult(sortedList, sortStrategy.getStrategyName());
            } catch (MaxSizeExcessException e) {
                System.err.println(e.getMessage());
            }
        }
        throw new IllegalStateException("None of the strategies are suitable");
    }
}