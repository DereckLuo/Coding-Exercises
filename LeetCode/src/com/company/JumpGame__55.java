package com.company;


import java.util.Stack;

/**
 * Given an array of non-negative integers, you are initially positioned at the first
 * index of the array.
 * Each element in the array represents your maximum jump length at that position
 * Determine if you are able to reach the last index
 */
public class JumpGame__55 {
    public boolean canJump(int[] nums){
        Stack<Integer> s = new Stack<>();
        s.push(0);
        while(!s.isEmpty()){
            int pos = s.pop();
            for(int i = pos; i < pos+nums[pos]; i++){
                if(i == nums.length-1) return true;
                if(i < nums.length-1) s.push(i);
            }
        }
        return false;
    }

    public boolean canJumpSimple(int[] nums){
        int rechablesofar = 0;
        for(int i = 0; i < nums.length; i++){
            if(rechablesofar < i) return false;
            rechablesofar = Math.max(rechablesofar, i + nums[i]);
            if (rechablesofar >= nums.length - 1) return true;
        }
        return false;
    }
}
