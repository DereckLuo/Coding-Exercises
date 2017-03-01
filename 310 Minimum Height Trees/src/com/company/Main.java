package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int nodes = 6;
        int[][] edges = new {{0,3}.{1,3},{2,3},{4,3}.{5,4}};

        Solution sol = new Solution();

        List<Integer> ret = sol.findMinHeightTrees(nodes, edges);

        System.out.println("The root of MHTs are : ");
        System.out.println(ret);

    }
}
