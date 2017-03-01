/**
 * 33. Search in Rotated Sorted Array
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
	int search(vector<int>& nums, int target) {

	}

	/**
	 *	Brute force solution: Running time O(n)
	 **/
	int brutesearch(vector<int>& nums, int target) {
		int ret = -1;
		for (int i = 0; i < nums.size(); i++) {
			if (nums[i] == target)
				ret = i;
		}
		return ret;
	}

	/**
	*	A little bit better Brute force solution: Worest running time O(n)
	*	searching one segment of the array
	**/
	int brutesearch2(vector<int>& nums, int target) {
		int ret = -1; 
		int begin = 0; int end = nums.size() - 1;
		if (nums.size() == 0) return -1;

		if (target >= nums[begin]) {
			//case in the first segment of array
			while (nums[begin] < nums[begin + 1]) {
				if (nums[begin] == target)
					return begin;
				begin++;
			}
			if (nums[begin] == target)
				return begin;
			return -1;
		}
		else {
			//in the second segment of array
			while (nums[end] > nums[end - 1]) {
				cout << "cp : " << nums[end] << "\n";
				if (nums[end] == target)
					return end;
				end--;
			}
			cout << " cp1 : " << nums[end] << "\n";
			if (nums[end] == target)
				return end;
			return -1;
		}
	}

	/**
	 *	Binary search modified solution, hope it works 
	 *	size: the size of sub array
	 *	begin: the begin location of subarray
	 **/
	int modifyBS(vector<int>& nums, int target, int size, int begin ) {
		//the base case

		cout << "size is : " << size << " begin at : " << begin << "\n";
		if (size == 1) {
			if (nums[begin] == target) return begin;
			else return -1;
		}
		
		int ret;
		int mid = size / 2;
		if (target <= nums[begin + mid - 1])
			ret = modifyBS(nums, target, size / 2, begin);
		else
			ret = modifyBS(nums, target, size - (size/2), begin + (size/2));

		return ret;
	}

	/**
	 *	Better binary search modification
	 **/
	int modifyBS2(vector<int>& nums, int target) {
		int l = 0, r = nums.size() - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (nums[mid] == target) return mid;
			if (nums[mid] > nums[r]) {
				if (target > nums[mid] || target <= nums[r]) l = mid + 1;   // condition for pick right side
				else r = mid - 1;    // else, pick left side
			}
			else {
				if (target <= nums[r] && target > nums[mid]) l = mid + 1;  // condition for pick right side
				else r = mid - 1;     // else, pick left side
			}
		}

		return -1;
	}
};


int main() {
	
	cout << "Function starts !\n";

	Solution sol;

	vector<int> input = {5,6,7,8,9,10,11,12,13,14,15,1,2,3,4 };
	cout << "input array is : ";
	for (int i = 0; i < input.size(); i++) {
		cout << input[i] << " ";
	}
	cout << "\n";

	int ret;
	//ret = sol.modifyBS(input, -3, input.size(), 0);
	ret = sol.brutesearch2(input, 1);

	cout << "The index is : " << ret << "\n";


	return 0;
}