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
                // add the current line
                addLine2(res, line, L, curLen, i == words.length - 1);
                // reset for next line
                curLen = 0;
                line.clear();
            }
        }
        return res;
    }

    private void addLine(List<String> res, List<String> line, int L, int curLen, boolean lastLine) {
        if (line.size() == 1) { // one word
            res.add(String.format("%-" + L + "s", line.get(0))); // String.format("%-10s", "hello") => "hello     "
        } else { // >= 2 words
            int spaces = (L - curLen) / (line.size() - 1); // spaces
            int extra  = (L - curLen) % (line.size() - 1); // # of extra spaces
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.size(); i++) {
                sb.append(line.get(i));
                if (i != line.size() - 1) { // add spaces between words
                    String s = String.format("%" + spaces + "s", "") + ((extra-- > 0) ? " " : ""); // space between each words
                    sb.append(lastLine ? " " : s);
                } else if (lastLine) {      // add trailing spaces for last line
                    sb.append(String.format("%" + (L - sb.length()) + "s", ""));
                }
            }
            res.add(sb.toString());
        }
    }

    // a 2nd way to: this is faster than String.format()
    private void addLine2(List<String> res, List<String> line, int L, int curLen, boolean lastLine) {
        StringBuilder sb = new StringBuilder();
        char[] paddings = new char[L];
        Arrays.fill(paddings, ' ');
        if (lastLine || line.size() == 1) { // last line or only one word
            for (String w : line) {
                sb.append(w + " "); // add only one space between words
            }
            sb.append(paddings); // paddings will be trimed at line 74
        } else { // >= 2 words, and NOT last line
            int spaces = (L - curLen) / (line.size() - 1);
            int extra  = (L - curLen) % (line.size() - 1); // # of extra spaces
            for (int i = 0; i < line.size(); i++) {
                sb.append(line.get(i));
                if (i != line.size() - 1) {
                    int numSpaces = spaces + ((extra-- > 0) ? 1 : 0); // do add a () around ternary operator!!
                    for (int j = 0; j < numSpaces; j++) {
                        sb.append(" ");
                    }
                }
            }
        }
        res.add(sb.substring(0, L)); // could also manipulate sb.delete(start, end)
    }

}