package com.company;

/**
 * 35. Search Insert Position
 *      Given a sorted array and a target value, return the index if the target is
 *      found, if not, return the index where it would be if it were inserted in
 *      order.
 *      May assume no duplicates in the array
 *
 *      Example:
 *          [1,3,5,6], 5 --> 2
 *          [1,3,5,6], 2 --> 1
 *
 *      Use binary search
 */
public class Search_Insert_Position__35 {
    public int searchInsert(int[] nums, int target){
        int leftbound = 0, rightbound = nums.length-1;
        while(leftbound < rightbound){
            int middle = (leftbound + rightbound)/2;
            if(target == nums[middle]) return middle;
            else if(target < nums[middle]){
                rightbound = middle;
            }
            else{
                leftbound = middle+1;
            }
        }
        if(nums[leftbound] < target) return leftbound+1;
        else return leftbound;
    }
}
