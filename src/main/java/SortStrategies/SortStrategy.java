package SortStrategies;

import java.util.ArrayList;
import java.util.List;

public interface SortStrategy {
    ArrayList<Integer> sort(List<Integer> list);

    int getMaxSize();

    String getStrategyName();

    default void checkListSize(List<Integer> list) {
        if (list.size() > getMaxSize()) {
            throw new MaxSizeExcessException("List size exceeds the limit for " + getStrategyName() + ". Let's try another strategy.");
        }
    }
}