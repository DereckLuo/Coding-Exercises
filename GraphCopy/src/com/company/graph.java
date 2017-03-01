package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Dereck on 0001, March 1, 2017.
 */
public class graph {
    private Node root;

    public void printGraph(){
        if(root == null){
            System.out.println("Error: Graph is null !");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node top = q.peek();
            System.out.println(top.getValue());
            for(Node n : top.getNeighbors()){
                q.add(n);
            }
            q.poll();
        }
    }

    public Node getRoot(){
        return root;
    }

    public void buildGraph(){
        Node three = new Node(3);
        Node five = new Node(5);
        Node two = new Node(2);
        root = new Node(1);
        two.addNeighbor(three); two.addNeighbor(five);
        root.addNeighbor(two);
    }

    public void copy(Node copyroot){
        if (copyroot == null) return;

        HashMap<Node, Integer> table = new HashMap<>();
        HashMap<Node, Node> match = new HashMap<>();

        Queue<Node> q = new LinkedList<>();

        q.add(copyroot);
        root = new Node(copyroot.getValue());

        match.put(copyroot, root);

        while(!q.isEmpty()){
            Node top = q.peek();
            if (!table.containsKey(top)){
                table.put(top, 1);
                Node matchtop = match.get(top);
                for(Node n : top.getNeighbors()){
                    Node child = new Node(n.getValue());
                    matchtop.addNeighbor(child);
                    match.put(n, child);
                    q.add(n);
                }
            }
            q.poll();
        }
    }
}
