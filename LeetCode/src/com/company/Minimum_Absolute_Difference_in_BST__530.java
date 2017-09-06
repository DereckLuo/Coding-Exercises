package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute
 * difference between values of any two nodes
 *
 * Example:
 *      Input:      1
 *                   \
 *                    3
 *                   /
 *                  2
 *      Output: 1
 */
public class Minimum_Absolute_Difference_in_BST__530 {
    private class TreeNode extends  Minimum_Absolute_Difference_in_BST__530{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    public int getMinimumDifference(TreeNode root){
        /**
         * Interesting: In order traverse will explore the BST in order
         */
        List<Integer> line = new ArrayList<>();
        recurHelp(line, root);

        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < line.size()-1; i++){
            int curdiff = Math.abs(line.get(i+1) - line.get(i));
            if(curdiff < minDiff) minDiff = curdiff;
        }
        return minDiff;
    }

    private void recurHelp(List<Integer> line, TreeNode node){
        if(node == null) return;
        recurHelp(line, node.left);
        line.add(node.val);
        recurHelp(line, node.right);
        return;
    }
}
