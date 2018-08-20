package com.meganlee;

import java.util.*;
 
public class QuickSort {
    public static void sort(int[] arr) {
        // need to shuffle first to guarantee randomness
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        // base case
        if (lo >= hi) {
            return;
        }
        // general case
        // 1. partition
        int i = lo, j = hi, mid = lo + (hi - lo) / 2;
        int pivot = arr[mid]; // pivot needs to be in middle, do randomize
        while (i <= j) { // partition
            while (arr[i] < pivot) { // use < (not <=) to prevent i fall off hi (all elem same value)
                i++;
            }
            while (arr[j] > pivot) { // use > (not >=) to prevent j fall off lo (all elem same value)
                j--;
            }
            if (i <= j) { // consider if arr[i] and arr[j] hold the same value
                swap(arr, i, j);
                i++; // skip same value at i and j, otherwise infinite loop
                j--; // skip same value at i and j, otherwise infinite loop
            }
        }
        // 2. recursion
        quickSort(arr, lo, j);
        quickSort(arr, i, hi);
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 8, 3, 1, 8, 3, 3, 9, 4, 5, 7};
        int[] arr2 = {1, 3, 4, 5, 4, 3, 2, 1, 8};
        System.out.println("\n Array1 before sorting ");
        System.out.println(Arrays.toString(arr1));
        sort(arr1);
        System.out.println("\n Array1 after sorting ");
        System.out.println(Arrays.toString(arr1));

        System.out.println("\n Array2 before sorting ");
        System.out.println(Arrays.toString(arr2));
        sort(arr2);
        System.out.println("\n Array2 after sorting ");
        System.out.println(Arrays.toString(arr2));
    }    
}