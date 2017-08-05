package com.company;

public class Main {

    /**
     * 322. Coin Change
     *      You are given coins of different denominations and a total amout of money
     *      amount. Write a function to compute the fewest number of coins that you need
     *      to make up the amount. If that amount of money cannot be made up by
     *      any combination of the coins, return -1;
     *      Example 1:
     *      coins = [1,2,5], amount = 11
     *      return 3 (11 = 5 + 5 + 1)
     */
    public static void main(String[] args) {
	// write your code here
        int[] coins = {1,2,5};
        int amount = 11;
        Solution sol = new Solution();

        int output = sol.coinChange(coins, amount);
        System.out.println(output);
    }
}
