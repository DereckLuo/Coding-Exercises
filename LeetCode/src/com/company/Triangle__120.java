package com.company;

import java.util.List;

/**
 * 120. Triangle
 *      Given a triangle, find the minium path sum from top to bottom. Each step
 *      you may move to adjacent numbers on the row below
 */
public class Triangle__120 {

    //Try to use DP solution:
    //mem[i][j] contains the minimum sum path from i-row j-column
    //return mem[0][0]
    //each cell depends on the two subcells, therefor, fill up 2D array from bottom up
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] mem = new int[triangle.size()][triangle.get(height-1).size()];
        //fill up last row
        for(int i = 0; i < triangle.get(height-1).size(); i++){
            mem[height-1][i] = triangle.get(height-1).get(i);
        }
        //fill up rest 2D matrix
        for(int i = height-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                mem[i][j] = triangle.get(i).get(j) + Math.min(mem[i+1][j], mem[i+1][j+1]);
            }
        }
        // printTable(mem);
        return mem[0][0];
    }

    private void printTable(int[][] table){
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                System.out.print(table[i][j]); System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
