package com.company;

public class Main {

    /**
     * 189. Rotate Array
     *  Rotate an array of n elements to the right by k steps
     *  For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated
     *  to [5,6,7,1,2,3,4]
     */
    public static void main(String[] args) {
	// write your code here
        int[] input = {1,2,3,4,5,6,7};
        int k = 12;

        Solution sol = new Solution();

        sol.rotate(input, k);

        sol.printArray(input);
    }
}
