package SortStrategies;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortStrategy implements SortStrategy {
    private final int maxSize;

    @Override
    public int getMaxSize() {
        return maxSize;
    }

    public BubbleSortStrategy(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public ArrayList<Integer> sort(List<Integer> list) {
        checkListSize(list);
        ArrayList<Integer> mutableList = new ArrayList<>(list);

        for (int i = 0; i < mutableList.size(); i++) {
            for (int j = i + 1; j < mutableList.size(); j++) {
                if (mutableList.get(i) > mutableList.get(j)) {
                    int temp = mutableList.get(i);
                    mutableList.set(i, mutableList.get(j));
                    mutableList.set(j, temp);
                }
            }
        }
        return mutableList;
    }

    @Override
    public String getStrategyName() {
        return "Bubble Sort";
    }
}