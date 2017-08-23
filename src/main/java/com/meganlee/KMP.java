package com.meganlee;

public class KMP {
   public int strStr(String h, String n) {
        // input checking
        // discuss about null or zero.length with interviewers
        int H = h.length(), N = n.length(); // assume both are non-null
        if (H < N) {
            return -1;
        } else if (N == 0) { // needle is "", return 0;
            return 0;
        }

        // h and n are not null and len(h) >= len(n)
        int[] table = buildTable(n);
        for (int i = 0, j = 0; i < H; ) {
            if (h.charAt(i) != n.charAt(j)) {
                if (j == 0) {
                    i++;
                } else {
                    j = table[j - 1];
                }
            } else {
                i++;
                j++;
                if (j == N) {
                    return i - j;
                }
            }
        }
        return -1;
    }

    private int[] buildTable(String s) {
        // assume s is not null, not empty
        int[] table = new int[s.length()];
        for (int len = 0, i = 1; i < s.length(); ) {
            if (s.charAt(len) == s.charAt(i)) {
                table[i] = len + 1;
                i++;
                len++;
            } else {
                if (len == 0) {
                    i++; // table[i] = 0
                } else {
                    len = table[len - 1];
                }
            }
        }
        return table;
    }
}
