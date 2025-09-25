package org.example;

import java.util.Random;

public class QuickSort implements Algorithm<int[], int[]> {
    private static final Random rnd = new Random();

    @Override
    public int[] run(int[] input) {
        int[] copy = input.clone();
        quicksort(copy, 0, copy.length - 1);
        return copy;
    }

    private static void quicksort(int[] arr, int left, int right) {
        while (left < right) {
            int pivotIndex = left + rnd.nextInt(right - left + 1);
            int pivot = arr[pivotIndex];
            int i = left, j = right;

            while (i <= j) {
                while (arr[i] < pivot) i++;
                while (arr[j] > pivot) j--;
                if (i <= j) {
                    swap(arr, i, j);
                    i++;
                    j--;
                }
            }

            if (j - left < right - i) {
                quicksort(arr, left, j);
                left = i;
            } else {
                quicksort(arr, i, right);
                right = j;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
