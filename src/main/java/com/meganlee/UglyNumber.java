package com.meganlee;


public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        int[] seeds = {2, 3, 5};
        for (int seed: seeds) {
            while (num % seed == 0) {
                num /= seed;
            }
        }
        return num == 1;
    }


    ///////////////     TEST      ///////////////
    public static void main(String[] args) {
        UglyNumber solution = new UglyNumber();
        for (int i = 0; i <= 100; i++) {
            System.out.println("Number: " + i + " Ugly: " + solution.isUgly(i));
        }
    }
}