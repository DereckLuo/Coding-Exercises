/** 
 *	349. Intersection of Two Arrays
 *		Given two arrays, write a function to compute their intersection
 *	Example:
 *		Given nums1 = [1,2,2,1], nums2 = [2,2], return [2]
 *	Note 
 *		Each element in the result must be unique
 *		The result can be in any order 
 **/

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;


/**
 * can only do single number intersection
 **/
class Solution {
public:
	vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
		vector<int> ret; //the return vector
		//sorting two vectors for easier computation
		sort(nums1.begin(), nums1.end());
		sort(nums2.begin(), nums2.end());
		cout << " first array is : ";
		for (int i = 0; i < nums1.size(); i++)
			cout << nums1[i] << " ";
		cout << "\n";
		cout << " second array is : ";
		for (int i = 0; i < nums2.size(); i++)
			cout << nums2[i] << " ";
		cout << "\n";

		int idx1 = 0, idx2 = 0; bool check = false;

		while (idx1 < nums1.size() && idx2 < nums2.size()) {
			cout << idx1 << " " << idx2 << "\n";
			if (nums1[idx1] == nums2[idx2] && !check) {
				ret.push_back(nums1[idx1]);
				check = true;
			}
			if (check) {
				while (nums1[idx1 + 1] == nums1[idx1]) {
					idx1++;
					if (idx1 == nums1.size()-1) return ret;
				}
				idx1++;
				while (nums2[idx2 + 1] == nums2[idx2]) {
					idx2++;
					if (idx2 == nums2.size() -1) return ret;
				}
				idx2++;
				check = false;
				cout << "cp2" << idx1 << " " << idx2 << " " << "\n";
			}
			if (nums1[idx1] < nums2[idx2])
				idx1++;
			else
				idx2++;
		}
		return ret;
	}
};


int main() {
	cout << "Function Starts ! \n";
	Solution sol;

	vector<int> input1 = { 1,2 };
	vector<int> input2 = { 2,1 };

	auto output = sol.intersection(input1, input2);
	for (int i = 0; i < output.size(); i++) {
		cout << output[i] << " ";
	}
	cout << "\n";
	
	return 0;
}