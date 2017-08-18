package com.company;

public class Solution {
    /**
     * bit manipulation:
     * The last bit is 0 if there is an odd and even number
     * therefore: when m != n there is at least an odd number and an even number in list
     * perform last bit, and shift both m and n to the right until 32 times
     */
    public int rangeBitwiseAnd(int m, int n){
        if(m == 0) return 0;
        int moveFactor = 1;
        while(m != n){
            m >>= 1; n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }

    public int rangeBitwiseAndTimeout(int m , int n) {
        int ret = m;
        for (int count = m; count <= n; count++) {
            ret &= count;
        }
        return ret;
    }
}
