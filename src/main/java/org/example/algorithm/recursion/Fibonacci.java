package org.example.algorithm.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(getNthFib(6));
    }

    public static int getNthFib(int n) {
        if (n == 0 || n == 1) return 1;
        else return (getNthFib(n - 1) + getNthFib(n - 2));
    }

}
