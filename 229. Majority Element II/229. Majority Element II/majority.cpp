/**
 *	229. Majority Element II
 *		Given an integer array of size n, find all elements that appear more than celling(n/3) times. 
 *	The algorithm should run in linear time and in O(1) space
 **/

#include<iostream>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
public:
	vector<int> majorityElement(vector<int>& nums) {

		vector<int> ret;
		
		ret = majorityhelp1(nums);

		return ret;
	}

	/**
	 *	None Linear Time O(n) space solution 
	 **/
	vector<int> majorityhelp1(vector<int>& nums) {
		vector<vector<int>> store; //structure to store elements
		vector<int> ret; // return value 

		 //loop through array 
		for (int i = 0; i < nums.size(); i++) {
			bool find = false;
			for (int j = 0; j < store.size(); j++) {
				//find its category
				if (store[j][0] == nums[i]) {
					store[j].push_back(nums[i]);
					find = true;
				}
			}
			if (!find) {
				vector<int> temp;
				temp.push_back(nums[i]); store.push_back(temp);
			}
		}
		//loop through the store and return answer
 
		int size = nums.size() / 3;
		for (int i = 0; i < store.size(); i++) {
			if (store[i].size() > size)
				ret.push_back(store[i][0]);
		}

		return ret;
	}

	/**
	*	Other function ideas:
	*		Because it is looking for majority for more than celling of (n/3), the answer would be
	*	less than or equal to two numbers.
	*		The essential concepts is to keep a counter for the majority number X. if you find a number Y
	*	that is not X, the current counter should decduce 1. The reason is that if there is 5X and 4Y, there
	*	would be one more X than Y. This could be explained as "4 X being paired out by 4 Y"
	**/
	/***----------------------------- This solution does NOT work completely --------------------------------***/
	vector<int> majorityhelp2(vector<int>& nums) {
		vector<int> ret; 
		//corner cases
		if (nums.size() == 0) return ret;
		//two counters and two value holder
		int counter1 = 0, counter2 = 0, candidate1 = 0, candidate2 = 1;
		//loop through the vector
		for (int i = 0; i < nums.size(); i++) {
			if (nums[i] == candidate1) {
				counter1 += 1;  //case match candidate 1
				counter2 -= 1;
			}	
			else if (nums[i] == candidate2) {
				counter2 += 1; //case match candidate 2 
				counter1 -= 1;
			}
			else if (counter1 <= 0) {
				candidate1 = nums[i]; counter1 = 1;  //case candidate 1 become minority
			}
			else if (counter2 <= 0) {
				candidate2 = nums[i]; counter2 = 1;	//case candidate 2 become minority
			}
			else {
				counter1 = counter1 - 1; counter2 = counter2 - 1; //not matching update
			}
		}
		//cout << "counter 1 : " << counter1 << " counter 2 : " << counter2 << "\n";
		//check if there is no majority
		if(counter1 > 0)
			ret.push_back(candidate1);
		if(counter2 > 0)
			ret.push_back(candidate2); 
		return ret;
	}


	void print(vector<int> & nums) {
		cout << "\n";
		for (int i = 0; i < nums.size(); i++)
			cout << nums[i] << ", ";
		cout << "\n";
	}
};




int main() {

	cout << "Function Starts! \n";

	Solution sol;

//	vector<int> input{1,2,3,4,5,6};
	vector<int> input{3,3,4 };
//	vector<int> input{ 1,2,1,3,3,3,3,3,3 };

	vector<int> ret; 

	cout << "Boyer-Moor Majority Algorithm : \n";

	ret = sol.majorityhelp2(input);

	sol.print(ret);

	cout << "Working Slow Algorithm : \n";

	ret = sol.majorityElement(input);

	sol.print(ret);

	return 0;
}