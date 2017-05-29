package com.company;

public class Main {

    /**
     * 480. Sliding Window Median
     *  Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the
     *  median is the mean of the two middle value.
     *  Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
     *  very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     *  Your job is to output the median array for each window in the original array
     */
    public static void main(String[] args) {
	// write your code here
        int[] input = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Solution sol = new Solution();

        double[] output = sol.medianSlidingWindow(input, k);

        for(double num: output){
            System.out.print(num);
            System.out.print(" ");
        }
    }
}
