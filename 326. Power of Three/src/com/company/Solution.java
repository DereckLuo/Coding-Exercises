package com.company;

public class Solution {

    public boolean isPowerOfThree(int n){
        if( n == 1) return true;
        long base = 1;
        while(base < n){
            base *= 3;
        }
        return base == n? true : false;
    }
}
