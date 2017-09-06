package com.company;

/**
 * 449. Serialize and Deserialize BST
 *      Serialization is the process of converting a data structure or object into
 *      a sequence of bits so that it can be stored in a file or memory buffer, or
 *      transmitted across a network connection link to be reconstructed later in
 *      the same or another computer environment.
 *
 *      Design an algorithm to seralize and deserialize a binary search tree. There
 *      is no restriction on how your seralization/deseralization algorithm should work.
 *      you just need to ensure that a binary search tree can be seralize
 *      to a string and this string can be deserialized to the original tree
 */
public class Serialize_and_Deserialize_BST__449 {
    private class TreeNode extends Serialize_and_Deserialize_BST__449{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //BFS going down the tree and store into a String
        if(root == null) return "";
        String ret = "";
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                ret += "_,";
            }
            else{
                ret = ret + Integer.toString(node.val) +",";
                q.offer(node.left); q.offer(node.right);
            }
        }
        return ret;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //The input String is in BFS format.
        if(data.length() == 0) return null;

        // System.out.println(Character.getNumericValue(data.charAt(0)));
        String[] s = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(s[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = 1;

        while(!q.isEmpty()){
            if(index >= s.length) return root;
            TreeNode node = q.poll();
            String c = s[index];
            //add left
            if(!c.equals("_")){
                TreeNode leftNode = new TreeNode(Integer.valueOf(c));
                node.left = leftNode; q.offer(leftNode);
            }
            else{
                node.left = null;
            }
            index += 1;
            //add right
            if(!c.equals("_")){
                TreeNode rightNode = new TreeNode(Integer.valueOf(c));
                node.right = rightNode; q.offer(rightNode);
            }
            else{node.right = null;}
            index += 1;

        }
        return root;
    }

}
