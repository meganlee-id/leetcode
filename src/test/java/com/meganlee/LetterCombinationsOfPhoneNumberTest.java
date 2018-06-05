package com.meganlee;

import java.util.*;
import org.junit.*;

public class LetterCombinationsOfPhoneNumberTest {
    LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();
    private String calculate(String digits) {
        List<String> res = solution.letterCombinations2(digits);
        System.out.println(digits);
        for (String s: res) {
            System.out.print(String.format("\"%s\"  ", s));
        }
        System.out.println();
        Collections.sort(res);
        return res.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals(
            "[dagj, dagk, dagl, dahj, dahk, dahl, daij, daik, dail, dbgj, dbgk, dbgl, dbhj, dbhk, dbhl, dbij, dbik, dbil, dcgj, dcgk, dcgl, dchj, dchk, dchl, dcij, dcik, dcil, eagj, eagk, eagl, eahj, eahk, eahl, eaij, eaik, eail, ebgj, ebgk, ebgl, ebhj, ebhk, ebhl, ebij, ebik, ebil, ecgj, ecgk, ecgl, echj, echk, echl, ecij, ecik, ecil, fagj, fagk, fagl, fahj, fahk, fahl, faij, faik, fail, fbgj, fbgk, fbgl, fbhj, fbhk, fbhl, fbij, fbik, fbil, fcgj, fcgk, fcgl, fchj, fchk, fchl, fcij, fcik, fcil]",
            calculate("3245")
        );
        Assert.assertEquals(
            "[ad, ae, af, bd, be, bf, cd, ce, cf]", 
            calculate("23")
        );
    }
}

