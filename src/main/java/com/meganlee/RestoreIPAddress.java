package com.meganlee;

import java.util.*;

public class RestoreIPAddress {
    static final int NumParts = 4;
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList();
        List<String> parts = new ArrayList();
        collect(res, parts, s);
        return res;
    }
    
    private void collect(List<String> res, List<String> parts, String s) {
        // base case
        if (s.length() == 0 && parts.size() == NumParts) {
            res.add(String.join(".", parts));
        }
        // fast prune according to length
        if (s.length() < NumParts - parts.size() || s.length() > (NumParts - parts.size()) * 3)  {
            return;
        }
        // chunk the first part, and call next part recursively
        for (int end = 1; end <= Math.min(3, s.length()); end++) {
            String fstChunk = s.substring(0, end);
            int fstChunkVal = Integer.valueOf(fstChunk);
            if (0 <= fstChunkVal && fstChunkVal <= 255 && (fstChunkVal + "").equals(fstChunk)) {
                parts.add(fstChunk);
                collect(res, parts, s.substring(end));
                parts.remove(parts.size() - 1);
            }
        }
    }
}