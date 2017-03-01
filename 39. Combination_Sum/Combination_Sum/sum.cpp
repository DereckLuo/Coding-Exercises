/**
 *	39. Combination Sum:
 *		Given a set of candidate numbers (c) and a target number (T), find all unique combinations of C where
 *	the candidate numbers sums to T.
 *	The same repeated number may be chosen from c unlimited number of times.
 *	Note:
 *		All numbers (including target) will be positive integers.
 *		The solution set must not contain duplicate combinations.
 *	For example, given candidate set [2,3,6,7] and target 7
 *	A solution set is
 *	[ [7],  [2,2,3]] ]
**/


#include<iostream>
#include<stdio.h>
#include<map>
#include<vector> 
#include<algorithm>

using namespace std;


class Solution {
public:
	vector<vector<int>> combinationSum(vector<int>& candidates, int target) {

		vector<vector<int>> ret;
		int pos; 

		vector<int> input = candidates;
		sort(input.begin(), input.end()); //sorting the input vector. in < order

		summation(candidates, target, candidates.size()-1, ret);

		return ret;
	}

	/* recursive helper function to solve the problem */
	bool summation(vector<int> & src, int sum, int pos, vector<vector<int>> & ret) {

		bool check = false; 
		if (pos < 0)
			return false; 
		if (sum == 0)
			return true;
		if (sum < 0)
			return false;

		for (int i = pos; i >=0; i--) {
			//lop through all smaller numbers 
			vector<vector<int>> child;
			int sub = sum - src[i];
			int next_pos;
			
			if (sub == 0) {
				merge(ret, src[i], child);
				check = true;
			}
			else {
				if (sub >= src[i])
					next_pos = i;
				else
					next_pos = i - 1;
				if (summation(src, sub, next_pos, child)) { //case find true combination 
					merge(ret, src[i], child);
					check = true;
				}
			}
		}
		return check;
	}


	void merge(vector<vector<int>> & ret, int head, vector<vector<int>> child) {
		if (child.size() == 0) {
			vector<int> temp;
			temp.push_back(head);
			ret.push_back(temp);
		}

		for (int i = 0; i < child.size(); i++) {
			vector<int> temp;
			temp.push_back(head);
			for (int j = 0; j < child[i].size(); j++) {
				temp.push_back(child[i][j]);
			}
			ret.push_back(temp);
		}
	}


	void printsolution(vector<vector<int>> & input) {
		if (input.size() == 0)
			return;
		cout << "[ ";
		for (int i = 0; i < input.size(); i++) {
			cout << "[ "; 
			for (int j = 0; j < input[i].size(); j++) {
				cout << input[i][j] << ", ";
			}
			cout << " ]";
		}
		cout << " ]";
	}
};

int main() {

	cout << " Program starts !  \n";

	cout << " Input number set : 2,3,6,7";
	vector<int> input{1,2,5,7,10,12};

	vector<vector<int>> output;

	Solution sol;
	
	
	cout << " calling output function \n";
	output = sol.combinationSum(input, 7);

	sol.printsolution(output); 

	return 0;
}