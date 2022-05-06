package com.meganlee;

import java.util.*;

public class CloneGraph {
    //---------------------- Solution -------------------//
    // BFS-Queue (DFS--stack)
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        // mapping old -> new
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap();
        visited.put(node, new UndirectedGraphNode(node.label));
        // bfs
        Queue<UndirectedGraphNode> q = new LinkedList(Arrays.asList(node));
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode curClone = visited.get(cur);
            for (UndirectedGraphNode n : cur.neighbors) {
                // deal with new NODES
                if (!visited.containsKey(n)) {
                    q.offer(n);
                    visited.put(n, new UndirectedGraphNode(n.label));
                }
                // deal with EDGES (connections to old/new nodes)
                curClone.neighbors.add(visited.get(n));
            }
        }
        return visited.get(node);
    }
}
