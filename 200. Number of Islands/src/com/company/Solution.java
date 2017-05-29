package com.company;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by derec on 0028, May, 28, 2017.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int ret = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    ret += 1;
                    Queue<int[]> q = new LinkedList<>();
                    int[] newloc = {i,j};
                    q.add(newloc);
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        int cur_x = curr[0]; int cur_y = curr[1];
                        grid[cur_x][cur_y] = '+';
                        if(cur_x > 0 && grid[cur_x-1][cur_y] == '1'){
                            int[] neighloc = {cur_x-1, cur_y};
                            q.add(neighloc);
                        }
                        if(cur_y > 0 && grid[cur_x][cur_y-1] == '1'){
                            int[] neighloc = {cur_x, cur_y-1};
                            q.add(neighloc);
                        }
                        if(cur_x < grid.length-1 && grid[cur_x+1][cur_y] == '1'){
                            int[] neighloc = {cur_x+1, cur_y};
                            q.add(neighloc);
                        }
                        if(cur_y < grid[cur_x].length-1 && grid[cur_x][cur_y+1] == '1'){
                            int[] neighloc = {cur_x, cur_y+1};
                            q.add(neighloc);
                        }
                    }
                }
            }
        }

        return ret;
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
}
