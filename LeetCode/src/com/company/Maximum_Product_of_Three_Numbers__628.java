package com.company;

import java.util.Arrays;

/**
 * 628. Maximum PRoduct of Tree Numbers
 *      Given an integer array, find three numbers whose product is maximum and
 *      output the maximum product
 *
 *      Don't need to consider overflow, but array contains negative int as well
 */
public class Maximum_Product_of_Three_Numbers__628 {
    public int maximumProduct(int[] nums){
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
