package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Definition for a binary tree node.
 *
 * public class TreeNode{
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {val = x;}
 * }
 */

public class Solution {
    /**
     * Try to use binary search to find the last level drop off
     * Find the height of tree
     *  check height of right subtree
     *  if height = tree height - 1, the leaf cutoff on right, left full tree
     *  if height = tree height - 2, the leaf cutoff on left, recursive left
     *
     */
    public int countNodes(TreeNode root){
        int h = height(root);

        if (h < 0)
            return 0;
        else{
            return height(root.right) == h-1 ? (1<< h) + countNodes(root.right) : (1 << h - 1) + countNodes(root.left);
        }

    }

    private int height(TreeNode root){
        return root == null? -1: 1+height(root.left);
    }

    public int countNodesFaster(TreeNode root){
        if(root == null) return 0;
        int num = 1;
        TreeNode curR = root.right; TreeNode curL = root.left;
        while(curR != null){
            curL = curL.left; curR = curR.right;
            num = num << 1;
        }
        return num + ( (curL == null) ? countNodes(root.right): countNodes(root.left));
    }
}
