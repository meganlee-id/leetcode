package com.meganlee;

import java.util.*;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Input validation
        // 1. flowerbed != null, either 0 or 1 not violating non-adjacent rule, the input size? 
        // 2. n value range non-negative
        
        //-- discuss 
        // 1 1             diff = 1, num = 0 
        // 1 0 1           diff = 2, num = 0 
        // 1 0 0 1         diff = 3, num = 0
        // 1 0 0 0 1       diff = 4, num = 1
        // 1 0 0 0 0 1     diff = 5, num = 1
        // 1 0 0 0 0 0 1   diff = 6, num = 2
        // 1 0 0 0 0 0 0 1 diff = 7, num = 2
        // num = (diff - 2) / 2
        //------------------------------------
        // Go GREEDY, grab the first available spot and plant it there
        // otherwise you'll have less available spots at the end
        
        int count = 0, len = flowerbed.length;
        for (int i = 0; i < len && count < n; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count == n;
    }
}