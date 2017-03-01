/**
 *	166. Fraction to Recurring Decimal
 *		Given two integers representing the numerator and denominator of a fraction, return the fraction
 *	in string format
 *	If the fraction part is repeating, enclose the repeating part in parentheses.
 *	For example,
 *		Given numerator = 1, denominator = 2, return "0.5".
 *		Given numerator = 2, denominator = 1, return "2".
 *		Given numerator = 2, denominator = 3, return "0.(6)"
 **/

#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
#include<map>
#include<unordered_map>


using namespace std;

class Solution {
public:
	string fractionToDecimal(int numerator, int denominator) {
		string ret; // the returning string 
		//if can perfect devide 
		if (denominator == 1 || denominator == -1) {
			if (denominator == 1) {
				return to_string(numerator);
			}
			else {
				return to_string(numerator*(-1));
			}
		}
		if (numerator % denominator == 0) {
			ret = to_string(numerator / denominator);
			return ret;
		}
		cout << "cp 0 \n";
		//checking positive or negative 
		if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
			cout << "cp -- \n";
			ret = ret + '-';
			numerator = abs(numerator); denominator = abs(denominator);
		}
			
		//have decimal points 
		if (numerator > denominator) { // > 1
			ret = ret + to_string(numerator / denominator);
			ret = ret + '.';
			numerator = numerator % denominator;
		}
		else { // < 1
			ret = ret + "0.";
		}
		//completeing remaining number 
		string frac; //string to hold what's befind the decimal
		int pos = 0;
		map<int, int> table; //table match remainder with string position
		//table[numerator] = 0; //store the numerator value 
		while (numerator != 0) {
			//pos++;
			//cout << "cp 1, numerator is : " << numerator << " denominator is : " << denominator << "\n";
			if (table.find(numerator) != table.end()) {//case has a repeat
				//cout << "cp 2\n";
				frac += ")";
				frac.insert(table[numerator], "(");
				break;
			}
			else {
				//cout << "cp 3, numerator is : " << numerator << " denominator is : " << denominator <<"\n";
				table[numerator] = pos;
				numerator *= 10;
				frac = frac + to_string(numerator / denominator);
				numerator = numerator % denominator;
				pos++;
			}
		}
		ret = ret + frac;
		return ret;
	}

	/**
	 *	Same idea, using longlong working solution 
	 **/
	string fractionToDecimalWorking(int numerator, int denominator) {
		if (!numerator)return "0";
		string ret;
		long long num = llabs(numerator), deno = llabs(denominator);
		if (numerator<0 ^ denominator<0) ret += '-';
		ret += to_string(num / deno);
		if (!(num = num%deno))return ret;
		unordered_map<int, int> m;
		ret += '.';
		while (!m.count(num)) {
			m[num] = ret.size();
			while ((num *= 10)<deno) ret += '0', m[num] = ret.size();
			ret += '0' + num / deno;
			if (!(num = num%deno))return ret;
		}
		ret.insert(m[num], 1, '(');
		ret.insert(ret.size(), 1, ')');
		return ret;
	}
};

int main() {
	cout << "Function Starts ! \n";

	Solution sol;
	//cout << 7 % 5 << "\n";

	auto output = sol.fractionToDecimal(-1, INT_MIN);
	cout << "Output is : " << output << "\n";

	return 0;
}