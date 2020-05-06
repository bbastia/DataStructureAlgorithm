package org.example.algorithm.sorting;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = {3, 7, 4, 5, 1, 2};
        // bubbleSort(arr);
        // insertionSort(arr);
        // selectionSort(arr);
        mergeSort(arr);
        for (int el : arr) {
            System.out.println(el);
        }
    }


    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 1 + i; j < arr.length; j++) {

                if (arr[j] < arr[i]) {
                    swap(j, i, arr);
                }
            }

        }

    }

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {

                if (arr[j] > arr[i]) {
                    swap(j, i, arr);
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {

        int l = arr.length;

        for (int i = 1; i < l; i++) {

            for (int j = 0; j < l - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                }
            }
        }
    }

    public static void mergeSort(int[] arr) {

        int first = 0;
        int last = arr.length - 1;
        doMergeSort(first, last, arr);

    }

    public static void doMergeSort(int first, int last, int[] arr) {
        if (first < last) {
            int middle = (first + last) / 2;
            doMergeSort(first, middle , arr);
            doMergeSort(middle+1 , last, arr);
            merge(first, last, middle, arr);
        }
    }

    public static void merge(int first, int last, int middle, int[] arr) {

        int n1 = middle - first + 1;
        int n2 = last - middle;


        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[first + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle+1+j];
        }

        int i=0,j=0,k=0;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }

}

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
