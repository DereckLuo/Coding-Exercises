/**
 *	214. Shortest Palindrome:
 *		Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the 
 *	shortest palindrome you can find by performing this transformation
 *	For example:
 *		Given "aacecaaa", return "aaacecaaa"
 *		Given "abcd", return "dcbabcd"
 **/

#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Solution {
public:
	/**
	 *  4ms c++ KMP solution
	 **/
	string shortestPalindrome(string s) {
		int n = s.size();
		if (n <= 1) return s; //base case 

		string srv = s;
		reverse(srv.begin(), srv.end()); //reverse string s
		if (srv == s) return s; //case if the entire string is palindrome
		vector<int> lps(n, 0); //vector of size n, filling with 0s
		//find the longest palindrome substrings of s that starts from s's first char
		//That is, find the length of suffix of the srv that is a proper prefix of s
		//This is similar to building LPS table in the KMP algorithm
		int i = 1, j = 0;
		lps[0] = 0;
		while (i < n) {
			if (srv[i] == s[j]) {
				j++; lps[i] = j; i++;
			}
			else {
				if (j == 0) {
					i++;
				}
				else {
					j = lps[j - 1];
				}
			}
		}
		string suffix = s.substr(lps.back()); //use srv + suffix
		srv += suffix;
		return srv;
	}

	/** 
	 * Interesting reverse string solution
	 *	Reverse s at first and compare substr of s with its reversed version
	 *	Comparing the substring between original one and reversed one can find the palindrome
	 *  running time not fast enough 160ms
	 **/
	string shortestPalindromeSlow(string s) {
		int size = s.size();
		if (size == 0) return s; //base case 

		int i = size;
		string v = s; 
		reverse(v.begin(), v.end()); //reverse the string s

		//initial string aabbccdef
		//reverse string fedccbbaa
		for (; i >= 1; i--) { //i = string length; i--
			cout << " i is : " << i << "\n";
			cout << s.substr(0, i) << "\n";
			cout << v.substr(size - i) << "\n\n";
			if (s.substr(0, i) == v.substr(size - i)) break; //find the longest palindrome
		}
		for (; i < s.size(); i += 2)
			s = s[i] + s; //constructing return value 
		return s;
	}

	/**
	 *	The problem becomes finding the longest palindrome in the string which includes the first letter
	 *	Working solution, however, does running really slow if input string contains too mainy characters matches the initial character
	 **/
	string shortestPalindromeTimeout(string s) {
		string ret = ""; //the return string 
		if (s.size() <= 1) return s;
		int palindrome_length = 0; //the int to track the longest palindrome which includes the first letter
		int index = 0; //the index to check the end of checking string

		//find the longest palindrome which contains the first character 
		while (index < s.size()) {
			if (s[index] == s[0]) {
				if (isPalindrome(s, index)) {
					palindrome_length = index; //update palindrome length
				}
			}
			index++;
		}
		
		//building return string 
		for (int i = s.size() - 1; i > palindrome_length; i--) {
			ret += s[i];
		}
		ret += s;


		return ret;
	}

	/**
	 * Check if a string is palindrome
	 **/
	bool isPalindrome(string s, int end) {
		//base case
		if (s.empty()) return false;
		if (end == 0) return true;

		int head = 0, tail = end;
		while (head <= tail) {
			if (s[head] != s[tail])
				return false;
			else {
				head++; tail--;
			}
		}
		return true;
	}
};

int main() {
	cout << "Function Starts ! \n";
	Solution sol;

	string input;
	cout << "Enter input string : ";
	cin >> input;

	auto output = sol.shortestPalindrome(input);

	cout << " Output string is : " << output << "\n";

	return 0;
}