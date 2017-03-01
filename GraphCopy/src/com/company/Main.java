package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        graph g = new graph();
        g.buildGraph();
        g.printGraph();

        System.out.println("Copying graph ~~~~~");
        graph copy = new graph();
        copy.copy(g.getRoot());
        copy.printGraph();
    }
}
