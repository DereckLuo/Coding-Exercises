/**
 *	6. ZigZag Conversion:
 *		The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 *	(you may want to display this pattern in a fixed font for better legibility)
 *	P	A	H	N
 *	A P L S I I G
 *	Y	I	R
 *	And then read line by line: "PAHnAPLSIIGYIR"
 *	Write the code that will take a string and make this conversion given a number of rows:
 *	string convert(string text, int nRows)
 *	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 **/

#include <iostream>
#include <stdio.h>
#include <string>

using namespace std; 

class Solution {
public:
	string convert(string s, int numRows) {
		string ret; 

		if (numRows == 1)
			return s;
		if (numRows <= 0)
			return ret; 

		for (int i = 0; i < numRows; i++) {
			//going over # of rows 
			int size = s.size(); //string size 
			bool check = true; // a alternating flag
			bool end;
			int ptr = i; //a pointer
			if (ptr == 0 || ptr == numRows - 1)
				end = true;
			else
				end = false; 

			while (ptr < size) {
				ret.push_back(s[ptr]); //store into string 

				//calculating next position 
				if (end) {
					
					ptr += (numRows + numRows - 2);
				}
				else {
					if (check) {
						ptr += 2 * (numRows - 1 - i);
					}
						
					else
						ptr += (2 * i); 
					check = !check;
				}
			}
		}

		return ret; 
	}
};

int main() {

	Solution sol;

	string input = "ABCDEFGHIJKLMN";
	string output;

	cout << " Input string is : " << input << "\n";

	output = sol.convert(input, 5);

	cout << " Output string is : " << output << "\n";

	return 0;
}