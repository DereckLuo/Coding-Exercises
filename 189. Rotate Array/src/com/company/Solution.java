package com.company;

import java.util.ArrayList;

public class Solution {
    public void rotate(int[] nums, int k){
        if(k < 0) return;

        k = k % nums.length;
        ArrayList<Integer> flip = new ArrayList<>();

        int split_loc = nums.length-k;
        int left = split_loc-1, right = nums.length-1;
        while(left >= 0){
            int temp = nums[right]; nums[right] = nums[left];
            if(right >= split_loc) flip.add(temp);
            left -= 1; right -= 1;
        }
        while(right >= split_loc){
            flip.add(nums[right]);
            right -=1;
        }
        right = k-1;
        for(int num : flip){
            nums[right] = num;
            right -=1;
        }

    }

    public void printArray(int[] nums){
        for(int num : nums) System.out.print(num);

        System.out.println("");
    }
}
