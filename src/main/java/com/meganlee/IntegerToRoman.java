package com.meganlee;

public class IntegerToRoman {
    //-----------------  Solution 1 ---------------------//
    // use enum for dictionary
    public String intToRoman(int num) {
        // input checking
        if (num <= 0 || num >= 4000) {
            return null;
        }
        // largest to the lowest
        StringBuilder res = new StringBuilder();
        for (Roman digit: Roman.values()) {
            while (num >= digit.val) {
                res.append(digit); // we could append type 'Roman' directly to StringBuilder
                num -= digit.val;
            }
        }
        return res.toString();
    }

    private enum Roman {
        // arrange them from largest to smallest used in for (Roman digit : Roman.values())
        // the following line has to be written as the FIRST line in enum
        M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1); // remember the ';' at the end

        int val;
        Roman(int val) { // no 'public' decorator, by default, the decorator is 'private'
            this.val = val;
        }
    } 

    //-----------------  Solution 2 ---------------------//
    // use parallel array
    public String intToRoman2(int num) {
        // input checking
        if (num <= 0 || num >= 4000) {
            return null;
        }
        
        // build the table, magic number "1954", in desc order
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[]    vals = {1000, 900, 500, 400,  100,  90,  50,   40,   10,  9,    5,   4,    1};
        
        // append the letters
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            while (num >= vals[i]) {
                num -= vals[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}