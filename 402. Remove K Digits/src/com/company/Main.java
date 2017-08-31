package com.company;

public class Main {
    /**
     * 402. Remove K Digits
     *  Given a non-negative integer num represented as a string, remove k digits from the number
     *  so that the new number is the smallest possible
     *
     *  Note:
     *      The length of num is less than 10002 and will be >= k
     *      The given num does not contain any leading zeros
     *
     *  Example :
     *      input: num = "1432219", k = 3
     *      output: "1219"
     */

    public static void main(String[] args) {
	// write your code here
        String input = "1432219";
        Solution sol = new Solution();

        String output = sol.removeKdigits(input, 3);

        System.out.println(output);
    }
}
