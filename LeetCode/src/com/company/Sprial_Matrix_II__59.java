package com.company;

/**
 * 59. Spiral Matrix II
 *      Given an integer n, generate a square matrix filled with elements from
 *      1 to n^2 in spiral order
 *
 *      Example:
 *          Given n = 3
 *          Return:
 *          [
 *              [ 1, 2, 3],
 *              [ 8, 9, 4],
 *              [ 7, 6, 5]
 *          ]
 */
public class Sprial_Matrix_II__59 {
    public int[][] generateMatrix(int n){
        int[][] ret = new int[n][n];
        int x = 0, y = 0;
        String dir = "right";

        for(int i = 1; i <= n*n; i++){
            ret[y][x] = i;
            switch (dir){
                case "right":
                    if(x < n-1 && ret[y][x+1] == 0){
                        x += 1;
                    }
                    else{
                        dir = "down"; y +=1;
                    }
                    break;
                case "down":
                    if(y < n-1 && ret[y+1][x] == 0){
                        y += 1;
                    }
                    else{
                        dir = "left"; x -= 1;
                    }
                    break;
                case "left":
                    if(x > 0 && ret[y][x-1] == 0){
                        x -= 1;
                    }
                    else {
                        dir = "up";
                        y -= 1;
                    }
                    break;
                case "up":
                    if(y > 0 && ret[y-1][x] == 0){
                        y -= 1;
                    }
                    else{
                        dir = "right";
                        x += 1;
                    }
                    break;
                default:
                    System.out.println("Invalid case");
            }

        }
        return ret;
    }
}
