/**
 *	132. Palindrome Partitioning II
 *		Given a string s, partition s such that every substring of the partition is a palindrome
 *	Return the minimum cuts needed for a palindrome partitioning of s
 *	For example, given s = "aab"
 *		Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut 
 **/


#include<iostream>
#include<string>

using namespace std;

class Solution {
public:
	/**
	 *	Try to use divide and conqure to solve the problem
	 *	Divide string to two half
	 **/
	int minCut(string s) {

	}
};


int main() {

	cout << " Function Starts ! \n";

	Solution sol;

	string input = "aab";

	int ret = sol.minCut(input);

	cout << " Minimum cut # is : " << ret << "\n";

	return 0;
} 