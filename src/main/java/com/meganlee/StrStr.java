package com.meganlee;


public class StrStr {
    //-----------------  Solution 1 ------------------//
    // brute-force
    public int strStr(String haystack, String needle) {
        // input checking
        // discuss about null or zero.length
        int H = haystack.length(), N = needle.length();
        if (H < N) {
            return -1;
        } else if (N == 0) { // needle is "", return 0;
            return 0;
        }
        // h and n are not null and H >= n
        for (int i = 0; i <= H - N; i++) {
            if (haystack.substring(i, i + N).equals(needle)) { // String.equals: 1) compare len 2) compare char by char
                return i;
            }
            //---- if implement String.equal by yourself ------//
            // for (int j = 0; j < N; j++) {
            //     if (haystack.charAt(i + j) == needle.charAt(j)) {
            //         if (j == N - 1) {
            //             return i;
            //         }
            //     } else {
            //         break;
            //     }
            // }
        }
        return -1;
    }

    //-----------------  Solution 2 ------------------//
    // KMP - please refer to class KMP
}

