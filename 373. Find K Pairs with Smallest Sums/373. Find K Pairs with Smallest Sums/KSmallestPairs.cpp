/**
 *	373. Find K Pairs with Smallest Sums
 *		You are given two integer array nums1 and nums2 sorted in ascending order and an integer k.
 *	Define a pair (u, v) which consists of one element from the first array and one element from the 
 *	second array.
 *	Find the k pairs(u1,v1),(u2,v2) ... (uk, vk) with the smallest sums. 
 *
 *	Example 1:
 *		Given nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 *	return : [1,2],[1,4],[1,6]
 *	The first 3 pairs are returned from the sequence: 
 *	[1,2], [1,4], [1,6], [7,2], [7,4], [11,2], [7,6], [11,4], [11,6]
 *
 *	Example2: 
 *		Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 *	Return: [1,1],[1,1]
 *	The first 2 pairs are returned from the sequence:
 *	[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 *	Example3:
 *		Given nums1 = [1,2], nums2 = [3],  k = 3 
 *	Return: [1,3],[2,3]
 *	All possible pairs are returned from the sequence:
 *	[1,3],[2,3]
 **/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
	vector<pair<int, int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {

		//return value
		vector<pair<int, int>> ret; 

		//structure to map out visited pairs 
		vector<vector<int>> map; //[arr1][arr2]
		for (int i = 0; i < nums1.size(); i++) {
			vector<int> temp; //creating new row
			for (int j = 0; j < nums2.size(); j++) {
				 temp.push_back(0);
			}
			map.push_back(temp);
		}

		//leading pair index
		int lead_1 = 0, lead_2 = 0;
		//next pair index
		int nex_1 = 1, nex_2 = 0; 



	}

	/**
	 *	Function to print the solution 
	 **/
	void print_pairs(vector<pair<int, int>>& input) {
		cout << "\n[";
		for (int i = 0; i < input.size(); i++) {
			cout << "[" << input[i].first << "," << input[i].second << "],";
		}
		cout << "]\n";
	}
};


int main() {

	cout << "Function Starts ! \n";

	Solution sol;

	vector<int> nums1 = { 1,7,11 };
	vector<int> nums2 = { 2,4,6 };

	vector<pair<int, int>> output = sol.kSmallestPairs(nums1, nums2, 11);

	sol.print_pairs(output);

	return 0;
}