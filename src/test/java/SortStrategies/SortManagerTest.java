package SortStrategies;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortManagerTest {

    @Test
    public void testSort_ShouldReturnCorrectStrategyAndSortedList() {
        SortManager manager = new SortManager();
        manager.addSortStrategy(new BubbleSortStrategy(10));
        List<Integer> list = List.of(5, 3, 8, 1, 2);

        SortResult result = manager.sort(list);
        assertEquals("Bubble Sort", result.getStrategyName());
        assertEquals(List.of(1, 2, 3, 5, 8), result.getSortedList());
    }

    @Test
    public void testSort_ShouldTryAnotherStrategyWhenFirstFails() {
        SortManager manager = new SortManager();
        manager.addSortStrategy(new BubbleSortStrategy(3));
        manager.addSortStrategy(new MergeSortStrategy(10));
        List<Integer> list = List.of(5, 3, 8, 1);

        SortResult result = manager.sort(list);
        assertEquals("Merge Sort", result.getStrategyName());
        assertEquals(List.of(1, 3, 5, 8), result.getSortedList());
    }

    @Test
    public void testSort_ShouldThrowExceptionWhenNoSuitableStrategy() {
        SortManager manager = new SortManager();
        manager.addSortStrategy(new BubbleSortStrategy(3));
        manager.addSortStrategy(new MergeSortStrategy(2));
        List<Integer> list = List.of(5, 3, 8, 1);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            manager.sort(list);
        });

        assertEquals("None of the strategies are suitable", exception.getMessage());
    }

    @Test
    public void testSort_ShouldHandleEmptyList() {
        SortManager manager = new SortManager();
        manager.addSortStrategy(new BubbleSortStrategy(10));
        List<Integer> emptyList = List.of();

        SortResult result = manager.sort(emptyList);
        assertEquals("Bubble Sort", result.getStrategyName());
        assertTrue(result.getSortedList().isEmpty());
    }

    @Test
    public void testSort_ShouldHandleSingleElementList() {
        SortManager manager = new SortManager();
        manager.addSortStrategy(new BubbleSortStrategy(10));
        List<Integer> singleItemList = List.of(1);

        SortResult result = manager.sort(singleItemList);
        assertEquals("Bubble Sort", result.getStrategyName());
        assertEquals(List.of(1), result.getSortedList());
    }

    @Test
    public void testSort_ShouldHandleAlreadySortedList() {
        SortManager manager = new SortManager();
        manager.addSortStrategy(new BubbleSortStrategy(10));
        List<Integer> sortedList = List.of(1, 2, 3, 4, 5);

        SortResult result = manager.sort(sortedList);
        assertEquals("Bubble Sort", result.getStrategyName());
        assertEquals(List.of(1, 2, 3, 4, 5), result.getSortedList());
    }

    @Test
    public void testSort_ShouldHandleListWithDuplicates() {
        SortManager manager = new SortManager();
        manager.addSortStrategy(new BubbleSortStrategy(10));
        List<Integer> listWithDuplicates = List.of(3, 1, 2, 3, 2);

        SortResult result = manager.sort(listWithDuplicates);
        assertEquals("Bubble Sort", result.getStrategyName());
        assertEquals(List.of(1, 2, 2, 3, 3), result.getSortedList());
    }
}