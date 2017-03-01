/**
 *	299. Bulls and Cows:
 *		You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to 
 *	guess what the number is. Each time your friend makes a guess, you provide a hint that indicate how many digits
 *	in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match
 *	the secret number but location in the wrong position(called "cows"). Your friend will use successive guesses and hints
 *	to eventually derive the secret number.
 *	For example:
 *		secret number: "1807"
 *		Friend's guess: "7810"
 *	Hint: 1 bul and 3 cows. (The Bull is 8, and cows are 0, 1 and 7)
 *	write a function to return a hint according to the secret number and friend's guess, use A to indiate the bulls and
 *	B to indicate the cows. In the above example, your function should return "1A3B".
 *	Please note that both secret number and friend's guess may contain duplicate digits, for example:
 *	Secret number: "1123"
 *	Friend's guess: "0111"
 *	In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return 
 *	"1A1B"
 *	You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 **/

#include<iostream>
#include<string>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	string getHint(string secret, string guess) {
		int size = secret.size();
		//two vector to store number of numbers in each string
		vector<int> secret_table; vector<int> guess_table;
		for (int i = 0; i < 10; i++) {
			secret_table.push_back(0);
			guess_table.push_back(0);
		}
		int bulls = 0, cows = 0;

		//looping through two strings 
		for (int i = 0; i < size; i++) {
			int secret_val = secret[i] - 48;
			int guess_val = guess[i] - 48;
			//cout << "secret is : " << secret_val << " guess_val is : " << guess_val << "\n";
			if (secret_val == guess_val) bulls++;
			else {
				secret_table[secret_val]++;
				guess_table[guess_val]++;
			//	cout << " s table value : " << secret_table[secret_val] << " g table value : " << guess_table[guess_val] << "\n\n";
			}	
		}

		//calculating all the cows
		for (int i = 0; i < secret_table.size(); i++) {
			cows += min(secret_table[i], guess_table[i]);
		}

		//print out solution
		//cout << bulls << "A" << cows << "B\n";
		string ret = to_string(bulls) + 'A' + to_string(cows) + 'B';
		return ret;
	}
};


int main() {
	cout << "Function Starts ! \n";

	Solution sol;

	string output = sol.getHint("", "");

	cout << output << "\n";

	return 0;
}