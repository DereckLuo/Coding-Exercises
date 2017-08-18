package com.company;

public class Main {

    /**
     * 201. Bitwise AND of Numbers Range
     *  Given a range[m,n] where 0 <= m <= n <= IntMAX, return the bitwise AND
     *  of all numbers in this range, inclusive
     *  For example, given the range [5,7], you should return 4
     */
    public static void main(String[] args) {
	// write your code here
        int m = 5, n = 7;
        Solution sol = new Solution();
        int output = sol.rangeBitwiseAnd(m,n);
        System.out.println(output);
    }
}
