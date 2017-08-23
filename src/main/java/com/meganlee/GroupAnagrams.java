package com.meganlee;

import java.util.*;

public class GroupAnagrams {
    //------------------- Solution 2 -------------------//
    // KEY: sorted string 
    public List<List<String>> groupAnagrams(String[] strs) {
        // input check
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        // put anagrams into the same bin (key is sorted str)
        Map<String, List<String>> map = new HashMap();
        for (String s : strs) {
            // get key, sort the s
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            // put current string into group
            List<String> group = map.containsKey(key) ? map.get(key) : new ArrayList();
            group.add(s);
            map.put(key, group); // do NOT do map.put(key, group.add(s))!! group.add(s) return value is a boolean!!!
        }
        return new ArrayList(map.values()); // map.values() return value is of type AbstractCollection
    }

    //------------------- Solution 2 -------------------//
    // KEY: prime numbers multiplication
    public List<List<String>> groupAnagrams2(String[] strs) {
        // input check
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        // assume 1) only 26 characters 2) all lowercases 3) length of strs within Integer range
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        HashMap<Integer, List<String>> map = new HashMap();
        for (String s : strs) {
            // get key, prime number multiplications
            int key = 1;
            for (char ch : s.toCharArray()) {
                key *= prime[ch - 'a'];
            }
            // put current string into group
            List<String> group = map.containsKey(key) ? map.get(key) : new ArrayList();
            group.add(s);
            map.put(key, group); // do NOT do map.put(key, group.add(s))!! group.add(s) return value is a boolean!!!
        } 
        return new ArrayList(map.values()); // map.values() return value is of type AbstractCollection
    }
}


