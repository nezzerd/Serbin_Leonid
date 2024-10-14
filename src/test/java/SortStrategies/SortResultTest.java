package SortStrategies;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortResultTest {

    @Test
    public void testSortResult_ShouldReturnCorrectValues() {
        List<Integer> sortedList = List.of(1, 2, 3, 4, 5);
        String strategyName = "Bubble Sort";

        SortResult result = new SortResult(sortedList, strategyName);

        assertEquals(sortedList, result.getSortedList());
        assertEquals(strategyName, result.getStrategyName());
    }
}
