package com.meganlee;

public class PalindromeNumber {
    //------------- Solution 1 ---------------//
    // use StringBuilder library
    // space = O(n)
    public boolean isPalindrome(int x) {
        // pay attention to negative numbers
        if (x < 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder().append(x);
        return sb.toString().equals(sb.reverse().toString());
    }

    //------------- Solution 2 ---------------//
    // original == reversed
    // space = 2 long type variables
    public boolean isPalindrome2(int x) {
        // pay attention to negative numbers
        if (x < 0) {
            return false;
        }
        // use long type to prevent reversed overflow
        long reversed = 0; // could also use StringBuilder
        long xCopy = x;
        while (xCopy > 0) {
            reversed = reversed * 10 + xCopy % 10;
            xCopy /= 10;
        }
        return reversed == x;
    }

    //------------- Solution 3 ---------------//
    // from two sides to middle
    public boolean isPalindrome3(int x) {
        // pay attention to negative numbers
        if (x < 0) {
            return false;
        }

        int div = 1, temp = x;       // div is the dividor, e.g x=3223, div=1000
        while (temp / div >= 10) {   // pay attention not to over flow
            div *= 10;
        }
        while (x > 0) {
            if (x / div != x % 10) { // compare highest with lowest digits
                return false;
            }
            x = (x % div) / 10;      // remove higest and lowest digit
            div /= 100;              // shrink dividor
        }
        return true;
    }
}
