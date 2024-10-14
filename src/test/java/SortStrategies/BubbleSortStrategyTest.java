package SortStrategies;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortStrategyTest {

    @Test
    public void testSort_ShouldSortListCorrectly() {
        BubbleSortStrategy strategy = new BubbleSortStrategy(10);
        List<Integer> list = List.of(5, 3, 8, 1, 2);
        ArrayList<Integer> expected = new ArrayList<>(List.of(1, 2, 3, 5, 8));

        ArrayList<Integer> sortedList = strategy.sort(list);
        assertEquals(expected, sortedList);
    }

    @Test
    public void testSort_ShouldThrowExceptionWhenListTooLarge() {
        BubbleSortStrategy strategy = new BubbleSortStrategy(3);
        List<Integer> list = List.of(5, 3, 8, 1);

        Exception exception = assertThrows(MaxSizeExcessException.class, () -> {
            strategy.sort(list);
        });

        String expectedMessage = "List size exceeds the limit for Bubble Sort.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetStrategyName_ShouldReturnCorrectName() {
        BubbleSortStrategy strategy = new BubbleSortStrategy(10);
        assertEquals("Bubble Sort", strategy.getStrategyName());
    }

    @Test
    public void testSort_ShouldHandleEmptyList() {
        BubbleSortStrategy strategy = new BubbleSortStrategy(10);
        List<Integer> emptyList = List.of();
        ArrayList<Integer> sortedList = strategy.sort(emptyList);

        assertTrue(sortedList.isEmpty());
    }

    @Test
    public void testSort_ShouldHandleSingleElementList() {
        BubbleSortStrategy strategy = new BubbleSortStrategy(10);
        List<Integer> singleItemList = List.of(1);
        ArrayList<Integer> sortedList = strategy.sort(singleItemList);
        assertEquals(List.of(1), sortedList);
    }

    @Test
    public void testSort_ShouldHandleAlreadySortedList() {
        BubbleSortStrategy strategy = new BubbleSortStrategy(10);
        List<Integer> sortedList = List.of(1, 2, 3, 4, 5);
        ArrayList<Integer> result = strategy.sort(sortedList);
        assertEquals(sortedList, result);
    }

    @Test
    public void testSort_ShouldHandleListWithDuplicates() {
        BubbleSortStrategy strategy = new BubbleSortStrategy(10);
        List<Integer> listWithDuplicates = List.of(3, 1, 2, 3, 2);
        ArrayList<Integer> expected = new ArrayList<>(List.of(1, 2, 2, 3, 3));

        ArrayList<Integer> sortedList = strategy.sort(listWithDuplicates);
        assertEquals(expected, sortedList);
    }
}