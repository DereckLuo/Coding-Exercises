// you can use includes, for example:
// #include <algorithm>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;


#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
#include<unordered_map>

using namespace std;

int solution(vector<int> &A, vector<int> &B, int M, int X, int Y) {
	// write your code in C++11 (g++ 4.8.2)
	int pos = 0; //counting the position of the queue
	int num = 0; int weight = 0;
	int ret = 0; int stop = 0;

	unordered_map<int, int> table; //the table to store see if someone is going to the floor

	while (pos < A.size()) { //while haven't finish all person 
		//loading person
		num = 1; weight = A[pos];
		while (num <= X && weight <= Y) {//while not reach number limit or weight limit
			if (table.find(B[pos]) == table.end()) {//case not in the table
				table[B[pos] = 1]; stop++;
			}
			//update next value 
			pos++;
			if (pos >= A.size()) break;
			num++; weight += A[pos];
		}
		stop++; ret += stop; //finish one load of people
		table.clear(); //clear table
	}

	return ret;
}


int main() {
	cout << "Test Starts ! \n";
	int M = 3, X = 5, Y = 200;
	vector<int> A = { 40,40,100,80,20 };
	vector<int> B = { 3,3,2,2,3 };

	auto output = solution(A, B, M, X, Y);
	cout << "Final result is : " << output << "\n";


	return 0;
}