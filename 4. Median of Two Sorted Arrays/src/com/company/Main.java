package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution sol = new Solution();
        //1,2,3,4,[5],6,7,8,9,10
        int[] nums1 = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{6,7,8,9};
        double output2 = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println(output2);

//        nums1 = new int[]{1,2};
//        nums2 = new int[]{3,4};
//        double output1 = sol.findMedianSortedArrays(nums1, nums2);
//        System.out.println(output1);
    }
}
