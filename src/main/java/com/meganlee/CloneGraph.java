package com.meganlee;

import java.util.*;

public class CloneGraph {
    //---------------------- Solution -------------------//
    // BFS-Queue (DFS--stack)
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap();
        Queue<UndirectedGraphNode> q  = new LinkedList(Arrays.asList(node));
        UndirectedGraphNode nodeClone = new UndirectedGraphNode(node.label);
        visited.put(node, nodeClone);

        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode curClone = visited.get(cur);
            for (UndirectedGraphNode n : cur.neighbors) {
                // create new NODES if not visited
                if (!visited.containsKey(n)) {
                    q.offer(n);
                    visited.put(n, new UndirectedGraphNode(n.label));
                }
                // create new EDGES
                curClone.neighbors.add(visited.get(n));
            }
        }
        return nodeClone;
    }
}

