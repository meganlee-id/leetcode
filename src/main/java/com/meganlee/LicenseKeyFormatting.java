package com.meganlee;

import java.util.*;

class LicenseKeyFormatting {
    //--------------- Solution  ----------------//
    /////////   Character related methods  //////////
    //
    // 1) char is alphanumeric  
    //      Character.isLetter(ch) || Character.isDigit(ch)
    //      Character.isLetterOrDigit(ch)
    //      ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ('0' <= ch && ch <= '9')
    // 2) char is uppercase     Character.isUpperCase(ch)
    //        java> Character.isUpperCase('.')
    //        java.lang.Boolean res5 = false
    //        java> Character.isUpperCase('a')
    //        java.lang.Boolean res6 = false
    //        java> Character.isUpperCase('A')
    //        java.lang.Boolean res7 = true
    // 3) char to to UpperCase Character.toUpperCase(ch)
    //        java> Character.toUpperCase('0')
    //        java.lang.Character res0 = 0
    //        java> Character.toUpperCase('a')
    //        java.lang.Character res1 = A
    //        java> Character.toUpperCase('A')
    // 4) java> int A = 'A'
    //        int A = 65
    //        java> int a = 'a'
    //        int a = 97
    //        java> 'a' - 'A'
    //        java.lang.Integer res5 = 32
    //        java> int c = '0'
    //        int c = 48
    // 5) '' is not a valid character!!
    //
    /////////   Stringrelated methods  //////////
    //
    // 1) sb doesn't have replaceAll, string has
    // 2)   replace(char oldChar, char newChar)  replace all
    //      replace(CharSequence old, CharSequence new)  replace all
    //      replaceAll(String regex, String replacement)
    //      replaceFirst(String regex, String replacement)
    // 3) string.toUpperCase()
    //
    ///////////// edge case ///////////////
    // 
    // leading or tailing consecutive  dashes
    // "----24A0-R74K-"
    //

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (ch != '-') { // a valid license char
                if ((sb.length() + 1) % (K + 1) == 0) { // think about when to deal with '-', beginning or end of a group
                    sb.append('-');
                }
                sb.append(ch);
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}