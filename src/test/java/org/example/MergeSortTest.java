package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sortsSmallUnorderedArray() {
        int[] array = {9, 4, 7, 1, 3, 6};
        int[] expected = array.clone();
        Arrays.sort(expected);

        MergeSort sorter = new MergeSort();
        int[] result = sorter.run(array);

        assertArrayEquals(expected, result, "Массив должен быть отсортирован по возрастанию");
    }

    @Test
    void handlesAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = array.clone();

        MergeSort sorter = new MergeSort();
        int[] result = sorter.run(array);

        assertArrayEquals(expected, result, "Уже отсортированный массив не должен измениться");
    }

    @Test
    void handlesArrayWithDuplicates() {
        int[] array = {5, 5, 5, 5};
        int[] expected = array.clone();

        MergeSort sorter = new MergeSort();
        int[] result = sorter.run(array);

        assertArrayEquals(expected, result, "Массив из одинаковых элементов должен оставаться неизменным");
    }

    @Test
    void handlesEmptyArray() {
        int[] array = {};
        MergeSort sorter = new MergeSort();
        int[] result = sorter.run(array);

        assertArrayEquals(new int[]{}, result, "Пустой массив должен остаться пустым");
    }

    @Test
    void handlesSingleElement() {
        int[] array = {42};
        MergeSort sorter = new MergeSort();
        int[] result = sorter.run(array);

        assertArrayEquals(new int[]{42}, result, "Один элемент не должен измениться");
    }

    @Test
    void sortsLargeRandomArray() {
        Random random = new Random(42);
        int[] array = random.ints(10_000, -1000, 1000).toArray();
        int[] expected = array.clone();
        Arrays.sort(expected);

        MergeSort sorter = new MergeSort();
        int[] result = sorter.run(array);

        assertArrayEquals(expected, result, "Большой массив должен сортироваться корректно");
    }
}
