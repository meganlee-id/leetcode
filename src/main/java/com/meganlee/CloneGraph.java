package com.meganlee;

import java.util.*;

public class CloneGraph {
    //---------------------- Solution -------------------//
    // BFS-Queue (DFS--stack)
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> q  = new LinkedList(Arrays.asList(node));
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap();
        UndirectedGraphNode nodeClone = new UndirectedGraphNode(node.label);
        visited.put(node, nodeClone); // put original node -> nodeClone into visitedMapTable
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode n : cur.neighbors) {
                // create new NODES if not visited
                if (!visited.containsKey(n)) {
                    q.offer(n); // put in queue
                    visited.put(n, new UndirectedGraphNode(n.label)); // create new node
                }
                // create new EDGES
                UndirectedGraphNode curClone = visited.get(cur);
                UndirectedGraphNode neighborClone = visited.get(n);
                curClone.neighbors.add(neighborClone);
            }
        }
        return nodeClone;
    }
}

