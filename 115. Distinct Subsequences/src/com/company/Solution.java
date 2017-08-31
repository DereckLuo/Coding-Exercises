package com.company;


/**
 * DP solution
 *  Form a matrix mem[i][j], where mem[i+1][j+1] means S[0...j] contain T[0...i]
 *  so many times
 *  Final solution will be in mem[T.length()][S.length()]
 */
public class Solution {
    public int numDistinct(String s, String t){
        //Set up 2D array
        int[][] mem = new int[t.length()+1][s.length()+1];
        for(int i = 0; i < s.length()+1; i++){  //first row = 1 --> always contain 1 empty subsequence
            mem[0][i] = 1;
        }

        //Loop through the array, each cell depends on its left cell
        for(int i = 0; i < t.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == t.charAt(i)){
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                }
                else{
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }
        return mem[t.length()][s.length()];
    }
}
