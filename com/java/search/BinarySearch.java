package com.java.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.SortedSet;
import java.util.stream.Collectors;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};  // Sorted array
        int target = 9;  // Element to find

        int index = binarySearchAlgo(arr, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }

    public static int binarySearchAlgo(int[] arr, int target){

        Collections.sort(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        int leftindex=0;
        int rightIndex=arr.length-1;
        while(leftindex <= rightIndex) {
            int midIndex=leftindex + (rightIndex-leftindex)/2;

            if (arr[midIndex] > target) {
                rightIndex = midIndex -1 ;
            } else if (arr[midIndex] < target) {
                leftindex = midIndex + 1 ;

            } else if (arr[midIndex] == target) {
                return midIndex;
            }
        }
        return -1;
    }
}