package com.company;

import java.util.Comparator;

/**
 * Created by Dereck on 0024, January 24, 2017.
 */
public class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node a, Node b){
        if(a.getScore() < b.getScore()){
            return -1;
        }
        else return 1;
    }
}
