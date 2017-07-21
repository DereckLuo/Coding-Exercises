package com.company;

/**
 * 477. Total Hamming Distance
 *
 *  The Hamming distance between two integers is the number of positions at which the corresponding
 *  bits are different.
 *
 *  Your job is to find the total Hamming distance between all pairs of the given numbers
 *  Example:
 *  Input: 4, 14, 2
 *  Output 6
 *  Explanation: in binary representation, 4 is 0100, 14 is 1110, 2 is 0010
 *  Answer: HamingDistance(4,14) + HamingDistance(4,2) + HamingDistance(14,2) = 2+2+2=6
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input = {4,14,4,14};
        Solution sol = new Solution();

        int output = sol.totalHammingDistance(input);

        System.out.println("The total HammingDistance is " + Integer.toString(output));

    }
}
