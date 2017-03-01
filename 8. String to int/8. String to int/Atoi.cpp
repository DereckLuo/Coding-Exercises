/**
* 8. String to Integer (atoi)
*		Implement atoi to convert a string to an integer.
*	Hint: carefully consider all possible input cases. If you want a challenge, please do not see below and
*	ask yourself what are the possible input cases.
*	Notes: It is intended for this problem to be specified vaguely (i.e., no given input specs).
*	you are responsible to gather all the input requirements up front
**/

#include<iostream>
#include<stdint.h>
#include<vector>
#include<string>

using namespace std;


class Solution {
public:
	int myAtoi(string str) {

		if (!str.size())
			return 0;

		cout << "cp 0\n";

		int ptr = 0; //the pointer to point at the string 
		int ret, count;
		ret = 0; count = 0; //return value and count value of how many digits
		bool positive = true;
		//assuming it is an decimal atoi
		//while loop to find the starting position of number
		while (str[ptr] == 32) {
			cout << (int)str[ptr] << "\n";
			ptr++;
			if (str[ptr] != '-' && str[ptr] != '+' && (str[ptr] < 48 && str[ptr] != 32) && str[ptr] > 57)
				return 0;
			if (str[ptr] == NULL)
				return 0;
		}

		if (str[ptr] == '-') {
			positive = false;
			ptr++;
		}
		else if (str[ptr] == '+')
			ptr++;
			
		
		//while loop to going through the possible number
		while ((str[ptr] > 47 && str[ptr] < 58)) {
			count++;
			//case the sign was not correct 
			if (count > 10) {
				if (positive)
					return INT_MAX;
				else
					return INT_MIN;
			}
			ret *= 10;
			if (positive) {
				ret += (int)str[ptr] - 48;
				if (ret < 0 ) {
					return INT_MAX;
				}
			}
			else {
				ret += -((int)str[ptr] - 48);
				if (ret > 0)
					return INT_MIN;
			}
			ptr++;
		}
		return ret;
	}

	int bettersolution(string str) {
		bool flagnum = false;
		int sign = 1;
		long long res = 0;
		for (auto curv : str)
		{
			if (!flagnum&&curv != ' ')
			{
				flagnum = true;
				if (curv == '-' || curv == '+')
				{
					if (curv == '-')
						sign = -1;
				}
				else
				{
					if (curv >= '0'&&curv <= '9')
					{
						res *= 10;
						res += curv - '0';
					}
					else
						return 0;
				}
			}
			else if (flagnum)
			{
				if (curv<'0' || curv>'9')
					return res*sign;
				else
				{
					res *= 10;
					res += curv - '0';
					if (res*sign > INT_MAX)
						return INT_MAX;
					if (res*sign < INT_MIN)
						return INT_MIN;
				}
			}

		}
		return res*sign;
	}
};


int main() {

	cout << "Function starts ! \n"; 

	Solution sol;

	int ret;

	string input = "      10522545459";
	cout << "Input string is : " << input << "\n";

	ret = sol.myAtoi(input);

	cout << " Output integer value is : " << ret << "\n";


	return 0;
}