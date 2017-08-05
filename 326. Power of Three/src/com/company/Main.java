package com.company;

public class Main {

    /**
     * 326. Poewr of Three
     *  Given an integer, write a function to determine if it is a power of three
     *  Follow up:
     *      Could you do it without using any loop/recursion?
     */
    public static void main(String[] args) {
	// write your code here
        int input = 27;
        Solution sol = new Solution();

        boolean output = sol.isPowerOfThree(input);

        String printput = output == true? "True" : "False";
        System.out.println(printput);
    }
}
