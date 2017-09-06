package com.company;

import java.util.Arrays;

/**
 * 279. Perfect Squares
 *      Given a positive integer n, find the least number of perfect square numbers
 *      (for example, 1,4,9,16,...) which sum to n
 *      For example, given n = 12, return 3
 *          because 12 = 4 + 4 + 4;
 *      given n = 13, return 2 because 13 = 4 + 9
 */
public class Perfect_Squares__279 {
    public int numSquares(int n){
        /**
         * Interesting BFS solution:
         *      Consider a graph, where each node is a number.
         *      Node i and node j is connected iff i + k^2 = j or j + k^2 = i
         *      Start a BFS from node 0, and see how many levels it reaches n
         */
        /**
         * Basic DP solution:
         *      For array 0 to n, each cell contains numSquares to obtain that number
         *      calculate the array and return cell[n]
         */
        if (n <= 0) return 0;

        int[] table = new int[n+1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        for(int i = 1; i < table.length; i++){
            for(int j = 1; j*j <= i; j++){
                table[i] = Math.min(table[i], table[i-j*j] + 1);
            }
        }
        return table[table.length];
    }

}
