/**
 *	49. Group Anagrams
 *		Given an array of strings, group anagrams together
 *	For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *	Return:
 *	[
 *		["ate", "eat", "tea"],
 *		["nat", "tan"],
 *		["bat"]
 *	]
 **/


#include<iostream>
#include<vector>
#include<string>
#include<array>
#include<map>
#include<algorithm>

using namespace std;



class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		vector<vector<string>> ret;
		for (int i = 0; i < strs.size(); i++) {//loop through all input strings 
			vector<string> temp;
			if (ret.size() == 0) {
				temp.push_back(strs[i]);
				ret.push_back(temp);
			}
			else {
				bool find = false;
				if (ret.size() == 0)
					ret[0].push_back(strs[i]);
				for (int j = 0; j < ret.size(); j++) {
					if (isAnagrams(ret[j][0], strs[i])) {//case it is a anagram for this group
						ret[j].push_back(strs[i]);
						find = true;
					}
				}
				if (!find) {
					temp.push_back(strs[i]);
					ret.push_back(temp);
				}
			}
		}
		return ret;
	}

	/**
	 *	Function to check if two strings are anagrams 
	 *	input two strings
	 *	output : true or false 
	 *	clever approach, BUT DOESNT WORK!!
	 **/
	bool isAnagramsNOTWORK(string & a, string & b) {
		if (a.size() != b.size()) return false; //size doesn't match 
		int count = 0;
		for (int i = 0; i < a.size(); i++) {//loop thorugh the string
			count += int(a[i]); count -= int(b[i]);
		}
		if (count == 0) return true;
		else return false;
	}

	/**
	 *	Function to check if two strings are anagrams of each other 
	 *	input two strings
	 *	output: true or false
	 *	using array to act as histogram which store frequency of two strings 
	 **/
	bool isAnagrams(string& a, string& b) {
		if (a.size() != b.size()) return false; 
		int table[128] = { 0 }; //the histogram table
		for (int i = 0; i < a.size(); i++) {
			table[int(a[i])] ++; table[int(b[i])]--;
		}
		for (int i = 0; i < 128; i++) {
			if (table[i] != 0) return false;
		}
		return true;
	}

	/**
	 *	Function to print out anagram strings
	 **/
	void printAnagram(vector<vector<string>> input) {
		cout << "[";
		for (int i = 0; i < input.size(); i++) {
			cout << "[";
			for (int j = 0; j < input[i].size(); j++) {
				cout << "\"" << input[i][j] << "\",";
			}
			cout << "],";
		}
		cout << "]\n";
	}

	/**
	 *	Function to create the input to calculate 
	 **/
	vector<string> createinput() {
		vector<string> ret;
		ret.push_back("e*a*t");
		ret.push_back("tea**");
		ret.push_back("ta**n");
		ret.push_back("**ate");
		ret.push_back("nat");
		ret.push_back("bat");
		return ret;
	}

	/**
	 *	Interesting solution which using map and string sort and compare to find anagrams
	 **/
	vector<vector<string> > groupAnagramsSmart(vector<string>& strs) {
		vector<vector<string> > res;
		if (strs.empty()) return res;
		map<string, int> m;
		int pos = 0;
		for (int i = 0; i<strs.size(); ++i)
		{
			string tmp(strs[i]);
			sort(tmp.begin(), tmp.end());
			map<string, int>::iterator it = m.find(tmp);
			if (it != m.end())  //find
			{
				res[it->second].push_back(strs[i]);
			}
			else {
				vector<string> v;
				v.push_back(strs[i]);
				res.push_back(v);
				m.insert(pair<string, int>(tmp, pos++));
			}
		}
		return res;
	}
};


int main() {
	cout << "Function Starts ! \n";
	Solution sol;

	vector<string> input = sol.createinput();
	vector<vector<string>> output = sol.groupAnagrams(input);
	sol.printAnagram(output);
	

	return 0;
}