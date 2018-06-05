package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class Candy {
    //-------------------- Solution 1 -----------------------//
    // incremental ( Time Limit Exceeded ) T=O(N^2)
    public int candy(int[] ratings) {
        // input checking fast response
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < ratings.length; i++) { // start from the 2nd child
            if (ratings[i - 1] < ratings[i]) {
                candy[i] = candy[i - 1] + 1;
            } else if (ratings[i - 1] > ratings[i]) {
                // keep the current cell's value as 1
                // adjust predecessors in reversed order util the nearest peak
                for (int p = i - 1; p >= 0; p--) {
                    if (ratings[p] > ratings[p + 1] && candy[p] <= candy[p + 1]) {
                        candy[p] = candy[p + 1] + 1;
                    } else {
                        break;
                    }
                }
            } // else ratings[i - 1] == ratings[i], keep the default value 1
        }

        return Arrays.stream(candy).sum();
    }


    //-------------------- Solution 2 -----------------------//
    // Greedy
    public int candy2(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        // think about one child
        // go left to the first valley, go right to the first valley.
        int N = ratings.length;
        int[] L = new int[N], R = new int[N];
        Arrays.fill(L, 1);
        Arrays.fill(R, 1);
        for (int i = 1, j = N - 2; i < N; i++, j--) { // start from the 2nd child
            // calculate L
            if (ratings[i] > ratings[i - 1]) { // if ratings[i] <= ratings[i-1], keep the default value 1
                L[i] = L[i - 1] + 1;
            }
            // calculate R
            if (ratings[j] > ratings[j + 1]) { // if ratings[j] <= ratings[j+1], keep the default value 1
                R[j] = R[j + 1] + 1;
            }
        }

        return IntStream.range(0, N).map(i -> Math.max(L[i], R[i])).sum();
    }

    //-------------------- Solution 3 -----------------------//
    // only use one array
    public int candy3(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        // think about one child
        // go left to the first valley, go right to the first valley.
        int N = ratings.length;
        int[] LR = new int[N]; //---- diff 1: only use one array
        Arrays.fill(LR, 1);
        for (int i = 1; i < N; i++) { // start from the 2nd child
            // calculate L
            if (ratings[i] > ratings[i - 1]) { // if ratings[i] <= ratings[i-1], keep the default value 1
                LR[i] = LR[i - 1] + 1;
            }
        }
        for (int j = N - 2; j >= 0; j--) { // start from the 2nd child
            // calculate R
            if (ratings[j] > ratings[j + 1]) { // if ratings[j] <= ratings[j+1], keep the default value 1
                LR[j] = Math.max(LR[j], LR[j + 1] + 1); //---- diff 2: use Math.max()
            }
        }

        return Arrays.stream(LR).sum();
    }
}
