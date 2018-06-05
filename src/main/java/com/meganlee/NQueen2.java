package com.meganlee;

import java.util.*;

public class NQueen2 {
    //--------------- Solution 1 --------------------//
    // use a 1D-array as a solution builder
    public int totalNQueens(int n) {
        // input checking
        if (n <= 0) {
            return 0;
        }
        // use a 1D-array to indicate solution
        int[] res = new int[1]; // collector use a pointer
        helper(res, new ArrayList(), n, 0);
        return res[0];
    }

    private void helper(int[] res, List<Integer> item, int n, int row) {
        // base case
        if (row == n) {
            res[0]++;
            return;
        }
        // general case
        for (int i = 0; i < n; i++) {
            item.add(i);
            if (valid(item)) {
                helper(res, item, n, row + 1);
            }
            item.remove(item.size() - 1);
        }
    }

    private boolean valid(List<Integer> item) {
        int row = item.size() - 1; // check validity for the last row
        for (int preRow = 0; preRow < row; preRow++) {
            int col = item.get(row), preCol = item.get(preRow);
            if (col == preCol || Math.abs(col - preCol) == Math.abs(row - preRow)) {
                return false;
            }
        }
        return true;
    }


    //--------------- Solution 2 --------------------//
    // use bitmap to solve the problem!! cool!!
    // LIMIT: but since target is  "int", only could count up to N=32
    public int totalNQueens2(int n) {
        // input checking
        if (n <= 0) {
            return 0;
        }
        // use a 1D-array to indicate solution
        int[] res = new int[1];     // collector use a pointer
        int target = (1 << n) - 1;  // for n = 9: 00000000,00000000,00000001,11111111
        helper(res, 0, 0, 0, target);
        return res[0];
    }

    private void helper(int[] res, int up, int upRight, int upLeft, int target) {
        // Arguments indicate positions taken from 3 direction
        // 1) up:       go up vertically,       occupied pos marked with 1
        // 2) upRight:  go up-right diagonally, occupied pos marked with 1
        // 3) upLeft:   go up-left diagonally,  occupied pos marked with 1
        if (up == target) { // n consecutive ones in up, result found, return
            res[0] += 1;
            return;
        }
        // for each of available position
        int pos = target & ~(up | upRight | upLeft); // available pos would be marked one
        while (pos != 0) {
            int p = pos & (~pos + 1);  // get the lowest 1: 0110 --> 0010
            helper(res, (up | p), (upRight | p) << 1, (upLeft | p) >> 1, target);
            pos -= p;                  // remove the rightmost 1: 0110 --> 0100
        }
    }
}
