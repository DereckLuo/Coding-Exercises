/**
 *	354. Russian Doll Envelopes
 *	You havea number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit 
 *	into another if and only if both the width and height of one envelope is greater than the width and height of the other 
 *	envelope
 *	What is the maximum number of envelopes can you Russian doll? 
 *	Example:
 *		Given envelopes = [[5,4], [6,4], [6,7], [2,3]], the maximum number of envelopes you can Russian dool is 3
 *	([2,3] => [5,4] => [6,7])
 **/


#include <iostream>
#include <vector>
#include <array>

using namespace std;

class Solution {
public:
	/**
	 *	using DP back tracking algorithm to find the maxEnvelopes 
	 *	using 1D array store number of envelopes it can contain for current envelope 
	 *	First DP solution, O(n^2) running time with DP, not good 
	 **/
	int maxEnvelopes(vector<pair<int, int>>& envelopes) {
		int ret = 0;

		//initiate DP array
		vector<int> table;
		for (int i = 0; i < envelopes.size(); i++) table.push_back(-1); 

		for (int i = 0; i < envelopes.size(); i++) { //choosing starting envelop
			int cur = EnvelopesNum(envelopes, table, i); //return the max numebr of envelop starting with 
			if (cur > ret) ret = cur; 
		}

		return ret;
	}

	/**
	 *	Recursive helper function to calculate the number of envelop starting with position i 
	 **/
	int EnvelopesNum(vector<pair<int, int>> & envelopes, vector<int> & table, int pos) {
		int ret = 1;
		for (int i = 0; i < envelopes.size(); i++) {//pairing with every other envelopes 
			if ((envelopes[pos].first > envelopes[i].first) && (envelopes[pos].second > envelopes[i].second)) { //case can fit 
				int temp;
				if (table[i] != -1) temp = table[i] + 1;
				else {
					temp = EnvelopesNum(envelopes, table, i) + 1;
				}
				if (temp > ret) ret = temp;
			}
		}
		table[pos] = ret;
		return ret;
	}


	/**
	 *	Function to create input 
	 **/
	vector<pair<int, int>> inputcreate() {
		vector<pair<int, int>> ret; 
		pair<int, int> p1; p1.first = 5; p1.second = 4;
		ret.push_back(p1);
		pair<int, int> p2; p2.first = 6; p2.second = 4;
		ret.push_back(p2);
		pair<int, int> p3; p3.first = 6; p3.second = 7;
		ret.push_back(p3);
		pair<int, int> p4; p4.first = 2; p4.second = 3;
		ret.push_back(p4);

		return ret;
	}
};



int main() {
	cout << "Function Starts ! \n";

	Solution sol;

	auto input = sol.inputcreate();

	int output = sol.maxEnvelopes(input);

	cout << " The maximum Russian Doll envelopes are : " << output << "\n";

	return 0;
}