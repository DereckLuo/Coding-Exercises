package com.company;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of
 * its neighbors
 */
public class Clone_Graph__133 {

    class UndirectedGraphNode extends Clone_Graph__133{
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>();}

    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, Integer> trackTable = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashMap<Integer, UndirectedGraphNode> copyTable = new HashMap<>();

        q.offer(node);
        trackTable.put(node, 1);
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        // addNeighbors(root, node.neighbors);
        copyTable.put(root.label, root);


        while(!q.isEmpty()){
            UndirectedGraphNode curNode = q.poll();
            UndirectedGraphNode copyNode = copyTable.get(curNode.label);
            for(UndirectedGraphNode nodes : curNode.neighbors){
                if(!trackTable.containsKey(nodes)){
                    trackTable.put(nodes,1);
                    q.offer(nodes);
                    UndirectedGraphNode newNode = new UndirectedGraphNode(nodes.label);
                    copyTable.put(newNode.label, newNode);
                }
                copyNode.neighbors.add(copyTable.get(nodes.label));
            }
        }
        return root;
    }

    private void addNeighbors(UndirectedGraphNode node, List<UndirectedGraphNode> neighbors){
        for(UndirectedGraphNode neighbor : neighbors){
            node.neighbors.add(neighbor);
        }
    }
}
