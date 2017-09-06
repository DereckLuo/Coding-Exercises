package com.company;

import java.util.List;

/**
 * 515. Find Largest Value in Each Tree Row
 *
 *      You need to find the largest value in each row of a binary tree
 *
 *      Input:
 *              1
 *             3 2
 *            5 3 9
 *      Output: [1,3,9]
 */
public class Find_Largest_Value_in_Each_Tree_Row__515 {
    private class TreeNode extends  Find_Largest_Value_in_Each_Tree_Row__515{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public List<Integer> largestValues(TreeNode root){
        int maxVal = Integer.MIN_VALUE;
    }
}
