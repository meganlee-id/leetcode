package com.meganlee;

public class CountAndSay {
    //--------------------- Solution ----------------------//
    // add the count and say, when we meet the last repetitive number
    public String countAndSay(int n) {
        // input validation
        if (n <= 0) {
            return "";
        }
        // for n >= 1
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int lo = 0, hi = 0; hi < res.length(); hi++) {
                // meet the last char in range
                if (hi == res.length() - 1 || res.charAt(hi) != res.charAt(hi + 1)) {
                    sb.append((hi - lo + 1) + "" + res.charAt(hi));
                    lo = hi + 1;
                }
            }
            res = sb.toString();
        }
        return res;
    }
}
