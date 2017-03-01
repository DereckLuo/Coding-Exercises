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
		num = 1; weight = A[pos]; stop = 0;
		while (num <= X && weight <= Y) {//while not reach number limit or weight limit
			if (table.find(B[pos]) == table.end()) {//case not in the table
				cout << "pos is : " << pos << " floor is : " << B[pos] << "\n";
				table[B[pos]] = 1; stop++;
			}
			//update next value 
			pos++;
			if (pos >= A.size()) break;
			num++; weight += A[pos];
		}
		stop++; ret += stop; //finish one load of people
		cout << "pos is : " << pos << " stop is : " << stop << "\n";
		cout << "\n";
		table.clear(); //clear table
	}

	return ret;
}


int main() {
	cout << "Test Starts ! \n";
	int M = 1, X = 5, Y = 200;
	vector<int> A = {1,1,1,1};
	vector<int> B = { 1,1,1,1};

	auto output = solution(A, B, M, X, Y);
	cout << "Final result is : " << output << "\n";


	return 0;
}