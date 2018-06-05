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
}