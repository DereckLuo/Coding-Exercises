/**
 *	97. Interleaving String
 *		Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2
 *	For example,
 *	Given:	s1 = "aabcc"	s2 = "dbbca"
 *	When s3 = "aadbbcbcac", return true;
 *	When s3 = "aadbbbaccc", return false;
 **/

#include<iostream>
#include<string>
#include<unordered_set>

using namespace std;

class Solution {
public:
	/** 
	 * 4ms solution using memorization
	 *	convert index result to string and store result in a set to save some time
	 *	striaght forward DP questions
	 **/
	bool isInterleave(string s1, string s2, string s3) {
		//base case
		if (s1.length() + s2.length() != s3.length()) return false;
		unordered_set<string> result;
		return help(s1, 0, s2, 0, s3, 0, result);
	}

	/**
	 * memorization help function 
	 *	s1, s2, s3: three strings
	 *	i1, i2, i3: three index on three s trings to track and compare 
	 **/
	bool help(string & s1, int i1, string & s2, int i2, string & s3, int i3, unordered_set<string> & result) {
		//base case : when string 3 hits the end
		if (i3 == s3.length()) return true;
		//storing string memorize the position of all three trackers
		string str = to_string(i1) + "_" + to_string(i2) + "_" + to_string(i3);
		//if already in the checked and in the result, return false
		if (result.find(str) != result.end()) return false; 
		//new index position
		//matching string 1
		if (i1 < s1.length() && s1[i1] == s3[i3] && help(s1, i1 + 1, s2, i2, s3, i3 + 1, result)) return true;
		//matching string 2
		if (i2 < s2.length() && s2[i2] == s3[i3] && help(s1, i1, s2, i2 + 1, s3, i3 + 1, result)) return true;
		//none of the string matches, store into result, and return false
		result.insert(str);
		return false; 
	}

	/**
	 * Recursive straight solution
	 * Checking if string 3 is interleaving of s1 and s2
	 * Recursive solution timeout ! 
	 **/
	bool isInterleaveTimeout(string s1, string s2, string s3) {
		int s1_size, s2_size, s3_size;
		//some special cases
		s1_size = s1.size(); s2_size = s2.size(); s3_size = s3.size();
		if (s3_size == 0) {
			if (s2_size == 0 && s1_size == 0) return true;
			else return false;
		}
		//general case
		return Interleavehelper(s1, s2, s3, 0, 0, 0, s1_size, s2_size, s3_size);
	}

	/**
	 * Recursive helper function to find if interleave
	 *	s3 : the interleave string
	 *	s1, s2: the beginning string
	 *	indx1, indx2 indx3: three index to track the comparing position
	 **/
	bool Interleavehelper(string s1, string s2, string s3, int indx1, int indx2, int indx3, int size1, int size2, int size3) {
		bool check1 = false, check2 = false;
		//base case when hitting the end
		if (indx3 == size3 - 1) { //case hitting the end in the big string
			if (indx1 < size1-1 || indx2 < size2-1) return false;
			if (indx1 == size1) {
				if (s2[indx2] == s3[indx3]) return true;
				else return false;
			}
			if (indx2 == size2) {
				if (s1[indx1] == s3[indx3]) return true;
				else return false;
			}
		}

		//case non matches
		if ((s1[indx1] != s3[indx3]) && (s2[indx2] != s3[indx3])) {
			return false;
		}
		//case one match, and using one
		if (s1[indx1] == s3[indx3]) {
			check1 = Interleavehelper(s1, s2, s3, indx1 + 1, indx2, indx3 + 1, size1, size2, size3); //moving 1 from s1
			if (check1) return true;
		}
		//case two match, and using two
		if (s2[indx2] == s3[indx3]) {
			check2 = Interleavehelper(s1, s2, s3, indx1, indx2 + 1, indx3 + 1, size1, size2, size3);
			if (check2) return true;
		}
		return false;
	}
};

int main() {
	cout << " Function Starts ! \n";

	Solution sol;
	string input1, input2, input3;
	cout << "Input first string : ";
	cin >> input1;
	cout << "Input second string : ";
	cin >> input2;
	cout << "Input third string : ";
	cin >> input3;

	if (sol.isInterleave("a", "", "abcd"))
		cout << "True !\n";
	else
		cout << "False !\n";

	return 0;
}