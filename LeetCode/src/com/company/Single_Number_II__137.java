package com.company;

import java.util.HashMap;

/**
 * 137. Single Number II:
 *      Given an array of integers, every element appears three times except
 *      for one. which appears exactly once.
 *      Find that single one.
 *
 *      Require O(n) time complexity, and possible O(1) memory
 */

public class Single_Number_II__137 {
    /**
     * Using Map to store element numbers
     */
    public int singleNumber(int[] nums){
        HashMap<Integer, Integer> table = new HashMap<>();
        for(int num : nums){
            if(table.containsKey(num)){
                table.put(num, table.get(num) + 1);
            }
            else{
                table.put(num,1);
            }
        }
        for(int key : table.keySet()){
            if(table.get(key) == 1){
                return key;
            }
        }
        return -1;
    }
}
