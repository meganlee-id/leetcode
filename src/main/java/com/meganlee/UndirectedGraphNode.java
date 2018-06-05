package com.meganlee;

import java.util.*;

public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int val) {
        label = val;
        neighbors = new ArrayList();
    }
}
