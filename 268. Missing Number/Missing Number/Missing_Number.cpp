/**
	* Missing Number: 
	*		Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one
	*	that is missing from the array.
	*		For example,
	*	Given nums = [0, 1, 3] return 2

	* Note:
	*	Your algorithm should run in linear runtime complexity. Could you implement it using only 
	*	constant extra space complexity?
**/


#include <stdio.h>
#include <iostream>
#include <vector>

class Solution {
public:
	int missingNumber(std::vector<int>& nums) {
		int length = nums.size();  //the size of the vector
		
		std::vector<int> vec; //the comparason vector
		for (int i = 0; i < length + 1; i++) {
			vec.push_back(-1); //filling the comparason vector with -1
		}

		for (int i = 0; i < length; i++) {//looping through first vector
			vec[nums[i]] = nums[i]; 
		}

		for (int i = 0; i < length + 1; i++){//final loop to check for missing number 
			if (vec[i] == -1) {
				std::cout << "The missing number is : ";
				std::cout << i <<"\n" ;
				return i;
			}
		}
	}

	/**
	 * A better solution from LeetCode 
	**/
	int missingNumberBetter(std::vector<int>& nums) {
		int total = 0;
		for (int i = 1; i <= nums.size(); i++) {
			total = total + i - nums[i - 1];
		}
		std::cout << total << "\n";
		return total;
	}
};


int main() {
	
	int ret; //the return value 
	std::vector<int> number { 2,0,1 }; //the vector of numbers

	Solution sol;
	sol.missingNumber(number);
	//sol.missingNumberBetter(number);

	return 0;
}