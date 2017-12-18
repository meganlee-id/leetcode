package com.meganlee;

import java.util.*;

public class PascalTriangle {
    //------------------- Solutino 1 -----------------//
    // layer by layer, intuitive
    // use a NEWS list for next level numbers
    public List<List<Integer>> generate(int numRows) {
        // input check
        List<List<Integer>> res = new ArrayList();
        if (numRows <= 0) {
            return res;
        }
        // genrate row by row
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curRow.add(1);
                } else {
                    // this block ensures that i >= 1 and j >= 1
                    List<Integer> preRow = res.get(i - 1); // do not move this out of else block
                    curRow.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            res.add(curRow);
        }
        return res;
    }

    //------------------- Solutino 1 -----------------//
    // reuse with PascalTriangel2
    // use the same List for next level numbers: calculating backwards
    public List<List<Integer>> generate2(int numRows) {
        // input check
        List<List<Integer>> res = new ArrayList();
        if (numRows <= 0) {
            return res;
        }
        // genrate row by row
        List<Integer> row = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            for (int j = row.size() - 1; j >= 1 ; j--) { // fill backwards
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1); // row.add(index, num) || row.add(num) at the end
            res.add(new ArrayList(row));
        }
        return res;
    }
}


