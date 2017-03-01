/**
 *	81. Search in Rotated Sorted Array II
 *		Follow up for "Search in Rotated Sorted Array"
 *	What if duplicates are allowed?
 *	Would this affect the run-time complexity? How and why?
 *	Write a function to determine if a given target is in the array
 *
 *	Search in Rotated Sorted Array Question:
 *		Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *	(i.e, 0 1 4 5 6 7 might become 4 5 6 7 0 1 2)
 *	You are given a target value to search. If found in the array return its index, otherwise return -1
 *	You may assume no duplicate exists in the array.
 **/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
	bool search(vector<int>& nums, int target) {

	}

	/*The Brute force solution
	 *	12 ms solution, can do better!
	*/
	bool brutesearch(vector<int>& nums, int target) {
		for (int i = 0; i < nums.size(); i++) {
			if (nums[i] == target)
				return true;
		}
		return false;
	}

	/**
	 *	Binary search modification solution
	 **/
	bool modifyBS(vector<int>& nums, int target) {
		if (nums.size() == 0)
			return false;

		int mid = nums.size() / 2; //the mid point 
		int size = nums.size();
		int end = nums.size() - 1;

		while (size != 1) {
			if (nums[mid] > nums[end]) {
				//case break point to the right

			}
		}
	}
};

int main() {

	Solution sol;



	return 0;
}