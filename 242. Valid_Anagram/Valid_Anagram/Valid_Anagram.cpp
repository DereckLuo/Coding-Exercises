#include <stdio.h>
#include <string>
#include <iostream>

using namespace std;

bool isAnagram(std::string s, std::string t) {
	if (s.size() != t.size()) return false;
	int table[128] = { 0 }; //the histogram table
	for (int i = 0; i < s.size(); i++) {
		table[int(s[i])] ++; table[int(t[i])]--;
	}
	for (int i = 0; i < 128; i++) {
		if (table[i] != 0) return false;
	}
	return true;
}


int main() {

	std::string a, b;

	std::cout << " Valid Anagram function starts \n";
	std::cout << "Please enter the first string \n";
	std::cin >> a;
	std::cout << "Please enter the second string \n";
	std::cin >> b;

	if (isAnagram(a, b)) cout << "input IS anagram\n";
	else cout << "input is NOT anagram\n";

	return 0;
}
