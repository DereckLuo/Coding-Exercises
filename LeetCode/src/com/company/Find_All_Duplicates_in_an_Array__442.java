package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 442. Find all duplicates in an array
 *      Given an array of integers, 1 <= a[i] <= n (n = size of array), some elements
 *      appear twice and others appear once
 *      Find all the elements that appear twice in this array
 *
 *      Could you do this in O(n) time
 *
 *      Example:
 *          Input: [4,3,2,7,8,2,3,1]
 *          Output: [2,3]
 */
public class Find_All_Duplicates_in_an_Array__442 {
    public List<Integer> findDuplicates(int[] nums){
        List<Integer> ret = new ArrayList<>();
        HashMap<Integer, Integer> table = new HashMap<>();

        for(int num : nums){
            if(!table.containsKey(num)){
                table.put(num, 1);
            }
            else if(table.containsKey(num) && table.get(num) == 1){
                ret.add(num);
            }
        }
        return ret;
    }

    //when find a number i, flip the number at position i-1 to negative
    //if the number at position i-1 is already negative, i is the number that occurs twice
    public List<Integer> findDuplicatesFast(int[] nums){
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0)
                ret.add(Math.abs(index+1));
        }
        return ret;
    }
}
