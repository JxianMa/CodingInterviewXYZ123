package Algorithms.Sorting;

import java.util.Arrays;

public class QuickSort {
    private void sort(int[] input) {
        if (input == null || input.length == 0) return;
        quickSortHelper(input, 0, input.length - 1);
    }

    private void quickSortHelper(int[] input, int s, int e) {
        if (s >= e) return;
        int pivot = partition(input, s, e);
        quickSortHelper(input, s, pivot - 1);
        quickSortHelper(input, pivot + 1, e);
    }

    private int partition(int[] input, int s, int e) {
        int sm = s;
        for (int i = s; i < e; i++) {
            if (input[i] < input[e]) {
                swap(input, sm++, i);
            }
        }
        swap(input, sm, e);
        return sm;
    }

    private void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 1, 5, 6, 4};
        QuickSort qs = new QuickSort();
        qs.sort(input);
        System.out.println(Arrays.toString(input));

        int[] input2 = {7, 6, 5, 4, 3, 2, 1};
        qs.sort(input2);
        System.out.println(Arrays.toString(input2));

        int[] input3 = {1, 2, 3, 4, 5, 6, 7};
        qs.sort(input3);
        System.out.println(Arrays.toString(input3));
    }
}
