package com.company;

import java.util.*;

/**
 * 219. Contains Duplicate II
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k
 * Created by Dereck on 0021, January 21, 2017.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k){
        if(nums == null || k <=0) return false;

        Map<Integer, List<Integer>> table = new HashMap<Integer, List<Integer>>();

        for(int i = 0; i < nums.length; i++){
            List<Integer> entry = table.get(nums[i]);
            if(entry == null){
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                table.put(nums[i], temp);
            }
            else{
                for(int j = 0; j < entry.size(); j++){
                    if(Math.abs(i-entry.get(j)) <= k) return true;
                }
                entry.add(i);
            }
        }
        return  false;
    }

    /**
     * Simple Java solution
     */
    public boolean containsNearbyDuplicateSimple(int[] nums, int k){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
