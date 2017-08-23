package com.meganlee;

import java.util.*;

public class PascalTriangle {
    //------------------- Solutino 1 -----------------//
    // layer by layer, intuitive
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
                    // this block ensures that i - 1 >= 0!!
                    // do NOT move this line 21 up at line 14, will have index out of bounds!
                    List<Integer> preRow = res.get(i - 1);
                    curRow.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            res.add(curRow);
        }
        return res;
    }

    //------------------- Solutino 1 -----------------//
    // dp, reuse with PascalTriangel2
    public List<List<Integer>> generate2(int numRows) {
        // input check
        List<List<Integer>> res = new ArrayList();
        if (numRows <= 0) {
            return res;
        }
        ArrayList<Integer> row = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            for (int j = row.size() - 1; j >= 1 ; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1); // row.add(index, num) || row.add(num) at the end
            res.add(new ArrayList(row));
        }
        return res;
    }
}


