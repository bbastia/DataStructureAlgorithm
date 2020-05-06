package org.example.algorithm.divideAndConquer;

public class NoOfWays {
    public static void main(String[] args) {
        System.out.println(noOfWays(4));
    }

    private static int noOfWays(int element) {

        if (element == 1 || element == 0 || element == 2) {
            return 1;
        } else if (element == 3) {
            return 2;
        }

        return noOfWays(element - 1) + noOfWays(element - 3) + noOfWays(element - 4);
    }


}
