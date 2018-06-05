package com.meganlee;


public class MultiplyStrings {
    // T=O(M*N), S=O(M+N)
    //-----------------   SOLUTION  ---------------------//
    // mimic the multiplication of math 
    public String multiply(String num1, String num2) {
        //======= will pass without this  ======//
        // input checking
        if (num1 == null || num2 == null || num1.length() == 0  || num2.length() == 0) {
            return "";
        }
        // quick return
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        //======== multiplication =========//
        int N1 = num1.length(), N2 = num2.length();
        int[] product = new int[N1 + N2];
        for (int i = N1 - 1; i >= 0; i--) {
            for (int j = N2 - 1; j >= 0; j--) {
                int digitProd = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int bucketSum = product[i + j + 1] + digitProd;
                product[i + j + 1] = bucketSum % 10;    // current bucket:  "=" not "+="
                product[i + j] += bucketSum / 10;       // carry:           "+=" not "="
            }
        }
        // build the res
        StringBuilder sb = new StringBuilder();
        for (int digit: product) {
            sb.append(digit);
        }
        String res = sb.toString().replaceFirst("^0+", "");
        return res.isEmpty() ? "0" : res;

        /**** alternative to build the res
        for (int digit: product) {
            if(!(sb.length() == 0 && digit == 0)) { // not leading 0
                sb.append(digit);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString(); // sb no isEmpty() method!!
        *****/
    }
}
