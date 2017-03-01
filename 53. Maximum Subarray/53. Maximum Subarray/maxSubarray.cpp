/**
 *	53. Maximum Subarray:
 *		Find the contiguous subarray within an array (containing at least one number) which
 *	has the largest sum.
 *	For example, given the array [-2,1,-3,4,-1,2,1,-5,4]
 *	the contiguous subarray [4,-1,2,1] has the largest sum = 6
 *	More practice: 
 *		If you have figured out the O(n) solution, try coding another solution using the 
 *	devide and conquer approach which is more subtle
 **/


#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	int maxSubArray(vector<int>& nums) {
		int ret = 0;
		int sub_start = 0, sub_end = 0;
		ret = subhelp(nums, 0, nums.size() - 1, sub_start, sub_end);
		cout << " sub start is : " << sub_start << " sub end is : " << sub_end << "\n";

		return ret;
	}

	/**
	 *	Recursive helper function to calculate the maxSubArray
	 *	nums : the original array reference
	 *	n : the position of calculating the array 
	 **/
	int subhelp(vector<int>& nums, int start, int end, int& sub_start, int& sub_end) {
		//base case: single element array
		if (start == end) {
			sub_start = start; sub_end = end;
			return nums[start];
		}

		//recursive case
		int mid = start + ((end - start) / 2); //the middle position
		//cout << "mid is : " << mid << "\n";
		int left_sub_s = 0, left_sub_e = 0, right_sub_s = 0, right_sub_e = 0;
		int left_value = subhelp(nums, start, mid, left_sub_s, left_sub_e);
		int right_value = subhelp(nums, mid + 1, end, right_sub_s, right_sub_e);

		//finding the largest sum in current array 
		int mid_value = 0;
		for (int i = left_sub_s; i <= right_sub_e; i++) {
			mid_value += nums[i];
		}
		cout << " start is : " << start << " end is : " << end << " ";
		cout << "mid point is : " << mid << "\n";
		cout << "left is : " << left_value << " from " << left_sub_s << " to " << left_sub_e << " right is : " << right_value << " from " << right_sub_s << " to " << right_sub_e << " mid is : " << mid_value << " from " << left_sub_s << " to " << right_sub_e << "\n\n";
		//mid_value = mid_value + left_value + right_value; 
		if (mid_value >= left_value && mid_value >= right_value) {
		//	cout << "ret 1 \n";
			//ca se combined array is larger
			sub_start = left_sub_s; sub_end = right_sub_e;
			return mid_value;
		}
		else if (left_value >= right_value) {
		//	cout << "ret 2 \n";
			//case left subarray is larger 
			sub_start = left_sub_s; sub_end = right_sub_e;
			return left_value;
		}
		else {
		//	cout << "ret 3\n";
			//case right subarray is larger 
			sub_start = right_sub_s; sub_end = right_sub_e;
			return right_value;
		}

	}

	/*print the subarray */
	void print_array(vector<int>& input) {
		for (int i = 0; i < input.size(); i++) {
			cout << input[i] << ", ";
		}
		cout << "\n";
	}

	/**
	 * Possible DP solution for maxsubarray
	 *	It works but DID NOT MEET TIME LIMITS !!!!! =(((((((
	 *	Running time is O(n^2)
	 **/
	int maxSubArrayDP(vector<int>& nums) {
		int ret = INT_MIN; //return value 
		int n = nums.size();
		//base case
		if (n == 0) {
			return INT_MIN;
		}

		//DP store table 
		vector<vector<int>> table;
		for (int i = 0; i < n; i++) {
			vector<int> temp;
			for (int j = 0; j < n; j++) {
				temp.push_back(0);
			}
			table.push_back(temp);
		}

		//filling all single substring 
		for (int i = 0; i < n; i++) {
			table[i][i] = nums[i];
			if (table[i][i] > ret) ret = table[i][i];
		}

		//check rest length of substrings
		for (int k = 2; k <= n; k++) {//loop through all possible substring length
			for (int i = 0; i <= n - k; i++) {//loop through all possible starting positions 
				int end_idx = i + k - 1;
				table[i][end_idx] = table[i][end_idx - 1] + nums[end_idx];
				if (table[i][end_idx] > ret) ret = table[i][end_idx];
			}
		}
		
		return ret;
	}
};

int main() {
	cout << "Function Starts ! \n";

	Solution sol;

	vector<int> input = { 13, -2, -13, -4, 2, 10, 4, -4, -1, -6, 9 };
	//vector<int> input = { 1, -1, -2 };

	sol.print_array(input);

	int output = sol.maxSubArray(input);

	cout << "Final output is : " << output << "\n";

	return 0;
}