/**
 * 43. Multiply Strings:
 *		Given two numbers represented as strings, return multiplication of the numbers as a string
 *	Noe: 
 *		The numbers can be arbitrarily large and are non-negative
 *		Converting the input string to integer is NOT allowed
 *		You should NOT use internal library such as BigInteger
 **/

#include<iostream>
#include<string>

using namespace std;


class Solution {
public:
	string multiply(string num1, string num2) {
		int size_1 = num1.size(), size_2 = num2.size();
		if (size_1 == 0 || size_2 == 0) return ""; //case one of the string is empty

		//calcuating the actual value 
		string ret(size_1 + size_2, '0'); //return string starting with all 0s, can not be longer thatn size1+size2
		int i, j;
		for (i = size_2 - 1; i >= 0; i--) {//looping through second string 
			int carry = 0; int sum = 0;
			int num_2 = num2[i] - '0'; //get the num2 number
			for (j = size_1 - 1; j >= 0; j--) { //looping through first string 
				int mult = num_2 * (num1[j] - '0');
				sum = mult + (ret[size_1 + size_2 - 1 - (size_1 - 1 - j) - (size_2 - 1 - i)]-'0') + carry;
				carry = sum / 10;
				sum = sum % 10;
				ret[size_1 + size_2 - 1 - (size_1 - 1 - j) - (size_2 - 1 - i)] = sum + '0';
			}
			//if has additional carry out, add to the string 
			if (carry) {
				carry = carry + (ret[size_1 + size_2 - 1 - (size_1 - 1 - j) - (size_2 - 1 - i)] - '0');
				carry = carry % 10;
				ret[size_1 + size_2 - 1 - (size_1 - 1 - j) - (size_2 - 1 - i)] = carry + '0';

			}
		}

		//delete all leading 0s
		while (ret[0] == '0' && (ret.size() > 1)) {
			ret.erase(0,1);
		}
			

		return ret;
	}
};

int main() {
	cout << " Function Starts ! \n";

	Solution sol;

	string input1, input2;
	cout << " Giving first string : ";
	cin >> input1; 
	cout << " Giving second string : ";
	cin >> input2;

	auto output = sol.multiply(input1, input2);

	cout << " Output number is : " << output << "\n";


	return 0;
}