package com.meganlee;

import java.util.*;

public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        // input checking: we need to assume L is larger than any words in text!
        List<String> res = new ArrayList();
        if (L <= 0 || words == null || words.length == 0) {
            res.add("");
            return res;
        }

        int curLen = 0; // cur line's all so far picked up words'len sum
        List<String> line = new ArrayList(); // cur line all words accumulated so far
        for (int i = 0; i < words.length; i++) {
            curLen += words[i].length();
            line.add(words[i]);
            //  ---- last word ----   || ----- line terminates at current word ------
            if (i == words.length - 1 || curLen + words[i + 1].length() + line.size() > L) {
                // add current line to res
                formatAndAddLine(res, line, L, curLen, i == words.length - 1);
                // reset for next line
                curLen = 0;
                line.clear();
            }
        }
        return res;
    }

    // String.format and String.join(separator, List/Arr) is slow but concise: 20ms
    private void formatAndAddLine(List<String> res, List<String> line, int L, int curLen, boolean lastLine) {
        StringBuilder sb = new StringBuilder();
        if (lastLine || line.size() == 1) { // last line || only one word
            sb.append(String.format("%-" + L + "s", String.join(" ", line))); // '%-'' means extra spaces will be append at the end, L is total len
        } else { // not last line AND >= 2 words
            int spaces = (L - curLen) / (line.size() - 1);
            int extra  = (L - curLen) % (line.size() - 1); // # of extra spaces
            for (int i = 0; i < line.size(); i++) {
                // add word
                sb.append(line.get(i));
                // add sapces (if not last word)
                if (i != line.size() - 1) {
                    int numSpaces = spaces + ((extra-- > 0) ? 1 : 0); // do add a () around ternary operator!!
                    sb.append(String.format("%" + numSpaces + "s", ""));
                }
            }
        }
        res.add(sb.toString());
    }

    // use for loop instead of String utils: 1ms
    private void formatAndAddLine2(List<String> res, List<String> line, int L, int curLen, boolean lastLine) {
        StringBuilder sb = new StringBuilder();
        if (lastLine || line.size() == 1) { // last line || only one word
            for (String w: line) {  //~~~~~~~~ diff 1
                sb.append(w + " ");
            }
            while (sb.length() < L) {
                sb.append(" ");
            }
        } else { // not last line AND >= 2 words
            int spaces = (L - curLen) / (line.size() - 1);
            int extra  = (L - curLen) % (line.size() - 1); // # of extra spaces
            for (int i = 0; i < line.size(); i++) {
                // add word
                sb.append(line.get(i));
                // add sapces (if not last word)
                if (i != line.size() - 1) {
                    int numSpaces = spaces + ((extra-- > 0) ? 1 : 0); // do add a () around ternary operator!!
                    for (int j = 0; j < numSpaces; j++) {   //~~~~~~ diff 2
                        sb.append(" ");
                    }
                }
            }
        }
        res.add(sb.substring(0, L));    //~~~~~ diff3
    }
}