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
        String res = "1"; // the 1st item
        for (int i = 1; i < n; i++) { // looking fot the Nth item
            StringBuilder sb = new StringBuilder();
            for (int start = 0, end  = 0; end < res.length(); end++) {
                // 1. no cache to update
                // 2. update start to keep variant
                //--- last char in str -----||----- last char consecutive ---------||
                if (end == res.length() - 1 || res.charAt(end) != res.charAt(end + 1)) {
                    sb.append((end - start + 1) + "" + res.charAt(end));
                    start = end + 1;
                }
            }
            // 3. update res
            res = sb.toString();
        }
        return res;
    }
}
