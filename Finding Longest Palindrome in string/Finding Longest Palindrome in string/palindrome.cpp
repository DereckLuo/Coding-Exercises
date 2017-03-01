/**
 *	Problem:
 *		Given a string input, finding the longest palindrome in the string.
 *	Return requirement:
 *		the length of the palindrome
 *		begin and end of the palindrome
 *		output the palindrome on the screen
 **/

#include<iostream>
#include<string>
#include<vector>


using namespace std;

/**
 *	The brute force way to find the longest palindrome
 **/
int maxPalindromforce(string s, int& start, int& end) {
	int ret = 0; start = 0; end = 0; //the length of the palindrome starts at 0

	//two for loops to check all substrings
	for (int i = 0; i < s.length(); i++) {	//starting of the substring 
		for (int j = i; j < s.length(); j++) { //ending of the substring 
			int s_start = i, s_end = j;
			bool check = true;
			while (s_start < s_end) {
				if (s[s_start] != s[s_end]) {
					check = false;
					break;
				}
				s_start++; s_end--;
			}
			if (check) {//case its a palindrome
				if (j - i > ret) {
					ret = j - i; start = i; end = j;
				}
			}
		}
	}
	//printing out the palindrom
	for (int i = start; i <= end; i++) {
		cout << s[i]; 
	}
	cout << "\n";
	return ret;
}


/**
 *	The Dynamic programing method to find the longest palindrome
 *	Using a 2D array to store the information: array[][]
 *	array[a][b] indicate if the substring starting from a ending at b is a palindrom
 *	calculating array[a][b] by checking the value of array[a+1][b-1] and check s[a] == s[b]
 **/
int maxPalindromeDP(string s, int& start, int& end) {
	int maxlength = 0; start = 0; end = 0;
	int n = s.size();
	//creating table, cause can't use array, it is in n^2 time already =(
	vector<vector<bool>> table;
	for (int i = 0; i < n; i++) {
		vector<bool> temp;
		for (int j = 0; j < n; j++) {
			temp.push_back(false);
		}
		table.push_back(temp);
	}

	//all length 1 subarray is palindrome
	for (int i = 0; i < n; i++) {
		table[i][i] = true;
	}

	//check all length of 2 subarrays 
	for (int i = 0; i < n - 1; i++) {
		if (s[i] == s[i + 1]) {
			table[i][i + 1] = true;
			maxlength = 2;
		}
	}

	//check rest length of strings 
	for (int i = 3; i <= n; i++) { //loop through all substring length 
		for (int j = 0; j <= n - i; j++) {//loop through all starting positions 
			int end_idx = j + i - 1; 
			if (s[j] == s[end_idx] && table[j + 1][end_idx - 1]) {//case it is a palindrome
				table[j][end_idx] = true;
				if (i > maxlength) {
					maxlength = i; start = j; end = end_idx;
				}
			}
		}
	}

	//printing out the palindrome
	for (int i = start; i <= end; i++) {
		cout << s[i];
	}
	cout << "\n";

	return maxlength;

}

int main() {

	cout << " Function Starts ! \n";

	string input = "abccbaadlsdkfalaaabbbcccdddcccbbbaaaadjfdsha";
	int start, end;
	int ret = maxPalindromforce(input, start, end);
	ret = maxPalindromeDP(input, start, end);

	cout << " Longest palindrom length is : " << ret << " starts at : " << start << " ends at : " << end << "\n";
	return 0;
}