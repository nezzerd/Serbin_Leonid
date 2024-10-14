package SortStrategies;

import java.util.List;

public class SortResult {
    private final List<Integer> sortedList;
    private final String strategyName;

    public SortResult(List<Integer> sortedList, String strategyName) {
        this.sortedList = sortedList;
        this.strategyName = strategyName;
    }

    public List<Integer> getSortedList() {
        return sortedList;
    }

    public String getStrategyName() {
        return strategyName;
    }
}