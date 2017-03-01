/**
 *	231. Power of Two:
 *		Given an integer, write a function to determine if it is a power of two
 **/

#include<iostream>


using namespace std;

class Solution {
public:
	/**
	 * Do not need to work with fraction or negative number
	 **/
	bool isPowerOfTwo(int n) {
		if (n <= 0) return false;
		int num_bits = 8 * sizeof(n); //the number of bits in the input 
		int count = 0;

		for (int i = 0; i < num_bits; i++) {
			if ( (n>>i) & 1)
				count++; 
			if (count > 1)
				break;
		}

		if (count == 1)
			return true;
		else
			return false;
	}
};

int main() {
	cout << "Function Starts ! \n";

	Solution sol;

	int input = 8;

	if (sol.isPowerOfTwo(input))
		cout << " input is power of two \n";
	else
		cout << " input is NOT power of two \n";

	return 0;
}