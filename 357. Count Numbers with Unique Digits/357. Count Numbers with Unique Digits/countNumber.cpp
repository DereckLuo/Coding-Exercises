/**
 *	357. Count Numbers With Unique Digits
 *		Given a non-negative integer n, count all numbers with unique digits, x
 *	where 0 <= x < 10^n
 *	Example:
 *		Given n = 2 return 91.( The answer should be the total number in the 
 *	range of 0 <= x < 100, excluding  [11,22,33,44,55,66,77,88,99])
 **/

#include<iostream>
#include<algorithm>
#include<vector>
#include<math.h>
#include<array>

using namespace std;


class Solution {
public:
	/**
	 *	Number of non-unique digits x: 
	 *	n = 0(1),		 0
	 *	n = 1(1),		 0
	 *	n = 2(100),		 9
	 *  n = 3(1000),	 9(0-99) + (9+10+10-2)*9  = 
	 **/
	int countNumbersWithUniqueDigits(int n) {
		int ret = 0; //return value 
		if (n == 0) return 1;
		bool check = false;

		int* arr = new int[10]; //array to store present number value 0 1 2 3 4 5 6 7 8 9;
		for (int i = 0; i < 10; i++) arr[i] = 0;

		int* num = new int[n + 1]; //array to tracking number 
		for (int i = 0; i < n + 1; i++) num[i] = 0;

		ret = counthelper_BackTracking(0, n, arr, check);

		delete[] arr;

		return ret;
	}

	/**
	* Backtracking solution:
	*	Backtracking that incrementally builds candidates to the solutions, and abandons each
	*	partial candidate c("backtracks") as soon as it determines that c cannot possibly
	*	be completed to a valid solution.
	**/
	/**
	 *	using Backtracking algorithm:
	 *		assign one digit, going down and assign another, if the same, return, else keep going 
	 *	until hits the end and count as one. 
	 *	n : the max number of digits
	 *	digit : the diti that is operating at
	 *	arr : a pointer to point at the digit tracking array
	 **/
	int counthelper_BackTracking(int digit, int n, int* arr, bool & check) {
		int ret = 0; //number of unique numbers 
		//cout << "digit is : " << digit << " n is : " << n << "    ";
		//printarr(arr, 10);
		//base case 
		if (digit == n-1) {//case the last digit 
			for (int i = 0; i < 10; i++) {//loop through all possible numbers 
				if (i == 0 && !check) {
					ret += 1;
				}
				else if (arr[i] != 1) {
					ret += 1;
				}
			}
		//	cout << " ret is : " << ret << "\n";
		}
		else {
			//recursive case 
			for (int i = 0; i < 10; i++) { //all possible numbers to be at this digit 
				if (i == 0 && !check) {
					//cout << "upper level = " << num[0] << "\n";
					ret += counthelper_BackTracking(digit + 1, n, arr, check);
				}
				else if (arr[i] != 1) { //case first time find this number 
					check = true;
					arr[i] = 1; //mark the array 
					//cout << " upper level = " << num[0] << "\n";
					ret += counthelper_BackTracking(digit + 1, n, arr, check);
					arr[i] = 0; //dismark the array
					check = false;
				}
			}
		}

		return ret;
	}

	/**
	 *	Mathmatic calculation: 
	 **/
	int counthelp_math(int n) {
		/*three base cases */
		if (n == 0) return 1;
		if (n == 1) return 10;
		if (n == 2) return 91; 
	
		int base = 81, count = 91;
		for (int i = 3; i <= min(10, n); i++) {
			base = base*(10 - i + 1);
			count += base;
		}
		return count;
	}
	

	/**
	 *	array printing function 
	 *	arr: the array being printed 
	 *	n : the size of the array 
	 **/
	void printarr(int* arr, int n) {
		for (int i = 0; i < n; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
	}


};

	


int main() {

	cout << "Function Starts ! \n";

	Solution sol;

	int ret = sol.countNumbersWithUniqueDigits(4);

	cout << " Final value is : " << ret << "\n";

	return 0;

}