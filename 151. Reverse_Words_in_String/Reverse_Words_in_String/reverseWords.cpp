/**
 *		151. Reverse Words in String
 *	Given an input string, reverse the string word by word. 
 *	For example,
 *	Given s = "the sky is blue",
 *	Return "blue is sky the".
 *	For C programmers: Try to solve it in-place in O(1) space
 **/

#include<iostream>
#include<string>
#include<stdio.h>
#include<stack>

using namespace std;

class Solution {
public:
	void reverseWords(string &s) {
		stack<string> cup; 
		int space = 32; //ASCII value for space

		if (s.size() == 0)
			return; 

		string temp;
		for (int i = 0; i <= s.size(); i++) { //looping through the string 
			if (s[i] == space || s[i] == NULL) {
				if (temp.size()) {
					cup.push(temp);
					temp.clear();
				}		
			}
			else {
				temp.push_back(s[i]);
			}
		}

		s.clear();

		while (!cup.empty()) {
			for (int i = 0; i < cup.top().size(); i++) {
				s.push_back(cup.top()[i]);
			}
			cup.pop();
			if(!cup.empty())
				s.push_back(space);
		}
	}


	/**
	 *	In place swap solution try out 
	 **/
	
	void swaptest2(string & s) {
		if (s.size() == 0)
			return;
		int begin, end;

		begin = 0; end = s.size() - 1;

		while (begin != s.size() - 1) {
			while (begin <= end) {
				int temp = s[begin]; s[begin] = s[end]; s[end] = temp;
				begin++; end--;
			}
			end = s.size() - 1;
		}
	}
};

int main() {

	cout << "Function starts \n"; 

	Solution sol; //the solution class


	string input = "This is Recursive"; 
	//string input = "+---...2x+--x--+x-+-x2...---+";
	//string input = " 1";

	cout << "Input String is : " << input;
	cout << "\n"; 

	sol.reverseWords(input);

	cout << " Final output String is : " << input << "\n"; 


	return 0;
}