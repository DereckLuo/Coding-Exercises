/**
 *	78. Subsets
 *		Given a set of distinct integers, nums, return all possible subsets.
 *	Note: The solution set must not contain duplicate subsets. 
 *	For example:
 *	if nums = [1,2,3], a solution is:
 *	[
	 [3],
	 [1],
	 [2],
	 [1,2,3],
	 [1,3],
	 [2,3],
	 [1,2],
	 []
	 ]
 **/

#include<iostream>
#include <vector>

using namespace std;


class Solution {
public:
	vector<vector<int>> subsets(vector<int>& nums) {
		vector<vector<int>> ret;  //return value 
		vector<int> set;  //the empty set;
		ret.push_back(set);
		if (nums.size() == 0)
			return ret;
		if (nums.size() == 1) {
			ret.push_back(nums);
			return ret;
		}
		ret = subhelp(nums, nums.size(), 0);
		ret.push_back(set);

		return ret;
	}

	/** recursive helper function finding the subset **/
	/**
	 *	src: the sorce of initial set
	 *	size: the size of the subset contains
	 *  begin: the begin location of the subset contains
	 *	Note: division is round down, i.e. 3/2 = 1
	 **/
	vector<vector<int>> subhelp(vector<int>& src, int size, int begin) {
		vector<vector<int>> ret, left, right; //return, left sub, and right sub;
		vector<int> temp;
		//base case
		if (size == 1) {
			temp.push_back(src[begin]);
			ret.push_back(temp);
			return ret;
		}
		left = subhelp(src, size / 2, begin); //the left side of set
		right = subhelp(src, size - (size / 2), begin + (size / 2)); //the right side of set
		ret = mergeset(left, right);
		return ret;
	}

	/**
	 *	The merge helper function to calculate the cross product of two sets
	 **/
	vector<vector<int>> mergeset(vector<vector<int>> & left, vector<vector<int>>& right) {
		vector<vector<int>> ret;

		for (int i = 0; i < left.size(); i++)
			ret.push_back(left[i]);
		for (int i = 0; i < right.size(); i++) {
			ret.push_back(right[i]);
			//looping through left 
			for (int j = 0; j < left.size(); j++) {
				vector<int> temp;
				for (int k = 0; k < left[j].size(); k++)
					temp.push_back(left[j][k]);
				for (int k = 0; k < right[i].size(); k++)
					temp.push_back(right[i][k]);
				ret.push_back(temp);
			}
		}

		return ret;
	}

	void printsubset(vector<vector<int>> & input) {
		cout << "[ \n";
		for (int i = 0; i < input.size(); i++) {
			cout << "[ ";
			for (int j = 0; j < input[i].size(); j++) {
				cout << input[i][j] << ",";
			}
			cout << "]\n";
		}
		cout << "]\n";
	}
};


int main() {

	cout << " Program begins ! \n";

	Solution sol;

	vector<int> input;
	for (int i = 1; i <4; i++)
		input.push_back(i);
	/*
	vector<vector<int>> left, right, merge;
	vector<int> temp;
	temp.push_back(3); right.push_back(temp); temp.clear(); 
	temp.push_back(4); right.push_back(temp); temp.clear(); 
	temp.push_back(3); temp.push_back(4); right.push_back(temp); temp.clear();

	temp.push_back(1); left.push_back(temp); temp.clear();
	temp.push_back(2); left.push_back(temp); temp.clear();
	temp.push_back(1); temp.push_back(2); left.push_back(temp); temp.clear();

	sol.printsubset(left);
	sol.printsubset(right);

	merge = sol.mergeset(left, right);

	sol.printsubset(merge);*/

	vector<vector<int>> ret = sol.subsets(input);

	sol.printsubset(ret);

	return 0;
}


