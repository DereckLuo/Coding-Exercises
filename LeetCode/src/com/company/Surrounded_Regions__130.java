package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 130. Surrounded Regions
 *      Given a 2D board containing 'x' and 'o', capture all regions surrounded by 'x'
 *      A region is captured by filling all 'o's into 'x's in that surronded region
 *
 *      Example
 *
 *      x x x x         x x x x
 *      x o o x   -->   x x x x
 *      x x o x         x x x x
 *      x o x x         x o x x
 *
 */
public class Surrounded_Regions__130 {
    //BFS search find all non-dead 'O', and mark rest to be 'X'
    public void solve (char[][] board){
        if(board.length == 0) return;
        List<int[]> roots = new ArrayList<>();
        int y = board.length, x = board[0].length;

        //find all roots around the side
        for(int i = 0; i < x; i++){
            if(board[0][i] == 'O') roots.add(new int[]{i,0});
            if(board[y-1][i] == 'O') roots.add(new int[]{i, y-1});
        }
        for(int i = 0; i < y; i++){
            if(board[i][0] == 'O') roots.add(new int[]{0,i});
            if(board[i][x-1] == 'O') roots.add(new int[]{x-1,i});
        }

        //BFS for all roots
        Queue<int[]> q = new LinkedList<>();
        for(int[] pairs : roots){
            if(board[pairs[1]][pairs[0]] != '+'){
                q.offer(pairs);
                board[pairs[1]][pairs[0]] = '+';
                while(!q.isEmpty()){
                    int[] curr = q.poll();
                    int curr_x = curr[0], curr_y = curr[1];
                    // System.out.println(Integer.toString(curr_x) +","+ Integer.toString(curr_y));
                    if(curr_x > 0 && board[curr_y][curr_x-1] == 'O'){ //left
                        // System.out.println("cp1");
                        board[curr_y][curr_x-1] = '+';
                        q.offer(new int[]{curr_x-1, curr_y});
                    }
                    if(curr_x < x-1 && board[curr_y][curr_x+1] == 'O'){ //right
                        // System.out.println("cp2");
                        board[curr_y][curr_x+1] = '+';
                        q.offer(new int[]{curr_x+1,curr_y});
                    }
                    if(curr_y > 0 && board[curr_y-1][curr_x] == 'O'){ //top
                        // System.out.println("cp3");
                        board[curr_y-1][curr_x] = '+';
                        q.offer(new int[]{curr_x,curr_y-1});
                    }
                    if(curr_y < y-1 && board[curr_y+1][curr_x] == 'O'){ //bot
                        // System.out.println("cp4");
                        board[curr_y+1][curr_x] = '+';
                        q.offer(new int[]{curr_x,curr_y+1});
                    }
                }
            }
        }

        //going thorugh entire matrix and change all chars
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '+') board[i][j] = 'O';
            }
        }
    }
}

