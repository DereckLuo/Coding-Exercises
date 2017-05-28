package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be
 * O(log(m+n))
 * Example 1:
 * nums1 = [1,3] nums2 = [2]
 * Median is 2.0
 *
 * Example 2:
 * nums1 = [1,2] nums2 = [3,4]
 * Median is (2+3)/2 = 2.5
 * Created by Dereck on 0002, March 2, 2017.
 */
public class Solution {

    /**
     * Bineary search, O(n+m) method
     */
    public double findMedianSortedArrays(int[] nums1, int[]nums2){
        double arr1leng = nums1.length, arr2leng = nums2.length;
        int i = (int)Math.ceil(arr1leng/2.0)-1, j = (int)Math.ceil(arr2leng/2.0)-1;
        while(true){
            System.out.println(Integer.toString(i) + " " + Integer.toString(j));
            System.out.println("");
            if(i != arr1leng-1 && nums1[i+1] < nums2[j]){
                i += (arr1leng-i)/2; j -= (arr1leng-i)/2;
            }
            else if(j != arr2leng-1 && nums2[j+1] < nums1[i]){
                j += (arr2leng-j)/2; i-= (arr2leng-j)/2;
            }
            else break;
        }
        System.out.println(Integer.toString(i) + " " + Integer.toString(j));
        return 0.0;
    }


    /**
     * Linear search, O(n) method
     */
    public double findMedianSortedArraysOn(int[] nums1, int[] nums2) {
        int prev1 = 0, prev2 = 0;
        int mid = (nums1.length + nums2.length)/2;
        int i = 0, j = 0;
        int idx = 0;
        while(idx <= mid){
            prev2 = prev1;
            if(i >= nums1.length){
                idx ++; prev1 = nums2[j]; j ++;
            }
            else if (j >= nums2.length){
                idx ++; prev1 = nums1[i]; i++;
            }
            else{
                if(nums1[i] <= nums2[j]){
                    prev1 = nums1[i]; i++;
                }
                else{
                    prev1 =  nums2[j]; j++;
                }
                idx ++;
            }
        }
        if((nums1.length+nums2.length)%2 != 0) return (double)prev1;
        else{
            return ((double)(prev1 + prev2)/2);
        }
    }
}
