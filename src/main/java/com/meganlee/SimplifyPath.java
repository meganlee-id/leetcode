package com.meganlee;

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        // input validation: assume that the path is a valid path
        if (path == null || path.length() == 0) {
            return "";
        }
        // simplify the path first
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack();
        List<String> skippable = Arrays.asList("..", ".", "");
        for (String dir : dirs) {
            if (dir.equals("..") && !stack.isEmpty()) { // go to parent
                stack.pop();
            } else if (!skippable.contains(dir)) { // skip "..": stack.isEmpty(), skip "" or ".": same dir
                stack.push(dir);
            }
        }
        // build the path string
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/" + dir);
        }
        return sb.length() == 0 ? "/" : sb.toString(); // remember to check whether sb is empty
    }
}