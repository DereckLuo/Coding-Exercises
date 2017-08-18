package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public boolean canWinNim(int n){


        boolean ret =  canWinMath(n);
        return ret;
    }

    /**
     * Faster solution -- using math
     * First one who got the number that is multiple of 4 will lose, otherwise he will win
     */
    private boolean canWinMath(int n){
        return n % 4 != 0;
    }

    /**
     * Linear DP solution -- iterative (Still run into Time problem)
     * table -- 1 can win, -- 0 do not know, -- -1 can lose
     */
    private boolean canWinDP(int n){
        HashMap<Integer, Integer> table = new HashMap<>();
//        int[] table = new int[n+1];
        for(int i = 1; i < n+1; i++){
            if(i <= 3) table.put(i,1);
            else{
                if(table.get(i-1) == 1 && table.get(i-2) == 1 && table.get(i-3) == 1){
                    table.put(i,-1);
                }
                else{
                    table.put(i,1);
                }
            }
        }
        return table.get(n) == 1 ? true : false;
    }

    /**
     * Recursive Solution -- Run out of time. Need DP
     * Indicate can current player win,
     * 1 -- me
     * -1 -- opponent
     */
    private boolean canWinRec(int n, int turn){
        if(n <= 3) return true;

        boolean one = canWinRec(n-1,  turn*-1);
        boolean two = canWinRec(n-2,  turn*-1);
        boolean three = canWinRec(n-3,  turn*-1);

        if(one && two && three) return false;
        else return true;
    }

    private void printTable(int[] table){
        for(int num : table){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println("\n");
    }
}
