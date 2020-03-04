package org.example.algorithm.other;

public class PrimeNo {
    public static void main(String[] args) {

        System.out.println(isPrime(43));
    }

    public static boolean isPrime(int no) {

        if (no < 1) return true;

        for (int i = 2; i < no / 2; i++) {
            if (no % i == 0) {
                return false;
            }
        }

        return true;
    }

}
