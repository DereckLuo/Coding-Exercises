package com.company;

/**
 * Definition for a binary tree node.
 *  public class TreeNode{
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode(int x) {val = x; }
 *  }
 */

public class Solution {
    /**
     * Binary Tree Traversal match
     */
    public boolean isSameTree(TreeNode p, TreeNode q){
        return doubleTraversal(p, q);
    }

    private boolean doubleTraversal(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if((p == null && q != null) || (p != null && q == null)) return false;
        if(p.val != q.val) return false;

        if(doubleTraversal(p.left, q.left) && doubleTraversal(p.right, q.right))return true;
        else return false;
    }
}
