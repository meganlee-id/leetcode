package com.meganlee;

public class AddBinary {

    // NOTICE: the solutions didn't consider when a or b is NULL
    // need to add null checker!!

    //--------------- Solution 1  ----------------//
    // recursion: T=O(N), S=O(N) sum string/recursion call
    public String addBinary(String a, String b) {
        return helper(a, b, 0).toString();
    }

    private StringBuilder helper(String a, String b, int carry) {
        // base case
        if (a.isEmpty() && b.isEmpty() && carry == 0) {
            return new StringBuilder();
        }

        // general case
        int digitA = a.isEmpty() ? 0 : a.charAt(a.length() - 1) - '0';
        int digitB = b.isEmpty() ? 0 : b.charAt(b.length() - 1) - '0';
        int sum = digitA + digitB + carry;
        carry = sum / 10;

        String aRest = a.isEmpty() ? "" : a.substring(0, a.length() - 1);
        String bRest = b.isEmpty() ? "" : b.substring(0, b.length() - 1);
        StringBuilder res = helper(aRest, bRest, carry);
        return res.append(sum % 10);
    }

    //--------------- Solution 2  ----------------//
    // iterative: T=O(N), S=O(N) sumList/recursion call
    public String addBinary2(String a, String b) {
        // both a and b are non-empty strings
        int carry = 0;
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            // sum the current digit
            int digitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int digitB = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum / 2;
            res.append(sum % 2);

            // update iterator
            i = (i >= 0) ? i - 1 : -1; // i--; also works
            j = (j >= 0) ? j - 1 : -1; // j--; also works
        }
        return res.reverse().toString();
    }
}

