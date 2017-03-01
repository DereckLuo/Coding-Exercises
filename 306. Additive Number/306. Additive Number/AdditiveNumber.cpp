/**
 *	306. Additive Number:
 *		Additive number is a string whose digits can form additive sequence
 *	A valid additive sequence should contain at least three numbers. Except for the first two number, each
 *	subsequence number in the sequence must be the sun of the preceding two.
 *	For example: 
 *	"112358" is an additive number because the digits can form an additive sequence: 1,1,2,3,4,8.
 *	1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *	"199100199" is also an additive number, the additive sequence is : 1, 99, 100, 199
 *	1 + 99 = 100, 99 + 100 = 199
 *	Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1,2,03 or 1,02,3 is invalid 
 *	Given a string sontain only digit '0' - '9', write a function to determine if it's an additive number. 
 *	Follow up:
 *		How would you handle overflow for every large input integers?
 **/

#include<iostream>
#include<string>

using namespace std;

class Solution {
public:
	bool isAdditiveNumber(string num) {
		if (num.size() < 3) return false; //case not valid size
		int end_idx = num.size() - 1;
			
		for (int i = end_idx; i > 1; i--) { //all posible last number i to end  
			if (num[i] != '0' || (num[i] == '0' && i == end_idx)) { //can not have leading zeros 
				int last = stonum(num, i, end_idx);
				cout << "last num is : " << last << "\n";
				for (int j = i - 1; j > 0; j--) {//all possible second last number j to i-1
					if (num[j] != '0' || (num[j] == '0' && j == i-1)) { //can not have leading zeros
						int s_last = stonum(num, j, i - 1);
						cout << "second to last num is : " << s_last << "\n";
						if (additive_help(num, last - s_last, s_last, j - 1))
							return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 *	More clear Recursive ideas :
	 *		num: the number string 
	 *		target : target number at the end of the string 
	 *		end : the ending pointer of the string 
	 *		return true if previous string can sum to the number 
	 **/
	bool additive_help(string num, int target, int current, int end) {
		//base case
		if (end == 0 && stonum(num, end, end) == target) return true;
		else if (end == 0 && stonum(num, end, end) != target) return false;
		else {
			for (int i = end; i >= 0; i--) {
				int temp = stonum(num, i, end);
				if (temp > target) return false;
				if (temp == target && i == 0) return true;
				if (temp == target) {
					return additive_help(num, current - target, target, i - 1);
				}
			}
			return false;
		}
	}

	/**
	 *	Recursive helper function:
	 *		num : the number string 
	 *		end : the ending of the string 
	 *		prev1 : 1st previous value 
	 *		prev2 : 2nd previous value 
	 *		Return true if the string up to the end is additive 
	 **/

	bool additiveRecursive(string num, int end, int & prev1, int & prev2) {

		//base case
		if (end == 2) {
			if (num[0] + num[1] == num[2]) 
				return true;
			else return false;
		}

		for (int i = end; i >= 3; i--) {
			//find matching additive number 
			int int1 = 0, int2 = 0;
			if (additiveRecursive(num, i - 1, int1, int2)) { //check if previous string is additive 
				//case it is 
				int current = stonum(num, i, end);
				if (int1 + int2 == current) {
					prev1 = int2; prev2 = current;
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 *	Function to transfer from string to integer
	 **/
	int stonum(string num, int begin, int end) {
		int ret = 0;
		while (begin <= end) {
			ret *= 10; ret += num[begin] - 48;
			begin++;
		}
		return ret;
	}
};



int main() {

	cout << "Function starts ! \n";
	Solution sol;

	//string input = "112358";
	//string input = "199100199";
	//string input = "1203";
	//string input = "101";
	string input = "211738";

	bool ret = sol.isAdditiveNumber(input);


	if (ret)
		cout << " It is Additive number string ! \n";
	else
		cout << "It is NOT Additive number string ! \n";



	return 0;
}