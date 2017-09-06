package com.company;

/**
 * 104. Maximum Depth of Binary Tree
 *      Given a binary tree, find its maximum depth.
 *      The maximum depth is the number of nodes along the longest path from
 *      the root down to the fartest leaf node
 */
public class Maximum_Depth_of_Binary_Tree__104 {
    /**
     * Perform search on the tree to obtain depth.
     * Have to complete search
     */
    private class TreeNode extends  Maximum_Depth_of_Binary_Tree__104{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public int maxDepth(TreeNode root){
        return recurHelp(root);
    }

    private int recurHelp(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(recurHelp(node.left), recurHelp(node.right));
    }
}
