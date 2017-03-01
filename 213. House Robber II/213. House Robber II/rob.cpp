/**
 *	213. House Robber II
 *		After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
 *	This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security 
 *	system for these houses remain the same as for those in the previous street. 
 *	Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob
 *	tonight without alerting the plice
 *	Security policy: Can not rob houses next to each other 
 **/


#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	/** 
	 *	Recursive is pretty straight forward, jsut need to add a signal to indicate first building taken or build a actual loop array
	 *	Or using DP solution with simplly 2 array to track
	 **/
	int rob(vector<int>& nums) {
		//base case
		if (nums.size() == 0) return 0;

		// DP store table 
		vector<int> table1(nums.size(), -1); //taking first house    type 0 
		vector<int> table2(nums.size(), -1); //not taking first house  type 1

		return max(nums[0] + robDPhelper(nums, 2, 0, table1, table2), robDPhelper(nums, 1, 1, table1, table2));
	}

	/** 
	 * rubDPhelper
	 *	 function to help with DP calculation 
	 *	return maxprofit in current sicuation 
	 **/
	int robDPhelper(vector<int>& nums, int pos, int type, vector<int> &table1, vector<int> &table2) {
		if (type) {//case not taking first house  -- Therefore it is ok to take the last house 
			if (pos >= nums.size()) return 0; //out of range 
			if (table2[pos] != -1) return table2[pos]; //DP answer
			int max_val = max(nums[pos] + robDPhelper(nums, pos + 2, type, table1, table2), robDPhelper(nums, pos + 1, type, table1, table2));
			table2[pos] = max_val; return max_val;
		}
		else {//case taking the fist house -- Therefore cannot take the last house 
			if (pos >= nums.size() - 1) return 0;//out of range
			if (table1[pos] != -1) return table1[pos]; //DP answer
			int max_val = max(nums[pos] + robDPhelper(nums, pos + 2, type, table1, table2), robDPhelper(nums, pos + 1, type, table1, table2));
			table1[pos] = max_val; return max_val;
		}
	}
};


int main() {
	cout << " Function Starts ! \n";
	Solution sol;

	vector<int> input = { 23,5,6,23,5,243,6,34,36,8,37,62,236,468,84,26,246,48,27,26,52,47 };

	auto outcome = sol.rob(input);

	cout << " The best outcome is : " << outcome << "\n";
}