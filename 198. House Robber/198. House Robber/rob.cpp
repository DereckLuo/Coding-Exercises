/**
 *	198. House Robber
 *		You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint
 *	stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if
 *	two adjacent houses were brokem into on the same night
 *		Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob
 *	tonight without alerting the police.
 **/


#include<iostream>
#include<vector>
#include<algorithm>


using namespace std;

class Solution {
public:
	/**
	 * recursive or DP solution 
	 **/
	int rob(vector<int>& nums) {
		//base corner case
		if (nums.size() == 0) return 0;

		vector<int> table(nums.size(), -1); //the table to store profit of robbing from this point
		int ret = max(nums[0] + robDPhelp(nums, 2, table), robDPhelp(nums, 1, table)); //either rob first one or not
		return ret; 
	}

	/**
	 * RobDPhelper 
	 *		helper function to help and solve the solution
	 *	return the profit from current position 
	 **/
	int robDPhelp(vector<int> & nums, int pos, vector<int> & table) {
		//base cases
		if (pos >= nums.size()) return 0; //out of bounds 
		//DP case
		if (table[pos] != -1) return table[pos]; //already calculated before
		//recursive case
		int max_val = max(nums[pos] + robDPhelp(nums, pos + 2, table), robDPhelp(nums, pos + 1, table)); //max between buy or nobuy
		table[pos] = max_val;
		return max_val;
	}
};

int main() {
	cout << "Function Starts !\n";
	Solution sol;
	//vector<int> input = { 2,5,7,2,34,8,2,5,3,2,4,76,8,23,3,5,7,8,12,3,8 };
	vector<int> input = { 4,1,2,7,5,3,1 };

	auto outcome = sol.rob(input);
	cout << " The maximum profit is : " << outcome << "\n";
	return 0;
}