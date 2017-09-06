package com.company;

/**
 * 414.
 * Given a non-empty array of integers, return the third maximum number in this array
 * If it does not exist, return the maximum number.
 *
 * Require running time O(n)
 *
 * Example:
 *  Input: [3,2,1]      Output: 1
 *  Input: [1,2]        Output: 2
 *  Input: [2,2,3,1]    Output: 1
 */
public class Third_Maximum_Number__414 {
    public int thirdMax(int[] nums){
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
