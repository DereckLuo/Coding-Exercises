package com.company;

public class Solution {
    /**
     * Using DP to solve the problem,
     * For each number from left to right, i can chose remove or not remove
     * num : the initial number, k the number of numbers need to be removed
     */
    public String removeKdigits(String num, int k){
        int ret = removeRec(num, k, 0);
    }

    private int removeRec(String num, int k, int index){

    }
}
