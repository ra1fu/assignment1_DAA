package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sortsSmallUnorderedArray() {
        int[] array = {9, 4, 7, 1, 3, 6};
        int[] expected = array.clone();
        Arrays.sort(expected);

        QuickSort sorter = new QuickSort();
        int[] result = sorter.run(array);

        assertArrayEquals(expected, result);
    }

    @Test
    void handlesAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        QuickSort sorter = new QuickSort();
        int[] result = sorter.run(array);

        assertArrayEquals(array, result);
    }

    @Test
    void handlesArrayWithDuplicates() {
        int[] array = {5, 5, 5, 5};
        QuickSort sorter = new QuickSort();
        int[] result = sorter.run(array);

        assertArrayEquals(array, result);
    }

    @Test
    void handlesEmptyArray() {
        int[] array = {};
        QuickSort sorter = new QuickSort();
        int[] result = sorter.run(array);

        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void handlesSingleElement() {
        int[] array = {42};
        QuickSort sorter = new QuickSort();
        int[] result = sorter.run(array);

        assertArrayEquals(new int[]{42}, result);
    }

    @Test
    void sortsLargeRandomArray() {
        Random random = new Random(42);
        int[] array = random.ints(10_000, -1000, 1000).toArray();
        int[] expected = array.clone();
        Arrays.sort(expected);

        QuickSort sorter = new QuickSort();
        int[] result = sorter.run(array);

        assertArrayEquals(expected, result);
    }
}
