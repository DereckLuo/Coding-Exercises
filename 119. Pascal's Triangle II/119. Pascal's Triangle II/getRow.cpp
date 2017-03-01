/**
 *	119. Pascal's Triangle II
 *		Given an index k, return the kth row of the pascal's triangle
 *	For example, given k = 3,
 *	return [1,3,3,1]
 *	Note:
 *		Could you optimize your algorithm to use only O(k) extra space?
 **/

#include<iostream>
#include<vector>

using namespace std;


class Solution {
public:
	
	vector<int> getRow(int rowIndex) {
		vector<int> ret; 
		return ret;
	}


	/**
	* DP solution to find the Pascal solution
	**/
	vector<int> getRowDP(int rowIndex) {
		//creating DP store structure
		vector<vector<int>> table; 
		for (int i = 1; i <= rowIndex; i++) {
			vector<int> temp;
			for (int j = 0; i < i; i++) {
				temp.push_back(0);
			}
			table.push_back(temp);
		}
		printTable(table);

		vector<int> ret; //return vector
		for (int i = 1; i <= rowIndex; i++) {
		//	ret.push_back(getRowDPhelp(rowIndex, rowIndex, i, table));
		}
		//return 0;
		vector<int> temp;
		return ret;
	}
	/**
	 *	Recursive solution to find the Pascal solution 
	 *	rowIndex : the row that we are looking for 
	 *	row: the current row that we are at
	 *	index : current calculating index 
	 *	table: DP storage 
	 **/
	int getRowDPhelp(int rowIndex, int row, int index, vector<vector<int>>& table) {
		if (index == 1 || index == rowIndex) return 1;
		return 0;
	}

	/*function to print the row */
	void printRow(vector<int>& row) {
		for (int i = 0; i < row.size(); i++) {
			cout << row[i] << " ";
		}
		cout << "\n";
	}

	/* function to print the table*/
	void printTable(vector<vector<int>> & table) {
		for (int i = 0; i < table.size(); i++) {
			for (int j = 0; j < table[i].size(); j++) {
				cout << table[i][j] << " ";
			}
			cout << "\n";
		}
	}
};

int main() {

	cout << "Function Starts ! \n";

	Solution sol;

	sol.getRowDP(4);

	return 0;
}