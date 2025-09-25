package org.example;

public class MergeSort implements Algorithm<int[], int[]> {

    private static final int CUTOFF = 16;

    @Override
    public int[] run(int[] input) {
        int[] copy = input.clone();
        int[] temp = new int[copy.length];
        sort(copy, temp, 0, copy.length - 1);
        return copy;
    }

    private static void sort(int[] arr, int[] temp, int left, int right) {
        if (right - left + 1 <= CUTOFF) {
            insertionSort(arr, left, right);
            return;
        }

        int mid = (left + right) / 2;
        sort(arr, temp, left, mid);
        sort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, left, arr, left, right - left + 1);
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
