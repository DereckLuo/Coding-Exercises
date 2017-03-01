/** 
 *	107. Binary Tree Level Order Traversal II
 *		Given a binary tree, return the bottom-up level order traversal of its nodes' value, 
 *	(ie, from left to right, level by level from leaf to root)
 *	For example:
 *	Given binary tree [3, 9, 20, null, null, 15, 17]
 *			3
 *		   / \
 *		  9	 20
 *			 / \
 *			15  7
 *	return its bottom-up level order traversal as:
 *	[
 *		[15,7],
 *		[9,20],
 *		[3]
 *	]
 **/

#include<iostream>
#include<vector>
#include<queue>
#include<stack>


using namespace std;

 /**
 * Definition for a binary tree node.*/
  struct TreeNode {
      int val = 0;
      TreeNode *left = NULL;
      TreeNode *right = NULL;
     // TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
public:
	vector<vector<int>> levelOrderBottom(TreeNode* root) {
		vector<vector<int>> ret; //the return structure
		vector<vector<int>> output;
		queue<TreeNode*> table; //using for level traversal

		if (root == NULL) return ret; 

		int curr_level, next_level;//store number of nodes in each level

		table.push(root); curr_level = 1; next_level = 0; //store the root first 
		vector<int> level; //store each level value 

		while (!table.empty()) {//while table is not empty
			TreeNode* temp = table.front();
			table.pop(); curr_level--;
			level.push_back(temp->val);

			if (temp->left != NULL) {
				table.push(temp->left);
				next_level++;
			}
			if (temp->right != NULL) {
				table.push(temp->right);
				next_level++;
			}
			if (curr_level == 0) {//case finished a level
				ret.push_back(level);
				level.clear();
				curr_level = next_level; next_level = 0;
			}
		}

		for (int i = ret.size() - 1; i >= 0; i--) {
			output.push_back(ret[i]);
		}
		return output;
	}


	/**
	 *	Function to build a tree for operation 
	 **/
	TreeNode* treebuild() {
		TreeNode* root = new TreeNode; //the root of the tree
		root->val = 3; 

		TreeNode* left_1 = new TreeNode;
		left_1->val = 9; 
		TreeNode* right_1 = new TreeNode;
		right_1->val = 20;
		root->left = left_1; root->right = right_1;

		TreeNode* left_2 = new TreeNode;
		left_2->val = 15;
		TreeNode* right_2 = new TreeNode;
		right_2->val = 7;
		right_1->left = left_2; right_1->right = right_2;

		return root;
	}

	/**
	 *	Function to delete the tree from heap
	 **/
	void treeDelete(TreeNode* node) {
		if (node == NULL) return;
		if (node->left == NULL && node->right == NULL) {
			delete node;
			return;
		}
		treeDelete(node->left);
		treeDelete(node->right);
		delete node;
	}

	/**
	 *	Function to print out the tree
	 **/
	void treePrint(vector<vector<int>>& input) {
		cout << "[";
		for (int i = 0; i < input.size(); i++) {
			cout << "[";
			for (int j = 0; j < input[i].size(); j++) {
				cout << input[i][j] << ",";
			}
			cout << "],";
		}
		cout << "]\n";
	}
};



int main() {
	cout << "Function Starts ! \n";

	Solution sol;

	TreeNode* root = sol.treebuild();
	vector<vector<int>> output = sol.levelOrderBottom(root);
	sol.treePrint(output);
	sol.treeDelete(root);

	return 0;
}