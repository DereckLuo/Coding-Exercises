/** 
 *	1. Two Sum
 *		Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *	You may assume that each input would have exactly one solution.
 *	Example:
 *		Given nums = [2, 7, 11, 15], target = 9,
 *	Because nums[0] + nums[1] = 2 + 7 = 9
 *	return [0, 1]
 *		The return format had been changed to zero-based indices. 
 **/

#include<iostream>
#include<vector>
#include<map>
#include<unordered_map>

using namespace std;

class Solution {
public:
	/** 
	 *	slow 760 ms solution
	 *	running time O(n^2)
	 **/
	vector<int> twoSum(vector<int>& nums, int target) {
		vector<int> ret; //the return value 
		for (int i = 0; i < nums.size() - 1; i++) { //first number 
			for (int j = i+1; j < nums.size(); j++) {	//second number
				if (nums[i] + nums[j] == target) {
					ret.push_back(i); ret.push_back(j);
					return ret;
				}
			}
		}
		return ret;
	}

	/** 
	 *	using map to solve
	 *	20 ms
	 *	Running time O(n), Running space O(n)
	 **/	
	vector<int> twoSumFast(vector<int> &nums, int target) {

		unordered_map<int, int> table; //the store map
		for (int i = 0; i < nums.size(); i++) {
			int k = table[target - nums[i]]; //the value we are looking for 
			if (k != 0)
				return{ k - 1, i };
			table[nums[i]] = i + 1;
		}
		return vector<int>();
	}

	/** 
	 *	function to create array
	 **/
	vector<int> createarray() {
		vector<int> ret;
		ret.push_back(3); ret.push_back(2); ret.push_back(4);

		return ret;

	}
};

int main() {

	cout << "Function Starts ! \n";
	Solution sol;

	auto input = sol.createarray();

	auto output = sol.twoSumFast(input, 6);

	cout << " Output is : [ " << output[0] << "," << output[1] << "]\n";

	return 0;
}