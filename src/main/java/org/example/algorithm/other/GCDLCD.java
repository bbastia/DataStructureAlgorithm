package org.example.algorithm.other;

public class GCDLCD {

    public static void main(String[] args) {

        System.out.println(GCD(15, 20));
        System.out.println(LCD(12, 15));
    }

    /* Euclids algorithm

    GCD(A,B) = GCD(B ,A mod B)
     */
    public static int GCD(int a, int b) {
        int remainder;
        while (b != 0) {
            remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    /*
    LCD = A*B / GCD(A,B)
     */
    public static int LCD(int a, int b){
        return (a*b)/GCD(a,b);
    }
}
