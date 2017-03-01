/** 
 *	205. Isomorphic Strings
 *		Given two strings s and t, determine if they are isomorphic
 *	Two strings are isomorphic if the characters in s can be replaced to get t
 *	All occurrences of a character must be replaced with another character while preserving the order of characters. No
 *	two characters may map to the same character but a character may map to itself
 *	For example, 
 *		Given "egg", "add", return true
 *		Given "foo", "bar", return false
 *		Given "paper", "title", return true;
 *	You may assume both s and t have the same length
 **/

#include<iostream>
#include<string>
#include<unordered_map>

using namespace std;


class Solution {
public:
	/** 
	 * Case sensative, simply using a map
	 **/
	bool isIsomorphic(string s, string t) {
		unordered_map<int, int> table; //the table to store the match
		for (int i = 0; i < s.size(); i++) {//loop through string 
			if (table.find(t[i]) == table.end()) {//case element not in the table
				table[t[i]] = s[i]; //store into the map
			}
			else {
				if(table[t[i]] != s[i]) return false;
			}
		}
		return true;
	}
};

int main() {
	cout << "Function Starts ! \n";
	Solution sol;

	string s1, s2;
	cout << "Input string 1 : ";
	cin >> s1;
	cout << "Input string 2 : ";
	cin >> s2; 

	if (sol.isIsomorphic(s1, s2)) cout << "True! \n";
	else cout << "False! \n";

	return 0;
}