package org.example.datastructure.array;

import java.util.Arrays;

public class App012 {
    public static void main(String[] args) {

        int[] array = new int[]{2,2,0,2,1,0,0,0,0,1,1,2,2,2,2};

        for (int value :  arrange(array) ) {
            System.out.print(value+" ");
        }
    }

    public static int[] arrange(int[] arr){
        int size= arr.length;
        int high = size-1;
        int low = 0;
        int mid = 0;

        while(mid <= high){
            if(arr[mid] == 2) {
                swap(mid,high,arr);
                high--;
            }else if( arr[mid] == 0){
                swap(mid,low,arr);
                mid++;
                low++;
            }else {
                mid++;
            }
        }
        return arr;
    }

    private static void swap(int low, int high, int[] arr) {
        int temp = arr[high];
        arr[high] = arr[low];
        arr[low] = temp;
    }
}
