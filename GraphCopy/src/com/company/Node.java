package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dereck on 0001, March 1, 2017.
 */
public class Node {
    private int value;
    private List<Node> neighbors = new LinkedList<>();


    public Node(int newval){
        value = newval;
    }


    public int getValue(){ return value;}

    public List<Node> getNeighbors(){return neighbors;}

    public void addNeighbor(Node node){
        neighbors.add(node);
    }
}
