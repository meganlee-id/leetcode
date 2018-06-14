package com.meganlee;

public class RemoveKDigits {
    // Syntax:  (?!pattern) negative lookahead
    // Regex:   "grey(?!hound)"
    // String:  "the gray greyhound ate the grey socks")
    // Exlain:  "grey" is matched, only if it's NOT followed by hound
    //          so in this case, only the "grey" followed by socks is matched
    // Application: removing only leading '0', do not remove '0' if there is only one '0'
    //              used a lot in number string processing
    // s.replaceFirst("^0+(?!$)", "")
    // String[] in = {
    //     "01234",         // "[1234]"
    //     "0001234a",      // "[1234a]"
    //     "101234",        // "[101234]"
    //     "000002829839",  // "[2829839]"
    //     "0",             // "[0]"
    //     "0000000",       // "[0]"
    //     "0000009",       // "[9]"
    //     "000000z",       // "[z]"
    //     "000000.z",      // "[.z]"
    // };
    // for (String s : in) {
    //     System.out.println("[" + s.replaceFirst("^0+(?!$)", "") + "]");
    // }
    public String removeKdigits(String num, int k) {
        // test case: "10", 2
        if (num.length() <= k) return "0"; 
        int removedCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : num.toCharArray()) {
            while (sb.length() != 0 && removedCnt < k && sb.charAt(sb.length() - 1) > ch) {
                sb.deleteCharAt(sb.length() - 1); // sb.setLength(sb.length() - 1);
                removedCnt++;
            }
            sb.append(ch);
        }
        // remove leading '0 
        String res = sb.substring(0, num.length() - k).toString().replaceFirst("^0+(?!$)", "");
        return res.length() == 0 ? "0" : res;
    }
}