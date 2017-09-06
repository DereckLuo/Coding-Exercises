package com.company;

public class Single_Number_III__260 {
    /**
     * 260. Single Number III
     *      Given an array of numbers nums, in which exactly two elements appear
     *      only once and all the other elements appear exactly twice. Find the two
     *      elements that appear only once
     *      For example:
     *          Given nums = [1,2,1,3,2,5], return [3,5]
     *      Should run in O(n) time, and O(1) space
     */
    public int[] singleNumber(int[] nums){
        //Non HashMap Solution
        /**
         * XOR through the array two times. First path clear off all duplicate numbers
         * and obtain the XOR of the two single numeber
         * The second loop split up the two numbers
         */
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
