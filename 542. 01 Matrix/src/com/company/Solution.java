package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * BFS Solution
     *
     */
    public int[][] updateMatrix(int[][] matrix){
        int m = matrix.length;      //rows
        int n = matrix[0].length;   //columns

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){ //first loop find all 0s in the matrix
            for(int j = 0; j < n; j ++){
                if (matrix[i][j] == 0){
                    queue.offer(new int[] {i,j});
                }
                else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] d: dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[]{r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }


    public void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
