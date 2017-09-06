package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Print a binary tree in an m*n 2D string array followign these rules:
 *  1. The row number m should be equal to the height of the given binary tree
 *  2. The column number n should always be an odd number
 *  3. The root nodes value should be put in the exactly middle of first row
 *      the column and row where root node belongs will separate the rest space
 *      into two parts
 *  4. Each unused space should contain an empty string ""
 *  5. Print the subtrees following the same rules.
 */
public class Print_Binary_Tree__655 {
    class TreeNode extends Print_Binary_Tree__655{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public List<List<String>> printTree(TreeNode root){
        List<List<String>> ret = new ArrayList<>();

        //
    }
}
