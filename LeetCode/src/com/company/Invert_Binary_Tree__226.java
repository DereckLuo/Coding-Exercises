package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary Tree
 *
 *          4                   4
 *         / \                 / \
 *        2   7               7   2
 *       / \ / \             / \ / \
 *      1  3 6  9           9  6 3  1
 */
public class Invert_Binary_Tree__226 {
    private class TreeNode extends Invert_Binary_Tree__226{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode top = q.poll();
            TreeNode temp = top.left;
            top.left = top.right; top.right = temp;
            if(top.left != null) q.offer(top.left);
            if(top.right != null) q.offer(top.right);
        }
        return root;
    }
}
