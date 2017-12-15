package com.meganlee;

import java.util.*;

// This is similar to Candy
// but requires that SAME ratings means SAME candy
public class CandyII {
    public int candy(int[] ratings) {
        // input checking fast response
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }

        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candy[i] = candy[i - 1] + 1;
            } else if (ratings[i - 1] == ratings[i]) {
                candy[i] = candy[i - 1];
            } else {
                // adjust predecessors
                for (int p = i - 1; p >= 0; p--) {
                    if (ratings[p] == ratings[p + 1] && candy[p] < candy[p + 1]) {
                        candy[p] = candy[p + 1];
                    } else if (ratings[p] > ratings[p + 1] && candy[p] <= candy[p + 1]) {
                        candy[p] = candy[p + 1] + 1;
                    } else {
                        break;
                    }
                }
            }
        }

        return Arrays.stream(candy).sum();
    }
}