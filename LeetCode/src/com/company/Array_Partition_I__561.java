package com.company;

import java.util.Arrays;

/**
 * 561: Array Partition I:
 *      Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 *      say (a1, b1), (a2, b2), ..., (an,bn) which makes sum of min(ai,bi)
 *      for all i from 1 to n as large as possible
 *
 *      Example:
 *          Input[1,4,3,2]
 *          output: 4
 */
public class Array_Partition_I__561 {
    public int arrayPairSum(int[] nums){
        Arrays.sort(nums);
        int ret = 0;
        for(int i = 0; i < nums.length; i+=2){
            ret += nums[i];
        }
        return ret;
    }
}
