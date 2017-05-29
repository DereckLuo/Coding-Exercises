package com.company;

public class Main {
    /**
     * 200. Number of Islands
     *  Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by
     *  water and is formed by connecting adjacent lands horizontally or vertically.
     *  You may assume all four edges of the grid are all surrounded by water.
     */
    public static void main(String[] args) {
	// write your code here
        char[][] grid = createGrid();
        printGrid(grid);
        Solution sol = new Solution();
        int output = sol.numIslands(grid);
        System.out.println("Number of island is : " + Integer.toString(output));
    }

    public static void printGrid(char[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static char[][] createGrid(){
        char[][] ret = new char[4][5];
        ret[0][0] = '1'; ret[0][1] = '1'; ret[0][2] = '1'; ret[0][3] = '1'; ret[0][4] = '1';
        ret[1][0] = '1'; ret[1][1] = '1'; ret[1][2] = '1'; ret[1][3] = '1'; ret[1][4] = '1';
        ret[2][0] = '0'; ret[2][1] = '0'; ret[2][2] = '1'; ret[2][3] = '0'; ret[2][4] = '0';
        ret[3][0] = '1'; ret[3][1] = '1'; ret[3][2] = '1'; ret[3][3] = '1'; ret[3][4] = '1';
        return ret;
    }
}
