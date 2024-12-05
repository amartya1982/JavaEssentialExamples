package com.java.sort;

public class mergeSort {

    // Main method to run the merge sort
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original Array:");
        printArray(array);

        mergeSortFunction(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        printArray(array);
    }


    // Merge Sort function
    public static void mergeSortFunction(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            // Recursively split the array into halves
            mergeSortFunction(array, left, middle);
            mergeSortFunction(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Merge function to merge two sorted halves
    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from leftArray if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from rightArray if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Utility function to print the array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
