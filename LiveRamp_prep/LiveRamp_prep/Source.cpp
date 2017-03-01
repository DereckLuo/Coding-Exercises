#include<iostream>
#include<vector>


/**
 *	monkey want to get to the other side of the river 
 *	initial location of river -1 
 *	get to opposite bank position N (size of array)
 *	monkey can jump 1-D (D <= N), AKA can't one jump to the other side 
 *	Think as finding the number S in the array such that there are less than N-1 numbers that are greater than S in the entire array 
 *
 *
 *
 *	New solution: considering letting the monkey jump as far as he can in each time, and starting at the farest previous location and keep going next time 
 **/


using namespace std;

class Solution
{
public:
	int MonkeyJump(vector<int> & A, int D) {
		int ret = -1; //return time 
		int pos = -1; //monkey position, starting at left bank -1 
		int max_time = -1; 
		int river_size = A.size(); 
		
		//base case:
		if (river_size == 0) return 0;

		//find the maximum time 
		for (int i = 0; i < river_size; i++) {
			if (A[i] > max_time) max_time = A[i];
		}
		//base case no stone in river at all 
		if (max_time == -1) return -1;

		//looping the time from min to max and jump the monkey 
		for (int i = 0; i <= max_time; i++) {
			//for each time, moving the monkey forward 
			int step = 1;
			while (step <= D) { //while loop to jump as far as possible 
				if ((pos + step) >= river_size) {
					return i; //reached to the other bank
				}
				if ((A[pos + step] <= i) && (A[pos+step] != -1)) { //case there is a stone at that position  
					pos = pos + step; step = 0; //update position and reset 
				}
				step++;
			}
		}
		return -1; //can't jump over the river 
	}

private:

};


int main() {
	cout << "Function Starts !\n";

	Solution sol;

	//vector<int> input = { 1, -1, 0, 2, 3, 5 }; //input vector
	vector<int> input = { 8,-1,-1,4,-1,-1,-1,-1,-1 };
	//vector<int> input = { -1,-1,-1,-1,-1,-1 };

	auto ret = sol.MonkeyJump(input, 9);
	cout << "Earliest time is : " << ret << "\n";

	return 0;
}