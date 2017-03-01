/**
 *	88. Merge Sorted Array:
 *		Given two sorted integer arrays nums1 and nums2, merge num2 into nums1 as one sorted array:
 *
 *	Note:
 *		You may assume that nums1 has enough space ( size that is greater or equal to m + n) to hold 
 *	additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n
 * respectively. 


**/


#include<stdio.h>
#include<iostream>>
#include<vector>
#include<array>

using namespace std;





class Solution {
public:
/**
 *	Merge two arrays: assuming array 1 has enough space, therefore using in place merge
 **/
	void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {

		/*two cases when one of the array is empty*/
		if (n == 0)
			return;
		vector<int> temp; //temperary holding vector

		int pos1, pos2;
		pos1 = 0; pos2 = 0;
		
		while (pos1 < m && pos2 < n) {
			if (nums1[pos1] <= nums2[pos2]) {
				temp.push_back(nums1[pos1]);
				pos1++;
			}
			else {
				temp.push_back(nums2[pos2]);
				pos2++;
			}
		}
		if (pos1 >= m) {
			//case array1 finishes first 
			for (pos2; pos2 < n; pos2++)
				temp.push_back(nums2[pos2]);
		}
		else {
			for (pos1; pos1 < m; pos1++)
				temp.push_back(nums1[pos1]);
		}

		//final copy eveything into array 1
		for (int i = 0; i < temp.size(); i++) {
			nums1[i] = temp[i];
		}
	}


	void printsolution(vector<int> input) {
		cout << "Solution is : ";
		for (int i = 0; i < input.size(); i++) {
			cout << input[i] << " ";
		}
		cout << "\n";	
	}

};


int main() {

	vector<int> array1{7,8,9,0,0,0};
	vector<int> array2{4,5,6};	

	Solution sol;

	sol.merge(array1, 3, array2, 3);

	sol.printsolution(array1);





	return 0;
}