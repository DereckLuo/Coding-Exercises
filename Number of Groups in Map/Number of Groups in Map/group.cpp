/**
 * Find number of groups in a 2D array
 *	Given a 2D array, find how many group of 1s in there
 *	A group of ones are connected in 8 directions, top down left right upleft upright downleft downright
 **/

#include<iostream>
#include<vector>

using namespace std;

class Solution
{
public:
	/** 
	 * Function given a 2D array, given the number of groups in the array
	 * Assume table is a rectangle
	 *	Going through entire array 2 times running time O(M*N)
	 *	solving the problem in space, space O(1)
	 **/
	int groups(vector<vector<int>>& table) {
		//base case
		if (table.size() == 0) return 0;
		int y = table.size(); int x = table[0].size();

		int ret = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (table[i][j] == 1) ret++;
			}
		}
		//ret contains the max number of groups 
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (table[i][j] == 1) { //case potential merge
					if (j != 0 && table[i][j - 1] == 1) ret--;
					else if (i != 0 && table[i - 1][j] == 1) ret--;
				}
			}
		}
		return ret;
	}

private:

};

int main() {
	cout << "Function Starts ! \n";

	Solution sol;
	vector<vector<int>> table;
	table.push_back({ 0,0,1,1 });
	table.push_back({ 0,0,0,0 });
	table.push_back({ 1,0,0,0 });
	table.push_back({ 1,0,1,0 });
	table.push_back({ 0,0,0,1 });	

	auto output = sol.groups(table);

	cout << "Number of groups are : " << output << "\n";
	return 0;
}

