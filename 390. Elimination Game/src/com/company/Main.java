package com.company;

public class Main {

    /**
     *  390. Elimination Game
     *      There is a list of sorted integers from 1 to n . Starting from left to right,
     *      remove the first number and every other number afterward until you
     *      reach the end of the list.
     *      Repeat the previous step again, but this time from right to left, remove the right
     *      most number and every other number from the remaining numbers.
     *      We keep repeating the steps again, alternating left to right and right to left,
     *      until a signle number remains.
     *      Find the last number that remains starting with a list of length n
     *
     *      Example:
     *      input:
     *      n = 9,
     *      1_ 2 3_ 4 5_ 6 7_ 8 9_
     *      2 4_ 6 8_
     *      2_ 6
     *      6
     *      output 6
     */
    public static void main(String[] args) {
	// write your code here
        int input = 9;
        Solution sol = new Solution();

        int output = sol.lastRemaining(input);

        System.out.println("The last remaining is : " + Integer.toString(output));
    }
}
