package com.meganlee;

import java.util.*;

public class PascalTriangle2 {
    // Use the same List for next level numbers: calculating backwards
    // 0 --> [1]
    // 1 --> [1, 1]
    // 2 --> [1, 2, 1]
    // ...
    public List<Integer> getRow(int rowIndex) {
        // input checking
        List<Integer> row = new ArrayList();
        if (rowIndex < 0) {
            return row;
        }
        // genrate row by row
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = row.size() - 1; j >= 1 ; j--) {  // fill backwards
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);  // row.add(index, num) || row.add(num) at the end
        }
        return row;
    }
}

