/** 
 *	278. First Bad Version
 *		You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the 
 *	quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad. 
 *	Suppose you have n versions [1,2,....,n] and you want to find out the first bad one, which cases all the following ones to be bad. 
 *	You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version.
 *	You should minimize  the number of calls to the API
 **/

#include<iostream>

using namespace std;


// Forward declaration of isBadVersion API.
bool isBadVersion(int version);

class Solution {
public:
	/**
	 *	because all versions are "sorted"
	 *	using the binary search to find it
	 **/
	int firstBadVersion(int n) {
		return BShelper(1, n);
	}

	/** 
	 *	BShelper:
	 *		binary search helper to find the bad version
	 *	taking the starting and ending position of array
	 *  Return: return the bad version number 
	 */
	int BShelper(int start, int end) {
		//base case
		if (start == end) { //case single version located 
			if (start == 1) return 1; //first version is bad 
			if (isBadVersion(start) && !isBadVersion(start - 1)) {//case current bad version and previous non-bad version
				return start;
			}
			else return -1; //case not the point we are looking for
		}

		//recursive searching
		int mid = start + ((end - start) / 2);
		if (isBadVersion(mid)) { //case search before mid point 
			return BShelper(start, mid); //previous always contains a bad version
		}
		else {//search after midpoint 
			return BShelper(mid + 1, end);
		}
	}

};


int main() {
	cout << "Function Starts ! \n";
	Solution sol;

	auto output = sol.firstBadVersion(100);
	cout << "The bad version is : " << output << "\n";
}