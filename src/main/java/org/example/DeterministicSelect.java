package org.example;

import java.util.Arrays;

public class DeterministicSelect implements Algorithm<int[], Integer> {

    private final int k;

    public DeterministicSelect(int k) {
        this.k = k;
    }

    @Override
    public Integer run(int[] arr) {
        int[] copy = arr.clone();
        return select(copy, 0, copy.length - 1, k - 1);
    }

    private static int select(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivot = medianOfMedians(arr, left, right);
        int pivotIndex = partition(arr, left, right, pivot);

        if (k == pivotIndex) {
            return arr[pivotIndex];
        } else if (k < pivotIndex) {
            return select(arr, left, pivotIndex - 1, k);
        } else {
            return select(arr, pivotIndex + 1, right, k);
        }
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n < 5) {
            Arrays.sort(arr, left, right + 1);
            return arr[left + n / 2];
        }

        int[] medians = new int[(n + 4) / 5];
        for (int i = 0; i < medians.length; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            Arrays.sort(arr, subLeft, subRight + 1);
            medians[i] = arr[subLeft + (subRight - subLeft) / 2];
        }
        return medianOfMedians(medians, 0, medians.length - 1);
    }

    private static int partition(int[] arr, int left, int right, int pivotValue) {
        int pivotIndex = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] == pivotValue) {
                pivotIndex = i;
                break;
            }
        }

        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }

        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
