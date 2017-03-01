/**
 *	94.Binary Tree Inorder traversal:
 *		Given a binary tree, return the inorder traversal of its nodes' values.
 *	For example:
 *	Given binary tree [1,null,2,3]
 *	1
 *	 \
 *	  2
 *	 /
 *	3
 *	return [1,3,2]
 *	Note: Recursive solution is trival, could you do it iteratively?
*/

#include<iostream>>
#include<stdio.h>
#include<vector>
#include<stack>

using namespace std;

/**
* Definition for a binary tree node.*/
 struct TreeNode {
     int val = 0;
     TreeNode *left = NULL;
     TreeNode *right = NULL;
     //TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
	vector<int> inorderTraversal(TreeNode* root) {

		vector<int> ret;
		if (root == NULL)
			return ret;

		stack<TreeNode*> tree;

		tree.push(root); //pushing root into stack
		while (!tree.empty()) {
			ret.push_back(tree.top()->val);
			TreeNode*temp = tree.top();
			tree.pop();
			if (temp->left != NULL)
				tree.push(temp->left);
			if (temp->right != NULL)
				tree.push(temp->right);
		}

		return ret;
	}

	void CreateTree(TreeNode* & root, vector<int> & arr, int& pos) {
		//case no nodes need to add
		if (pos >= arr.size())
			return;
		if (arr[pos] == 0)
			root->left = NULL;
		else if (arr[pos + 1] == 0)
			root->right = NULL;
		else if (arr[pos + 1] == 0)
			root->right = NULL;
		else {
			TreeNode *left_node = new TreeNode;
			left_node->val = arr[pos];
			TreeNode *right_node = new TreeNode;
			right_node->val = arr[pos + 1];
			root->left = left_node; root->right = right_node;
			//modify pos
			pos += 2;

			CreateTree(root->left, arr, pos); //call left tree
			CreateTree(root->right, arr, pos); //call right tree
		}
		return;
	}

	/**Recursive Solution for Inorder traversal **/
	void PrintTree(TreeNode* & root) {
		if (root == NULL)
			return;
		else {
			PrintTree(root->left);
			cout << root->val << " ";
			PrintTree(root->right);

		}
	}
};

int main() {

	Solution sol; //the solution class

				  //input array to build tree first
	vector<int> arr{ 1,2,3,4,5 }; //input binary tree array, assume 0 as empty spot
	struct TreeNode* root = new TreeNode;
	int tree_pos = 1; //the pointer to locate tree
	root->val = arr[0];
	sol.CreateTree(root, arr, tree_pos); //creating the binary tree

	cout << "Function starts \n";
	cout << "Tree array is :\n";
	for (int i = 0; i < arr.size(); i++)
		cout << " " << arr[i];
	cout << " \n";
	//sol.PrintTree(root);

	vector<int> ret;

	ret = sol.inorderTraversal(root);

	for (int i = 0; i < ret.size(); i++)
		cout << ret[i] << " ";
	return 0;
}
