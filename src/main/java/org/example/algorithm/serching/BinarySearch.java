package org.example.algorithm.serching;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,27,37,44,55,64,126};

        int index = binarySearch(arr, 648);
        boolean result = !(index == -1);
        System.out.println("result exist : " + result );
    }

    public static int binarySearch(int[] arr, int el) {
        Arrays.sort(arr);
        int first = 0;
        int last = arr.length - 1;
        if(el > arr[last] || el < arr[first]) return -1;
        return search(first, last, arr, el);
    }

    public static int search(int first, int last, int[] arr, int element) {
        if(first == last ) return -1;

        int middle = first + ((last - first) / 2);

        if (arr[middle] == element) {
            return middle;
        }

        if (element > arr[middle]) {
            return search(middle + 1, last, arr, element);
        } else {
            return search(first, middle-1 , arr, element);
        }
    }
}
