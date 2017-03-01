/**
 *	IMC coding test
 *	Question 1!
 **/


#include<iostream>
#include<algorithm>
#include<vector>
#include<string>

using namespace std;

	// you can use includes, for example:
	// #include <algorithm>

	// you can write to stdout for debugging purposes, e.g.
	// cout << "this is a debug message" << endl;

	//brute force solution will be quite straight forward 
	//looping through all possible substring combinations and check every single of them
	//pretty bad run time, if checking substring correctness is O(1), worest case algorithm runtime is O(N^2)
	//ok space complexcity, which solving the problem in place O(1)

	/**
	* The DP solution for this question
	* Given a 2D vector vec[a][b] which indicate if the substring starting at a ending at b is a password
	* four indicators 1: yes, 0: has the potential, -1: no, 2: haven't check before
	*/



	int solution(string &S) {
		// write your code in C++11 (g++ 4.8.2)
		int length = S.size(); //the size of input string
		if (length == 0) return -1; //case invalid string input
		int maxlengh = -1; //return value of maxlength
		cout << "cp0 : length is : " << length << "\n";
		//building DP table, filling length 1 substring
		 
		vector<int> temp(length, 2);
		vector<vector<int>> table(length, temp);//the table to store DP solution
		for (int i = 0; i < length; i++) { //starting point
			//table.push_back(temp);
			if (S[i] >= '0' && S[i] <= '9') {//case it is a number 
				table[i][i] = -1;
			}
			else if (S[i] >= 'a' && S[i] <= 'z') {//case it is a lower case
				table[i][i] = 0;
			}
			else if (S[i] >= 'A' && S[i] <= 'Z') {//case it is a upper case
				table[i][i] = 1; maxlengh = 1;
			}
		}
		cout << "cp1\n";
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				cout << table[i][j] << " ";
			}
			cout << "\n";
		}
		cout << "cp2 \n";

		for (int i = 2; i <= length; i++) {//looping through all possible length (2-length)
			for (int j = 0; j <= length - i; j++) {//looping through all possible starting positions (0 - maxl-l)
				int end_idx = j + i - 1; //end of substring 
				cout << "length is : " << i << "start at : " << j << " end at : " << end_idx << "\n";

				if ((S[end_idx] >= '0' && S[end_idx] <= '9') || table[j][end_idx-1] == -1) {
					table[j][end_idx] = -1;
					cout << "ca1\n";
				}
				else if (S[end_idx] >= 'A' && S[end_idx] <= 'Z') {
					table[j][end_idx] = 1; 
					if (i > maxlengh) maxlengh = i;
					cout << "ca2\n";
				}
				else {
					table[j][end_idx] = table[j][end_idx - 1];
					if (table[j][end_idx] == 1 && i > maxlengh) maxlengh = i;
					cout << "ca3\n";
				}
				cout << "\n";
			}
		}
		return maxlengh;
	}


int main() {
	cout << "Test Starts ! \n";
	string input = "ab0Ba";
	auto output = solution(input);
	cout << "Max length is : " << output << "\n";


	return 0;
}