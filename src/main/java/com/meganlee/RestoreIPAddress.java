package com.meganlee;

import java.util.*;

public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        // input checking
        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList();
        }
        // recursive call
        List<String> res = new ArrayList();
        helper(res, new ArrayList(), s);
        return res;
    }

    private void helper(List<String> res, List<Integer> nums, String s) {
        //---- base case: stop condition
        // 4 nums collected
        if (nums.size() == 4) {
            if (s.length() == 0) { // MAKE SURE no more chars in s left
                res.add(nums.get(0) + "." + nums.get(1) + "." + nums.get(2) + "." + nums.get(3));
            }
            return;
        }
        //---- general case
        // condition: there are <= 3 nums and there cur < s.length()
        for (int i = 1; i <= Math.min(3, s.length()); i++) {
            String valStr = s.substring(0, i);
            int val = Integer.valueOf(valStr);
            if (0 <= val && val <= 255 && valStr.equals(val + "")) { // no heading zeros
                nums.add(val);
                helper(res, nums, s.substring(i));
                nums.remove(nums.size() - 1);
            }
        }
    }
}