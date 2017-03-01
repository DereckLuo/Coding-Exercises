// you can use includes, for example:
// #include <algorithm>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;


#include<iostream>
#include<vector>

using namespace std;

//using a N*M vector to store and check if they already belong to a country or not
int solution(vector< vector<int> > &A) {
	// write your code in C++11 (g++ 4.8.2)
	//base case 
	if (A.size() == 0) return 0; //case no country
	int rows = A.size(); int columns = A[0].size();

	int ret = rows*columns; //number of countries, starting with max number, -1 country with every single merge

	//starting at the upper left corner

	for (int i = 0; i < rows; i++) { //going through rows 
		for (int j = 0; j < columns; j++) { //going through columns 
			if (j != 0 && A[i][j] == A[i][j - 1]) { //check left if can merge
				ret--; //merged one country
			}
			else if (i != 0 && A[i][j] == A[i - 1][j]) {//check up if can merge
				ret--;
			}
		}
	}
	return ret;
}

int main() {
	cout << "Function Starts ! \n";

	vector<vector<int>> map; //the map of countries 
	vector<int> temp0 = { 5,4,4 };
	map.push_back(temp0);
	vector<int> temp1 = { 3,2,4 };
	map.push_back(temp1);
	vector<int> temp2 = { 2,4,5 };
	map.push_back(temp2);
	vector<int>	temp3 = { 2,5,5 };
	map.push_back(temp3);

	auto ret = solution(map);

	cout << "Number of countries are : " << ret << "\n";
	return 0;
}