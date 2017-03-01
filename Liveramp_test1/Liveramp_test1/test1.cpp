#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution
{
public:
	// you can use includes, for example:
	// #include <algorithm>

	// you can write to stdout for debugging purposes, e.g.
	// cout << "this is a debug message" << endl;

	//because no two stones will surface simultaneously
	//therefore at least need to be after length/D time

	//think about a new solution
	//each space, will has a time that the monkey will jump at it.
	// it will either be the time on the space itself(largest), or the time that in reachable position before jumping onto it
	// using a N size vector to store the time that takes to jump onto the specific spot
	// the time will be -1 if can't jump onto it yet. 
	// =D
	// input values :
	// N : number of stones in the river ( 0 - 100,000)
	// D : jumping distance (1 - 100,001)
	// A[]: stone surface time (-1 - 100,000)
	// one stone surface at once
	int solution1(vector<int> &A, int D) {
		// write your code in C++11 (g++ 4.8.2)
		int length = A.size(); 
		if (D > length) return 0; //able to jump to the other side in one jump

		vector<int> table(length, -1); //the DP table store time will take to get to specific location
		
		//initialize first jump time in table
		for (int i = 0; i < D; i++) {
			table[i] = A[i];
		}
		
		//complete the DP table
		for (int i = D; i < length; i++) {

		}



		return 0;

	}

	//solution 2
	//finding the max first
	//trying to jump as far as i can on each time, until max time, see if i can across
	int solution(vector<int> & A, int D) {
		int length = A.size();
		if (D > length) return 0; //able to jump to the other side in one jump
		//find the max time limit
		int max_time = -2; //A[] has range from -1 to 100,000
		for (int i = 0; i < length; i++) {
			if (A[i] > max_time) max_time = A[i];
		}
		//set minimum time: because only 1 stone surface at a time, so at lest need length/D stones, and at least need length/D time
		int min_time = length / D; //C++ round down, it is save
		int pos = -1; //the position of the monkey
		for (int i = min_time; i <= max_time; i++) {//loop through all possible time
			//find if monkey can progress in this time 
			bool jump = true;
			while (jump) {
				jump = false;
				for (int j = 1; j <= D; j++) {
					if ((pos + j < length) && (A[pos + j] <= i)) {
						pos += j; jump = true;
					}
				}
			}
			//check if reach the end
			if (pos >= (length - D)) return i;
		}
		return -1;
	}

	void printtable(vector<int> & A) {
		for (int i = 0; i < A.size(); i++) {
			cout << A[i] << " ";
		}
		cout << "\n";
	}

private:

};

int main() {
	cout << "Function Starts ! \n";

	Solution sol;

	vector<int> input = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};	
	auto output = sol.solution(input, 3);

	cout << "time to cross is : " << output << "\n";

	return 0;
}