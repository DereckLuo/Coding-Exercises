package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a = 2;
        int[] b = new int[]{2,0,0};
        Solution sol = new Solution();
        int ret = sol.superPow(a, b);
        System.out.println("The result is : " + Integer.toString(ret));
    }
}
