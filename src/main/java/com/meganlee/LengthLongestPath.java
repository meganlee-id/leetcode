package com.meganlee;

import java.util.*;

class LengthLongestPath {
    public int lengthLongestPath(String input) {
        // input validation 
        if (input == null || input.length() == 0) {
            return 0;
        }
        // check line-by-line
        String[] lines = input.split("\n");
        int maxLen = 0;
        // max level is lines.length + 1
        // level 1 stores len of level 0 dir: baseLen of level 1 files
        int[] pathLen = new int[lines.length + 1];
        for (String line: lines) {
            boolean isFile = line.contains(".");
            int depth = line.lastIndexOf("\t") + 1; // lastIndexOf("\t") 
            int lineLen = line.length() - depth;
            if (isFile) {
                // pathLen[depth] instead of pathLen[depth - 1] for implementation simplicity
                maxLen = Math.max(maxLen, pathLen[depth] + lineLen); 
            } else {
                pathLen[depth + 1] = pathLen[depth] + lineLen + 1;
            }
        }
        return maxLen;
        
        // s.contains("substring");     boolean
        // s.indexOf("substring");      will return -1 if not found
        // s.lastIndexOf("substring");  will return -1 if not found
        // s.trim();                    whitespaces
        // s.replaceAll("^\t*", "")     delete all leading tabs
    }
}