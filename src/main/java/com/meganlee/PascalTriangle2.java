package com.meganlee;

import java.util.*;

public class PascalTriangle2 {
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
        // compute row by row
        for (int i = 0; i <= rowIndex; i++) {  // rowIndex starts from 0
            for (int j = row.size() - 1; j >= 1 ; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }
}

