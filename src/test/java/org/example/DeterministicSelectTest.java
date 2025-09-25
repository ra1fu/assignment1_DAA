package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DeterministicSelectTest {

    @Test
    void findsMinimum() {
        int[] array = {7, 2, 9, 4, 1};
        int expected = Arrays.stream(array).min().orElseThrow();

        DeterministicSelect select = new DeterministicSelect(1);
        int result = select.run(array);

        assertEquals(expected, result, "Должен найти минимальный элемент");
    }

    @Test
    void findsMaximum() {
        int[] array = {7, 2, 9, 4, 1};
        int expected = Arrays.stream(array).max().orElseThrow();

        DeterministicSelect select = new DeterministicSelect(array.length);
        int result = select.run(array);

        assertEquals(expected, result, "Должен найти максимальный элемент");
    }

    @Test
    void findsMedian() {
        int[] array = {12, 3, 5, 7, 4, 19, 26};
        int[] copy = array.clone();
        Arrays.sort(copy);
        int expected = copy[copy.length / 2];

        DeterministicSelect select = new DeterministicSelect(copy.length / 2 + 1);
        int result = select.run(array);

        assertEquals(expected, result, "Должен найти медиану");
    }

    @Test
    void handlesSingleElement() {
        int[] array = {42};

        DeterministicSelect select = new DeterministicSelect(1);
        int result = select.run(array);

        assertEquals(42, result, "Один элемент должен возвращаться как есть");
    }

    @Test
    void worksOnLargeRandomArray() {
        Random random = new Random(42);
        int[] array = random.ints(10_000, -1000, 1000).toArray();
        int[] copy = array.clone();
        Arrays.sort(copy);

        int k = 5000;
        int expected = copy[k - 1];

        DeterministicSelect select = new DeterministicSelect(k);
        int result = select.run(array);

        assertEquals(expected, result, "Должен находить k-й минимум корректно");
    }
}
