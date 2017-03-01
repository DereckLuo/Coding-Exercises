/**
 *	131. Palindrome Partitioning
 *	Given a string s, partition s such that every substring of the partition is a palindrome
 *	Return all possible palindrome partitioning of s.
 *	For example, given s = "aab"
 *	Return
 *	[
 *		["aa", "b"],
 *		["a","a,","b"]
 ]
**/

#include<stdio.h>
#include<iostream>
#include<string>
#include<vector>
#include<stack>

using namespace std; 

class Solution {
public:
	vector<vector<string>> partition(string s) {
		vector<vector<string>> ret; 

		helper(s, ret, 0);

		return ret;
	}

	/*recursive helper function*/
	void helper(string s, vector<vector<string>> & input, int begin) {
		
		//case out of bounds
		if (begin >= s.length())
			return;

		for (int i = begin; i < s.length(); i++) {
			vector<vector<string>> pass;// holder to pass down
			//check all combinations 
			if (isPalindrom(s, begin, i)) {
				string local = formstring(s, begin, i);
				//case it is a palindrom
				helper(s, pass, i + 1); //calling on its children
				if (pass.size() == 0) {
					vector<string> curr;
					curr.push_back(local);
					input.push_back(curr);
				}
				else {
					for (int j = 0; j < pass.size(); j++) {
						vector<string> temp;
						temp.push_back(local);
						for (int k = 0; k < pass[j].size(); k++) {
							temp.push_back(pass[j][k]);
						}
						input.push_back(temp);
					}
				}


			}
		}
	}

	/*iterative helper function */
	void helper2(string s) {
		//int ret[4][4];
		//allocate 2D array
		int** ret = new int*[s.length()];
		for (int i = 0; i < s.length(); i++) {
			ret[i] = new int[s.length()];
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				ret[i][j] = 0;
			}
		}
		
		for (int i = 0; i < s.length(); i++) { //initial position 
			for (int j = i; j < s.length(); j++) { //ending position 
				if (isPalindrom(s, i, j))
					ret[i][j] = 1;
				else
					ret[i][j] = 0;
			}
		}
		
		//print out 2D array 
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				cout << ret[i][j] << " ";
			}
			cout << "\n";
		}
		
		//deallocate the array
		for (int i = 0; i < s.length(); i++) {
			delete[] ret[i];
		}
		delete[] ret;
		
		return;
	}

	/* function to output a substring for string s */
	string formstring(string s, int begin, int end) {
		string ret; //return string 
		for (int i = begin; i <= end; i++) {
			ret.push_back(s[i]);
		}
		return ret; 
	}

	/* function to check if a string is palindrom */
	bool isPalindrom(string s, int begin, int end) {
		stack<char> temp; 
		//corner cases
		if (s.empty())
			return true;

		int first = begin; int second = end;
		while (begin < end) {
			if (s[begin] != s[end]) {
				return false;
			}
			begin += 1;
			end -= 1;
		}
		return true;
	} 

	/* printing out test solutino*/
	void solutionprint(vector<vector<string>> input) {
		cout << "[ ";

		for (int i = 0; i < input.size(); i++) {
			cout << "[ ";
			for (int j = 0; j < input[i].size(); j++) {
				cout << input[i][j] << " , ";
			}
			cout << "] ";
		}

		cout << "] "; 
	}
};


int main() {
	string input; 

	cout << "Palindrom Partitioning program : \n";
		cout << "Pls input computing string : ";
		cin >> input;

		Solution sol; //solution class 

		//sol.helper2(input);
		vector<vector<string>> test; 
		//sol.helper(input, test, 0);
		test = sol.partition(input);

		sol.solutionprint(test);

		cout << "program finished";

		return 0;
}


