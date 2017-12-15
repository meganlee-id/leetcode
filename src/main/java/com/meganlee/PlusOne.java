package com.meganlee;

public class PlusOne {
    // T=O(n) s=O(n)
    // Question 1: is digits valid? null? empty? each elem [0, 9]?
    // Question 2: what is the base? 2 or 10?
    // Question 3: can I modify the original digits
    // Question 4: most significant digit where? 
    // Question 5: leading 0s?

    //--------------- Solution 1 ----------------//
    public int[] plusOne(int[] digits) {
        // input validation
        if (digits == null || digits.length == 0) {
            return digits;
        }
        // If we r not allowed to modify the original array:
        // int[] copy =  digits.clone();
        
        // Assume we could modify the original array
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            // fast break when carry is 0
            if (carry == 0) {
                return digits;
            }
        }

        // when finally carry is 1, the rest must be 0
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    //--------------- Solution 2 ----------------//
    public int[] plusOne2(int[] digits) {
        // input validation
        if (digits == null || digits.length == 0) {
            return digits;
        }

        // find the first digit backwards that's not 9
        for (int i = digits.length - 1; i >= 0; i--) {
            // tailing 9, after +1, would be 0
            if (digits[i] == 9) { 
                digits[i] = 0;
            // find the first digit less than 9, increment here and return 
            } else {
                digits[i]++;
                return digits;
            }
        }
        
        // if we reach here, the origin digits is all 9, such as 9999
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
