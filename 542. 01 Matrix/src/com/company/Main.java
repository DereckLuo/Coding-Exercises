package com.company;

public class Main {

    /**
     * 542. 01 Matrix
     *  Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
     *  The distance between two adjacent cells is 1
     *
     *  NOT a DP Solution, But a BFS Solution
     */
    public static void main(String[] args) {
	// write your code here
        int[][] input = new int[3][3];
        input[1][1] = 1;

        Solution sol = new Solution();
        sol.printMatrix(input);
        int[][] output = sol.updateMatrix(input);
        sol.printMatrix(output);

    }
}
