/**
*	122. Best Time to Buy and Sell Stock II
 *	Say you have an array for which the ith element is the price of a given stock on day i.
 *	Design an algorithm to find the maximum profit. You may compelte as many transactions as you like 
 *	(ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
 *	transactions at this same time (ie, you must sell the stock before you buy again)
 *		Different from previous one: No one day delay.
 **/

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	int maxProfit(vector<int>& prices) {
		if (prices.size() == 0) return 0;

		//two maps to track DP
		vector<int> full_map, empty_map; //using to store stock profit in DP
		for (int i = 0; i < prices.size() + 1; i++) {
			full_map.push_back(-1);
			empty_map.push_back(-1);
		}

		int ret = profithelpDP(prices, 0, 0, full_map, empty_map);

		//int ret = maxProfitInDP(prices);

		return ret;

	}

	/**
	 *	Inetersting DP solution, hope it works 
	 *	empty_hold : profit for empty hold 
	 *	full_hold : profit for full hold 
	 *	sell : profit for sell
	 *	buy : profit for buy
	 **/

	int maxProfitInDP(vector<int> & prices) {
		//coner cases
		if (prices.size() <= 1)
			return 0;
		//three variables to track profit for three actions 
		//initial profits values 
		int empty_hold = 0, full_hold = -prices[0],  sell = 0, buy = -prices[0];
		//loop through all prices
		for (int i = 1; i < prices.size(); i++) {
			int temp = max(sell, empty_hold);
			int temp2 = sell;
			sell = max(full_hold, buy) + prices[i];
			buy = max(empty_hold, temp2) - prices[i];
			full_hold = max(full_hold, buy);
			empty_hold = temp;
		}
		
		return max(sell, empty_hold); //return max of sell or hold in the end, buy will not make in place

	}

	/**
	 *	The Dynamic programming version. 
	 **/
	int profithelpDP(vector<int> prices, int pos, int hold, vector<int> full_map, vector<int>& empty_map) {
		int ret; //the return profit 
		//base case 
		if (pos >= prices.size()) return 0;

		//recursion as current profit + whatever profit behind this point until the end
		if (hold) {
			//case the stock is bought already
			int sell, no_sell;
			if (empty_map[pos + 1] == -1)
				sell = profithelpDP(prices, pos + 1, 0, full_map, empty_map) + prices[pos];
			//sell at this point : sell profit + profit afterwards 
			else
				sell = empty_map[pos + 1] + prices[pos];
			if (full_map[pos + 1] == -1)
				no_sell = profithelpDP(prices, pos + 1, hold, full_map, empty_map);
			//not sell at this point : later profit 
			else
				no_sell = full_map[pos + 1];
			full_map[pos] = max(sell, no_sell);
			return full_map[pos];
		}
		else {
			//case the stock is not bought before 
			int buy, no_buy;
			if (full_map[pos + 1] == -1)
				buy = profithelpDP(prices, pos + 1, 1, full_map, empty_map) - prices[pos];
			//buy at this point : later profit - current price
			else
				buy = full_map[pos + 1] - prices[pos];
			if (empty_map[pos + 1] == -1)
				no_buy = profithelpDP(prices, pos + 1, 0, full_map, empty_map);
			//not buy at this point : later profit 
			else
				no_buy = empty_map[pos + 1];
			empty_map[pos] = max(no_buy, buy);
			return empty_map[pos];
		}
	}

	/**
	 * Even more smart ass solution
	 **/
	int SmartAss(vector<int>& prices) {
		int sum = 0;
		for (int i = 1; i < prices.size(); ++i)
			//looping through the array 
			if (prices[i] > prices[i - 1]) sum += prices[i] - prices[i - 1]; // if can make a profit, add to the profit 
		return sum;
	}

	void printlist(vector<int> input) {
		for (int i = 0; i < input.size(); i++)
			cout << input[i] << " ";
		cout << "\n";
	}
};


int main() {

	cout << " Function Starts ! \n";

	Solution sol;

	vector<int> prices{ 1,3,1,2,1 };
	//vector<int> prices{ 1,2,4 };

	sol.printlist(prices);

	cout << " Smart solution is : \n";
	int profit = sol.maxProfitInDP(prices);
	cout << " The smart profit is : " << profit << "\n";

	cout << "DP solution is : \n";
	profit = sol.maxProfit(prices);

	cout << "The final Profit is : " << profit << "\n";

	return 0;
}