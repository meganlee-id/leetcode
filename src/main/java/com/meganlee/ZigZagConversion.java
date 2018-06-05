package com.meganlee;

public class ZigZagConversion {
    //--------------- Solution 1 -------------------//
    // row-by-row, find patterns
    public String convert(String s, int nRows) {
        // input validation
        if (s == null || s.length() == 0 || nRows <= 1) {
            return s;   // null || "" || 1 row
        }
        int len = 2 * (nRows - 1); // size of a group
        StringBuilder res = new StringBuilder();
        for (int row = 0; row < nRows; row++) {
            for (int i = row; i < s.length(); i += len) {
                // 1. append j
                res.append(s.charAt(i));
                // 2. optional append next (exclude first and last row)
                int next = i + 2 * (nRows - 1 - row);
                if (row != 0 && row != nRows - 1 &&  next < s.length()) {
                    res.append(s.charAt(next));
                }
            }
        }
        return res.toString();
    }


    //--------------- Solution 2 -------------------//
    // col-by-col: do it like human
    public String convert2(String s, int nRows) {
        // input check
        if (s == null || s.length() == 0 || nRows <= 1) {
            return s;   // null || "" || 1 row
        }
        // initialize the res holder
        StringBuilder[] rows = new StringBuilder[nRows];
        for (int r = 0; r < rows.length; r++) {
            rows[r] = new StringBuilder();
        }
        int direction = -1; // indicating which direction we're going
        for (int i = 0, r = 0; i < s.length(); i++, r = r + direction) {
            // update direction
            if (i % (nRows - 1) == 0) {
                direction *= -1; // go reverse
            }
            // collect res
            rows[r].append(s.charAt(i));
        }
        // concat all rows
        StringBuilder res = new StringBuilder();
        for (StringBuilder row: rows) {
            res.append(row);
        }
        return res.toString();
    }
}
